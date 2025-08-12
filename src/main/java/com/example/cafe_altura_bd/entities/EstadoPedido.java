package com.example.cafe_altura_bd.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estado_pedido", uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EstadoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nombre;
}
