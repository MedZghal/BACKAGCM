package com.perfectsolution.Clinique.Metier;

import org.springframework.stereotype.*;
import com.perfectsolution.Clinique.Dao.*;
import org.springframework.beans.factory.annotation.*;
import com.perfectsolution.Clinique.Entities.*;
import java.util.*;

@Service
public class RdvMetierImpl implements RdvMetier
{
    @Autowired
    public RdvRepository rdvRepository;
    
    @Override
    public List<Rdv> getRdvbyPatient(final int num_patient) {
        return this.rdvRepository.getRdvbyPatient(num_patient);
    }
    
    @Override
    public Optional<Rdv> FindRdv(final int num_rdv) {
        return (Optional<Rdv>)this.rdvRepository.findById((Object)num_rdv);
    }
    
    @Override
    public List<Rdv> getRdvbyMed(final int num_med) {
        return this.rdvRepository.getRdvbyMed(num_med);
    }
    
    @Override
    public List<Rdv> getRdvbyMedDate(final int num_med, final Date datestart, final Date datefin) {
        return this.rdvRepository.getRdvbyMedDate(num_med, datestart, datefin);
    }
}
