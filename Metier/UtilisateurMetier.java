package com.perfectsolution.Clinique.Metier;

import com.perfectsolution.Clinique.Entities.*;
import java.util.*;

public interface UtilisateurMetier
{
    Optional<Utilisateur> findByUsername(final String username);
    
    Utilisateur LoginUser(final String username, final String pass);
    
    List<Utilisateur> findAll();
}
