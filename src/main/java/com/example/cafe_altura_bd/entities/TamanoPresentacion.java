package com.example.cafe_altura_bd.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tamano_presentacion", uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TamanoPresentacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tamano")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;
}
