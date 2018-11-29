package com.perfectsolution.Clinique.Metier;

import com.perfectsolution.Clinique.Entities.*;
import java.util.*;

public interface ConsultationMetier
{
    List<Consultation> getListConsultationsbyPatient(final int num_patient);
    
    Optional<Consultation> FindConsult(final int num_consult);
}
