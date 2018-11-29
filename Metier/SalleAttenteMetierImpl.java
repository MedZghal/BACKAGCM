package com.perfectsolution.Clinique.Metier;

import org.springframework.stereotype.*;
import com.perfectsolution.Clinique.Dao.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import com.perfectsolution.Clinique.Entities.*;

@Service
public class SalleAttenteMetierImpl implements SalleAttenteMetier
{
    @Autowired
    private SalleAttenteRepository attenteRepository;
    
    @Override
    public List<SalleAttente> getSalleAttentebyMedecin(final int codMed) {
        return this.attenteRepository.getSalleAttentebyMedecin(codMed);
    }
}
