package com.perfectsolution.Clinique.Services;

import com.perfectsolution.Clinique.Metier.*;
import org.springframework.beans.factory.annotation.*;
import com.perfectsolution.Clinique.Entities.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class UtilisateurService
{
    @Autowired
    private UtilisateurMetier metier;
    
    @GetMapping({ "/Utilisateur" })
    public Optional<Utilisateur> findByUsername(@RequestParam final String username) {
        return this.metier.findByUsername(username);
    }
    
    @GetMapping({ "/Utilisateurs" })
    public List<Utilisateur> findAll() {
        return this.metier.findAll();
    }
    
    @GetMapping({ "/LoginUser" })
    public List<Utilisateur> LoginUser(@RequestParam final String username, @RequestParam final String pass) {
        final List<Utilisateur> rep = new ArrayList<Utilisateur>();
        rep.add(this.metier.LoginUser(username, pass));
        return rep;
    }
}
