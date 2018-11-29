package com.perfectsolution.Clinique.Services;

import com.perfectsolution.Clinique.Metier.*;
import org.springframework.beans.factory.annotation.*;
import com.perfectsolution.Clinique.Entities.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ConsultationRestService
{
    @Autowired
    public ConsultationMetier consultationMetier;
    
    @GetMapping({ "/ListConsultationsbyPatient" })
    public List<Consultation> getListConsultationsbyPatient(@RequestParam final int num_patient) {
        return this.consultationMetier.getListConsultationsbyPatient(num_patient);
    }
    
    @GetMapping({ "/ConsultationbyId" })
    public Optional<Consultation> FindConsult(@RequestParam final int num_consult) {
        return this.consultationMetier.FindConsult(num_consult);
    }
}
