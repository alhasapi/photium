package com.alhasapi.Photium.web;


import com.alhasapi.Photium.model.Photo;
import com.alhasapi.Photium.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotiumController {

    public final PhotoService photoService;

    public PhotiumController(PhotoService photoService) {
        this.photoService = photoService;
    }


    @GetMapping("/hello")
    public String hello() {
        return "Hello Universe!";
    }

    @GetMapping("/photo")
    public Collection<Photo> get() {
        return photoService.get();
    }

    @GetMapping("/photo/{id}")
    public Photo get(@PathVariable String id) {
        Photo photo = photoService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }
    @DeleteMapping("/photo/{id}")
    public void delete(@PathVariable String id) {
        Photo photo = photoService.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/photo")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return photoService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}
