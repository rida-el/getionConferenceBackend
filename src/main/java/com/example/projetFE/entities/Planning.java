package com.example.projetFE.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Planning implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tempa;
    private String programmea;
    private String tempb;
    private String programmeb;
    private String tempc;
    private String programmec;
    private String tempd;
    private String programmed;
    @ManyToOne
    private Conference conference;
}
