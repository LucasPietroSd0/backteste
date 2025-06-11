package com.hojeonde.hoje.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "organizadores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Organizador {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idOrganizador;
    private String nome;
    private String email;
    private String telefone;

    @OneToMany(mappedBy = "organizador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evento> eventos = new ArrayList<>();
    
}
