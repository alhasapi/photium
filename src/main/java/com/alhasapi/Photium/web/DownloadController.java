package com.alhasapi.Photium.web;

import com.alhasapi.Photium.model.Photo;
import com.alhasapi.Photium.service.PhotoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {
    public final PhotoService photoService;

    public DownloadController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id) {
        Photo photo = photoService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        byte[] data =  photo.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        ContentDisposition build = ContentDisposition
                                        .builder("attachment")
                                        .filename(photo.getFileName())
                                        .build();
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

}
