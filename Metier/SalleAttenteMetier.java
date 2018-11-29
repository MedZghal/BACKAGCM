package com.perfectsolution.Clinique.Metier;

import java.util.*;
import com.perfectsolution.Clinique.Entities.*;

public interface SalleAttenteMetier
{
    List<SalleAttente> getSalleAttentebyMedecin(final int codMed);
}
