package com.anturia.picshare.model;  

import jakarta.persistence.*;       // JPA pour @Entity, @Id, etc.
import lombok.Data;                  // Lombok pour générer getters/setters
import java.time.LocalDate;          // Pour le type dateTaken

@Data
@Entity
public class Pic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private LocalDate dateTaken;
    private String url;

}
