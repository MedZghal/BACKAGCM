package com.perfectsolution.Clinique.Services;

import com.perfectsolution.Clinique.Metier.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import com.perfectsolution.Clinique.Entities.*;

@RestController
public class MedicRestService
{
    @Autowired
    public MedicMetier medicMetier;
    
    @GetMapping({ "/ListMedic" })
    public List<Medicament> ListMedic() {
        return this.medicMetier.ListMedic();
    }
    
    @GetMapping({ "/GetListPrescriptionOrdByNumOrd" })
    public List<PrescriptionOrd> GetListPrescriptionOrdByNumOrd(@RequestParam final int numOrd) {
        return this.medicMetier.GetListPrescriptionOrdByNumOrd(numOrd);
    }
}
