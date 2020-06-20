package com.example.projetFE.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Localisation implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adresse;
    private String ville;
    private String pays;
    private Double longitude,latidude,altitude ;
    @ManyToOne
    private Conference conference;

}
