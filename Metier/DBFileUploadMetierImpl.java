package com.perfectsolution.Clinique.Metier;

import org.springframework.stereotype.*;
import com.perfectsolution.Clinique.Dao.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.multipart.*;
import com.perfectsolution.Clinique.Entities.*;
import org.springframework.util.*;
import java.io.*;
import com.perfectsolution.Clinique.Exception.*;
import java.util.*;

@Service
public class DBFileUploadMetierImpl implements DBFileUploadMetier
{
    @Autowired
    private DBFileUploadRepository bFileUploadRepository;
    
    @Override
    public DBFileUpload storeFile(final MultipartFile file, final int num_patient) {
        final String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            final DBFileUpload dbFile = new DBFileUpload(fileName, file.getContentType(), file.getBytes(), num_patient);
            return (DBFileUpload)this.bFileUploadRepository.save((Object)dbFile);
        }
        catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", (Throwable)ex);
        }
    }
    
    @Override
    public DBFileUpload getFile(final String fileId) {
        final MyFileNotFoundException ex;
        return this.bFileUploadRepository.findById((Object)fileId).orElseThrow(() -> {
            new MyFileNotFoundException("File not found with id " + fileId);
            return ex;
        });
    }
    
    @Override
    public List<DBFileUpload> getAllFile() {
        return (List<DBFileUpload>)this.bFileUploadRepository.findAll();
    }
    
    @Override
    public List<DBFileUpload> getFilebyPatient(final int num_patient) {
        return (List<DBFileUpload>)this.bFileUploadRepository.getFilebyPatient(num_patient);
    }
    
    @Override
    public void DeleteFile(final String fileId) {
        this.bFileUploadRepository.deleteById((Object)fileId);
    }
}
