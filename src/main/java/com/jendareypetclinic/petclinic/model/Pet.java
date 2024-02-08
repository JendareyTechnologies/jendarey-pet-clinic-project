package com.jendareypetclinic.petclinic.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String petName;

    private String email;

    private String ownerName;

    private String imageName;

    private String message;

}
