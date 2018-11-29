package com.perfectsolution.Clinique.Dao;

import com.perfectsolution.Clinique.Entities.*;
import org.springframework.stereotype.*;
import org.springframework.data.repository.query.*;
import java.util.*;
import org.springframework.data.jpa.repository.*;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Integer>
{
    @Query("SELECT c FROM Consultation c WHERE c.numPatient.numFichPatient = :numPatient")
    List<Consultation> getListConsultationsbyPatient(@Param("numPatient") final int num_patient);
}
