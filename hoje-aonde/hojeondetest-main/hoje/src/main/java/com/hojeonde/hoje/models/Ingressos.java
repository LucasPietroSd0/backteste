package com.hojeonde.hoje.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table (name = "Ingressos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingressos {
    @Id
  @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idIngresso;
    private String Tipo;
    private String valor;
    private String quantidade;
    private String lote;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "evento_id")
  private Evento evento;
    
}
