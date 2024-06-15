package com.unir.fasttickets.persistence.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ventas")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VentaEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private LocalDateTime fecha; 
 
    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference
    private ProductoEntity producto; 

    private Integer id_cliente;
    private Integer id_producto;
}
