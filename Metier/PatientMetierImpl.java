package com.perfectsolution.Clinique.Metier;

import org.springframework.stereotype.*;
import com.perfectsolution.Clinique.Dao.*;
import org.springframework.beans.factory.annotation.*;
import com.perfectsolution.Clinique.Entities.*;
import java.util.*;

@Service
public class PatientMetierImpl implements PatientMetier
{
    @Autowired
    private PatientRepository patientRepository;
    
    @Override
    public List<Patient> listPatients() {
        return (List<Patient>)this.patientRepository.findAll();
    }
    
    @Override
    public Optional<Patient> GetPatientById(final int num_patient) {
        return (Optional<Patient>)this.patientRepository.findById((Object)num_patient);
    }
}
