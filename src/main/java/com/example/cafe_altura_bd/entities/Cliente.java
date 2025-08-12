package com.example.cafe_altura_bd.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cliente", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(nullable = false, length = 120)
    private String nombres;

    @Column(nullable = false, length = 120)
    private String apellidos;

    @Column(nullable = false, length = 150)
    private String correo;

    @Column(nullable = false, length = 255)
    private String direccion;
}
