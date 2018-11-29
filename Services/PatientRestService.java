package com.perfectsolution.Clinique.Services;

import com.perfectsolution.Clinique.Metier.*;
import org.springframework.beans.factory.annotation.*;
import com.perfectsolution.Clinique.Entities.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class PatientRestService
{
    @Autowired
    private PatientMetier patientMetier;
    
    @GetMapping({ "/Patient" })
    public Optional<Patient> GetPatientById(@RequestParam final int num_patient) {
        return this.patientMetier.GetPatientById(num_patient);
    }
    
    @GetMapping({ "/ListPatients" })
    public List<Patient> listPatients() {
        return this.patientMetier.listPatients();
    }
}
