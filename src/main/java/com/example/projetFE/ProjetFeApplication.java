package com.example.projetFE;

import com.example.projetFE.dao.ComiteRepository;
import com.example.projetFE.dao.ConferenceRepository;
import com.example.projetFE.dao.LocalisationRepository;
import com.example.projetFE.dao.OrganisateurRepository;
import com.example.projetFE.entities.*;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

@SpringBootApplication
public class ProjetFeApplication implements CommandLineRunner {

	@Autowired
	private ComiteRepository comiteRepository;
	@Autowired
	private ConferenceRepository conferenceRepository;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	@Autowired
	private OrganisateurRepository organisateurRepository;

	@Autowired
	private LocalisationRepository localisationRepository;


	public static void main(String[] args) {
		SpringApplication.run(ProjetFeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	restConfiguration.exposeIdsFor(Comite.class, Membre.class,Conference.class);

        Organisateur o = new Organisateur();
        o.setNom("rida");
        o.setPrenom("el ");
         //organisateurRepository.save(o);


		//conferenceRepository.save(new Conference(null,"confer",null,null,null,null,null,null));
		//conferenceRepository.save(new Conference(null,"confer1",null,null,null,null,null,null));
		//conferenceRepository.save(new Conference(null,"confer2",null,null,null,null,null,null));
		Random rnd =new Random();
		conferenceRepository.findAll().forEach(c->{
			Localisation l=new Localisation();
			l.setAdresse(RandomString.make(8));
			l.setAltitude(rnd.nextDouble());
			l.setConference(c);
			//localisationRepository.save(l);

		});

		System.out.println("ruun");


	}
}
