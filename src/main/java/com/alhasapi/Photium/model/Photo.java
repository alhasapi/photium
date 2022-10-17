package com.alhasapi.Photium.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.MediaType;

import javax.validation.constraints.NotEmpty;

public class Photo {
    private String id;
    @NotEmpty
    private String fileName;

    @JsonIgnore
    private byte[] data;

    private String contentType;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Photo() {

    }

    public Photo(String id, String fileName) {
        this.fileName = fileName;
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
