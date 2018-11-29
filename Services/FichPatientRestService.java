package com.perfectsolution.Clinique.Services;

import com.perfectsolution.Clinique.Metier.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import com.perfectsolution.Clinique.Entities.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class FichPatientRestService
{
    @Autowired
    public FichPatientMetier fichPatientMetier;
    
    @GetMapping({ "/PatientByCodMed" })
    public List<Patient> getPatientByCodMed(@RequestParam final int codeMedTrit) {
        return this.fichPatientMetier.getPatientByCodMed(codeMedTrit);
    }
    
    @GetMapping({ "/PatientPartagByCodMed" })
    public List<Patient> getPatientPartagByCodMed(@RequestParam final int codeMedTrit) {
        return this.fichPatientMetier.getPatientPartagByCodMed(codeMedTrit);
    }
}
