package com.perfectsolution.Clinique.Metier;

import java.util.*;
import com.perfectsolution.Clinique.Entities.*;

public interface FichPatientMetier
{
    List<Patient> getPatientByCodMed(final int codeMedTrit);
    
    List<Patient> getPatientPartagByCodMed(final int codeMedTrit);
}
