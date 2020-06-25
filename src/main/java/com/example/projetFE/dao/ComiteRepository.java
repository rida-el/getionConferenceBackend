package com.example.projetFE.dao;

import com.example.projetFE.entities.Comite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin("*")
@RepositoryRestResource
public interface ComiteRepository extends JpaRepository<Comite,Long> {




}
