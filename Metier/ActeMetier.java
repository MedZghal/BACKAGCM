package com.perfectsolution.Clinique.Metier;

import java.util.*;
import com.perfectsolution.Clinique.Entities.*;

public interface ActeMetier
{
    List<Acte> getListActesbyPatient(final int num_patient);
}
