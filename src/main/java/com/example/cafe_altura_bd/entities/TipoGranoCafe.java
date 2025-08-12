package com.example.cafe_altura_bd.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipo_grano_cafe", uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TipoGranoCafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grano")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;
}
