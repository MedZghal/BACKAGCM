package com.perfectsolution.Clinique.Dao;

import com.perfectsolution.Clinique.Entities.*;
import org.springframework.stereotype.*;
import org.springframework.data.repository.query.*;
import org.springframework.data.jpa.repository.*;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String>
{
    @Query("SELECT u FROM Utilisateur u WHERE u.username = :username and u.pass =:pass and u.type IN ('Administrateur','Medecin')")
    Utilisateur LoginUser(@Param("username") final String username, @Param("pass") final String pass);
}
