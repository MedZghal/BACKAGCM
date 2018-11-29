package com.perfectsolution.Clinique.Dao;

import org.springframework.data.jpa.repository.*;
import com.perfectsolution.Clinique.Entities.*;
import org.springframework.stereotype.*;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>
{
}
