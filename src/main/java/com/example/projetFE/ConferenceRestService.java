package com.example.projetFE;


import com.example.projetFE.dao.ConferenceRepository;
import com.example.projetFE.dao.LocalisationRepository;
import com.example.projetFE.dao.PlanningRepository;
import com.example.projetFE.entities.Conference;
import com.example.projetFE.entities.Localisation;
import com.example.projetFE.entities.Planning;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

@CrossOrigin("*")
@RestController
public class ConferenceRestService {

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private LocalisationRepository localisationRepository;

    @Autowired
    private PlanningRepository planningRepository;

    @GetMapping(path="/conference/photoConference/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
        Conference m = conferenceRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/conference/image/"+m.getImage()));
    }


    @PostMapping(path = "/conference/photoConference")
    public void addConference(@RequestParam("file") MultipartFile file,
                              @RequestParam("conference") String conference,
                              @RequestParam("localisation") String localisation,
                              @RequestParam("planning") String planning  ) throws Exception {

        Conference m = new ObjectMapper().readValue(conference, Conference.class);
        m.setImage(file.getOriginalFilename());
        Localisation l = new ObjectMapper().readValue(localisation, Localisation.class);
        Planning p = new ObjectMapper().readValue(planning,Planning.class);
        Files.write(Paths.get(System.getProperty("user.home")+"/conference/image/"+m.getImage()), file.getBytes());
        conferenceRepository.save(m);
        l.setConference(m);
        localisationRepository.save(l);
        p.setConference(m);
        planningRepository.save(p);
    }

    @PatchMapping(path = "/conferences/editeConf/{id}")
    public void editeEmp(@PathVariable("id") Long id)
            throws Exception {
        Conference c = conferenceRepository.findById(id).get();
        c.setAcceptation(!c.getAcceptation());
        conferenceRepository.save(c);
    }








}


