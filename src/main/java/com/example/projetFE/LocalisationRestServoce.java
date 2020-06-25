package com.example.projetFE;


import com.example.projetFE.dao.ConferenceRepository;
import com.example.projetFE.dao.LocalisationRepository;
import com.example.projetFE.entities.Conference;
import com.example.projetFE.entities.Localisation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class LocalisationRestServoce {

    @Autowired
    private ConferenceRepository conferenceRepository;
    @Autowired
    private LocalisationRepository localisationRepository;



    @PostMapping(path = "/localisations/addlocal/{id}")
    public Localisation editeEmp(@PathVariable("id") Long id,
                                 @RequestBody Localisation localisation)
            throws Exception {
        Conference c = conferenceRepository.findById(id).get();
        localisation.setConference(c);
        return localisationRepository.save(localisation);
    }




}
