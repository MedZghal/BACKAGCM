package com.perfectsolution.Clinique.Metier;

import com.perfectsolution.Clinique.Entities.*;
import java.util.*;

public interface PatientMetier
{
    Optional<Patient> GetPatientById(final int num_patient);
    
    List<Patient> listPatients();
}
