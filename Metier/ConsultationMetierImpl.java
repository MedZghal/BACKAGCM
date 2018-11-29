package com.perfectsolution.Clinique.Metier;

import org.springframework.stereotype.*;
import com.perfectsolution.Clinique.Dao.*;
import org.springframework.beans.factory.annotation.*;
import com.perfectsolution.Clinique.Entities.*;
import java.util.*;

@Service
public class ConsultationMetierImpl implements ConsultationMetier
{
    @Autowired
    public ConsultationRepository consultationRepository;
    
    @Override
    public List<Consultation> getListConsultationsbyPatient(final int num_patient) {
        return this.consultationRepository.getListConsultationsbyPatient(num_patient);
    }
    
    @Override
    public Optional<Consultation> FindConsult(final int num_consult) {
        return (Optional<Consultation>)this.consultationRepository.findById((Object)num_consult);
    }
}
