package com.perfectsolution.Clinique.Metier;

import org.springframework.stereotype.*;
import com.perfectsolution.Clinique.Dao.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import com.perfectsolution.Clinique.Entities.*;

@Service
public class FileUploadMetierImpl implements FileUploadMetier
{
    @Autowired
    public FileUploadRepository fileUploadRepository;
    
    @Override
    public List<FileUpload> GetlistFileUp(final int num_patient) {
        return this.fileUploadRepository.GetlistFileUp(num_patient);
    }
}
