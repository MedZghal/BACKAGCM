package com.perfectsolution.Clinique.Dao;

import com.perfectsolution.Clinique.Entities.*;
import org.springframework.stereotype.*;
import org.springframework.data.repository.query.*;
import java.util.*;
import org.springframework.data.jpa.repository.*;

@Repository
public interface ActeRepository extends JpaRepository<Acte, Integer>
{
    @Query("SELECT distinct a.acte FROM ActeMedicaux a WHERE a.consultation.numPatient.numFichPatient = :numPatient")
    List<Acte> getListActesbyPatient(@Param("numPatient") final int num_patient);
}
