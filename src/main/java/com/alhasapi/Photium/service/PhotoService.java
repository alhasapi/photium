package com.alhasapi.Photium.service;

import com.alhasapi.Photium.model.Photo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotoService {
    public Map<String, Photo> db = new HashMap<>() {{
        put("0", new Photo("1", "name"));
    }};
    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setContentType(contentType);
        photo.setData(data);
        photo.setFileName(fileName);
        db.put(photo.getId(), photo);
        return photo;
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    public Photo get(String id) {
        return db.get(id);
    }

    public Collection<Photo> get() {
        return this.db.values();
    }
}
