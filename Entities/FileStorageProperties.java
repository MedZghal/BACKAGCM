package com.perfectsolution.Clinique.Entities;

import org.springframework.boot.context.properties.*;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties
{
    private String uploadDir;
    
    public String getUploadDir() {
        return this.uploadDir;
    }
    
    public void setUploadDir(final String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
