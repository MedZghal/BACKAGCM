package com.perfectsolution.Clinique.Services;

import com.perfectsolution.Clinique.Metier.*;
import org.springframework.beans.factory.annotation.*;
import com.perfectsolution.Clinique.Entities.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class RdvRestService
{
    @Autowired
    public RdvMetier rdvMetier;
    
    @GetMapping({ "/RdvbyPatient" })
    public List<Rdv> getRdvbyPatient(@RequestParam final int num_patient) {
        return this.rdvMetier.getRdvbyPatient(num_patient);
    }
    
    @GetMapping({ "/RdvbyId" })
    public Optional<Rdv> FindRdv(@RequestParam final int num_rdv) {
        return this.rdvMetier.FindRdv(num_rdv);
    }
    
    @GetMapping({ "/GetRdvbyMed" })
    public List<Rdv> getRdvbyMed(final int num_med) {
        return this.rdvMetier.getRdvbyMed(num_med);
    }
    
    @GetMapping({ "/GetRdvbyMedDate" })
    public List<Rdv> getRdvbyMedDate(final int num_med, final Date datestart, final Date datefin) {
        return this.rdvMetier.getRdvbyMedDate(num_med, datestart, datefin);
    }
}
