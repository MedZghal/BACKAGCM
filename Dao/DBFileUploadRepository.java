package com.perfectsolution.Clinique.Dao;

import com.perfectsolution.Clinique.Entities.*;
import org.springframework.data.repository.query.*;
import java.util.*;
import org.springframework.data.jpa.repository.*;

public interface DBFileUploadRepository extends JpaRepository<DBFileUpload, String>
{
    @Query("SELECT d.id AS id,d.fileName AS fileName,d.fileType AS fileType FROM DBFileUpload d WHERE d.numPatient= :numPatient")
    List<DBFileUpload> getFilebyPatient(@Param("numPatient") final int num_patient);
}
