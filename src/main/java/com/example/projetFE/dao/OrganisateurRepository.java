package com.example.projetFE.dao;

import com.example.projetFE.entities.Conference;
import com.example.projetFE.entities.Organisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface OrganisateurRepository extends JpaRepository<Organisateur,Long> {

    @Query("select o from Organisateur o where o.id=:x")
    public Organisateur findbyidorganisateur( Long x );

}
