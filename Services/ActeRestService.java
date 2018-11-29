package com.perfectsolution.Clinique.Services;

import com.perfectsolution.Clinique.Metier.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import com.perfectsolution.Clinique.Entities.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ActeRestService
{
    @Autowired
    public ActeMetier acteMetier;
    
    @GetMapping({ "/ListActesbyPatient" })
    public List<Acte> getListActesbyPatient(@RequestParam final int num_patient) {
        return this.acteMetier.getListActesbyPatient(num_patient);
    }
}
