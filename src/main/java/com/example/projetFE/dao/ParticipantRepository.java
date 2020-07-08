package com.example.projetFE.dao;


import com.example.projetFE.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ParticipantRepository extends JpaRepository<Participant,Long> {
}
