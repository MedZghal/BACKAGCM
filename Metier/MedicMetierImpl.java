package com.perfectsolution.Clinique.Metier;

import org.springframework.stereotype.*;
import com.perfectsolution.Clinique.Dao.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import com.perfectsolution.Clinique.Entities.*;

@Service
public class MedicMetierImpl implements MedicMetier
{
    @Autowired
    public MedicRepository medicRepository;
    
    @Override
    public List<Medicament> ListMedic() {
        return (List<Medicament>)this.medicRepository.findAll();
    }
    
    @Override
    public List<PrescriptionOrd> GetListPrescriptionOrdByNumOrd(final int numOrd) {
        return this.medicRepository.GetListPrescriptionOrdByNumOrd(numOrd);
    }
}
