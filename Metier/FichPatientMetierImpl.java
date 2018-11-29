package com.perfectsolution.Clinique.Metier;

import org.springframework.stereotype.*;
import com.perfectsolution.Clinique.Dao.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import com.perfectsolution.Clinique.Entities.*;

@Service
public class FichPatientMetierImpl implements FichPatientMetier
{
    @Autowired
    public FichPatientRepository fichPatientRepository;
    
    @Override
    public List<Patient> getPatientByCodMed(final int codeMedTrit) {
        return this.fichPatientRepository.getPatientByCodMed(codeMedTrit);
    }
    
    @Override
    public List<Patient> getPatientPartagByCodMed(final int codeMedTrit) {
        return this.fichPatientRepository.getPatientPartagByCodMed(codeMedTrit);
    }
}
