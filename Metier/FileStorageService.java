package com.perfectsolution.Clinique.Metier;

import org.springframework.stereotype.*;
import com.perfectsolution.Clinique.Entities.*;
import java.nio.file.attribute.*;
import org.springframework.web.multipart.*;
import org.springframework.util.*;
import java.nio.file.*;
import java.io.*;
import org.springframework.core.io.*;
import com.perfectsolution.Clinique.Exception.*;
import java.net.*;

@Service
public class FileStorageService
{
    private final Path fileStorageLocation;
    
    public FileStorageService(final FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir(), new String[0]).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation, (FileAttribute<?>[])new FileAttribute[0]);
        }
        catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }
    
    public String storeFile(final MultipartFile file) {
        final String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            final Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        }
        catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
    
    public Resource loadFileAsResource(final String fileName) {
        try {
            final Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            final Resource resource = (Resource)new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            }
            throw new MyFileNotFoundException("File not found " + fileName);
        }
        catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
}
