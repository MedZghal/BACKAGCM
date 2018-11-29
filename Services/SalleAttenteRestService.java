package com.perfectsolution.Clinique.Services;

import com.perfectsolution.Clinique.Metier.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import com.perfectsolution.Clinique.Entities.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class SalleAttenteRestService
{
    @Autowired
    private SalleAttenteMetier attenteMetier;
    
    @GetMapping({ "/ListAttentes" })
    public List<SalleAttente> getSalleAttentebyMedecin(@RequestParam final int codMed) {
        return this.attenteMetier.getSalleAttentebyMedecin(codMed);
    }
}
