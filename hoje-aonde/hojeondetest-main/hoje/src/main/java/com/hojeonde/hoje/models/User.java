package com.hojeonde.hoje.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
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
    private String senha;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingressos> ingressos = new ArrayList<>();



    public User(List<Ingressos> ingresso,
                List<Ingressos> ingressos,
                String senha, String telefone,
                String email, String nome, String cpf,
                UUID idUser) {
        this.ingressos = ingressos;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.idUser = idUser;
    }

    public User(String email, String senha, String telefone, Instant now) {

    }
}
