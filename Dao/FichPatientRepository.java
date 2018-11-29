package com.perfectsolution.Clinique.Dao;

import org.springframework.stereotype.*;
import org.springframework.data.repository.query.*;
import java.util.*;
import com.perfectsolution.Clinique.Entities.*;
import org.springframework.data.jpa.repository.*;

@Repository
public interface FichPatientRepository extends JpaRepository<FichPatient, FichPatientPK>
{
    @Query("SELECT f.patient FROM FichPatient f WHERE f.fichPatientPK.codeMedTrit = :codeMedTrit and LOCATE('partag\u00e9',f.partage)=0")
    List<Patient> getPatientByCodMed(@Param("codeMedTrit") final int codeMedTrit);
    
    @Query("SELECT f.patient FROM FichPatient f WHERE f.fichPatientPK.codeMedTrit = :codeMedTrit and LOCATE('partag\u00e9',f.partage)!=0")
    List<Patient> getPatientPartagByCodMed(@Param("codeMedTrit") final int codeMedTrit);
}
