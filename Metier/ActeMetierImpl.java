package com.perfectsolution.Clinique.Metier;

import org.springframework.stereotype.*;
import com.perfectsolution.Clinique.Dao.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import com.perfectsolution.Clinique.Entities.*;

@Service
public class ActeMetierImpl implements ActeMetier
{
    @Autowired
    public ActeRepository acteRepository;
    
    @Override
    public List<Acte> getListActesbyPatient(final int num_patient) {
        return this.acteRepository.getListActesbyPatient(num_patient);
    }
}
