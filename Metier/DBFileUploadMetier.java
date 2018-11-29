package com.perfectsolution.Clinique.Metier;

import org.springframework.web.multipart.*;
import com.perfectsolution.Clinique.Entities.*;
import java.util.*;

public interface DBFileUploadMetier
{
    DBFileUpload storeFile(final MultipartFile file, final int num_patient);
    
    DBFileUpload getFile(final String fileId);
    
    void DeleteFile(final String fileId);
    
    List<DBFileUpload> getAllFile();
    
    List<DBFileUpload> getFilebyPatient(final int num_patient);
}
