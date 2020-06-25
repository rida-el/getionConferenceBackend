package com.example.projetFE;


import com.example.projetFE.dao.ConferenceRepository;
import com.example.projetFE.entities.Comite;
import com.example.projetFE.entities.Conference;
import com.example.projetFE.entities.Membre;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class ComiteRestService {
    @Autowired
    private ConferenceRepository conferenceRepository;


    @PostMapping( path="/comite/add")
    public void addcomite(@RequestParam("comite") String comite , @RequestParam("conference") String conference_id ) throws Exception {

        Comite m = new ObjectMapper().readValue(comite,Comite.class);
        Long conferenceid = new ObjectMapper().readValue(conference_id,Long.class);
        //Conference c = conferenceRepository.findbyidconference(conferenceid);
       // m.setConference(c);
        System.out.println("comite added");


    }
}
