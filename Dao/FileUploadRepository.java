package com.perfectsolution.Clinique.Dao;

import com.perfectsolution.Clinique.Entities.*;
import org.springframework.data.repository.query.*;
import java.util.*;
import org.springframework.data.jpa.repository.*;

public interface FileUploadRepository extends JpaRepository<FileUpload, Integer>
{
    @Query("SELECT f FROM FileUpload f WHERE f.numPatient.numFichPatient = :numPatient")
    List<FileUpload> GetlistFileUp(@Param("numPatient") final int num_patient);
}
