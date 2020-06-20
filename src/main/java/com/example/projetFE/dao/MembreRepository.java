package com.example.projetFE.dao;

import com.example.projetFE.entities.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface MembreRepository extends JpaRepository<Membre,Long> {
}
