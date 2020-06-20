package com.example.projetFE;


import com.example.projetFE.dao.ConferenceRepository;
import com.example.projetFE.entities.Conference;
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





    @GetMapping(path="/conference/photoConference/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
        Conference m = conferenceRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/conference/image/"+m.getImage()));
    }


    @PostMapping(path = "/conference/photoConference")
    public void addConference(@RequestParam("file") MultipartFile file,@RequestParam("conference") String conference) throws Exception {

        Conference m = new ObjectMapper().readValue(conference, Conference.class);
        m.setImage(file.getOriginalFilename());
        System.out.println("donne");
        Files.write(Paths.get(System.getProperty("user.home")+"/conference/image/"+m.getImage()), file.getBytes());
        conferenceRepository.save(m);

    }


}
