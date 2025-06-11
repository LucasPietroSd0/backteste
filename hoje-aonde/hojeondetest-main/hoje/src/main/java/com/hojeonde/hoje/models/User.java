package com.hojeonde.hoje.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

import java.util.List;
import java.util.UUID;
import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "Users")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
 @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idUser;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;

    @OneToMany(mappedBy = "user")
    private List<Ingressos> ingressos = new ArrayList<>();

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingressos> ingresso = new ArrayList<>();


}
