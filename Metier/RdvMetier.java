package com.perfectsolution.Clinique.Metier;

import com.perfectsolution.Clinique.Entities.*;
import java.util.*;

public interface RdvMetier
{
    List<Rdv> getRdvbyPatient(final int num_patient);
    
    List<Rdv> getRdvbyMed(final int num_med);
    
    List<Rdv> getRdvbyMedDate(final int num_med, final Date datestart, final Date datefin);
    
    Optional<Rdv> FindRdv(final int num_rdv);
}
