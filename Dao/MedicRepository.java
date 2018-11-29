package com.perfectsolution.Clinique.Dao;

import org.springframework.data.repository.query.*;
import java.util.*;
import com.perfectsolution.Clinique.Entities.*;
import org.springframework.data.jpa.repository.*;

public interface MedicRepository extends JpaRepository<Medicament, Integer>
{
    @Query("SELECT p FROM PrescriptionOrd p WHERE p.prescriptionOrdPK.numOrd = :numOrd")
    List<PrescriptionOrd> GetListPrescriptionOrdByNumOrd(@Param("numOrd") final int numOrd);
}
