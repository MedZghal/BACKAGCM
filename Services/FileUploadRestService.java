package com.perfectsolution.Clinique.Services;

import com.perfectsolution.Clinique.Metier.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import com.perfectsolution.Clinique.Entities.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class FileUploadRestService
{
    @Autowired
    public FileUploadMetier fileUploadMetier;
    
    @GetMapping({ "/GetFileUpload" })
    public List<FileUpload> GetlistFileUp(@RequestParam final int num_patient) {
        return this.fileUploadMetier.GetlistFileUp(num_patient);
    }
}
