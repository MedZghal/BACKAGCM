package com.perfectsolution.Clinique.Metier;

import org.springframework.stereotype.*;
import com.perfectsolution.Clinique.Dao.*;
import org.springframework.beans.factory.annotation.*;
import com.perfectsolution.Clinique.Entities.*;
import java.util.*;

@Service
public class UtilisateurMetierImpl implements UtilisateurMetier
{
    @Autowired
    private UtilisateurRepository UtilisateurRepository;
    
    @Override
    public List<Utilisateur> findAll() {
        return (List<Utilisateur>)this.UtilisateurRepository.findAll();
    }
    
    @Override
    public Utilisateur LoginUser(final String username, final String pass) {
        return this.UtilisateurRepository.LoginUser(username, pass);
    }
    
    @Override
    public Optional<Utilisateur> findByUsername(final String username) {
        return (Optional<Utilisateur>)this.UtilisateurRepository.findById((Object)username);
    }
}
