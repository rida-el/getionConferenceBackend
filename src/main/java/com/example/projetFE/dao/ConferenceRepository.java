package com.example.projetFE.dao;

import com.example.projetFE.entities.Comite;
import com.example.projetFE.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource

public interface ConferenceRepository extends JpaRepository<Conference,Long> {



    @RestResource(path = "/selectedConference")
    public List<Conference> findByacceptationIsTrue();

    @RestResource(path = "/getTitre")
    public Conference findByTitre(String titre);

}
