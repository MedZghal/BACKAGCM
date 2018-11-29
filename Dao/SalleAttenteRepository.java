package com.perfectsolution.Clinique.Dao;

import com.perfectsolution.Clinique.Entities.*;
import org.springframework.stereotype.*;
import org.springframework.data.repository.query.*;
import java.util.*;
import org.springframework.data.jpa.repository.*;

@Repository
public interface SalleAttenteRepository extends JpaRepository<SalleAttente, Integer>
{
    @Query("SELECT s FROM SalleAttente s WHERE s.numMedcTrait.codeMedTrit = :codeMedTrit")
    List<SalleAttente> getSalleAttentebyMedecin(@Param("codeMedTrit") final int codMed);
}
