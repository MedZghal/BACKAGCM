package com.perfectsolution.Clinique.Metier;

import java.util.*;
import com.perfectsolution.Clinique.Entities.*;

public interface MedicMetier
{
    List<Medicament> ListMedic();
    
    List<PrescriptionOrd> GetListPrescriptionOrdByNumOrd(final int numOrd);
}
