package com.example.projetFE;


import com.example.projetFE.dao.ConferenceRepository;
import com.example.projetFE.dao.ParticipantRepository;
import com.example.projetFE.entities.Conference;
import com.example.projetFE.entities.Localisation;
import com.example.projetFE.entities.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class ParticipantRestService {

    @Autowired
    private ConferenceRepository conferenceRepository;
    @Autowired
    private ParticipantRepository participantRepository;

    @PostMapping(path = "/participants/add/{id}")
    public Participant addPart (@PathVariable("id") Long id,
                                 @RequestBody Participant participant)
            throws Exception {
        Conference c = conferenceRepository.findById(id).get();
        participant.setConference(c);
        return participantRepository.save(participant);
    }
}
