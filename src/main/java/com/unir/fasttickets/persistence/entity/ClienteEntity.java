package com.unir.fasttickets.persistence.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="clientes")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String celular;
    @NotBlank
    @Email(message = "no tiene formato válido")
    private String email;

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    private List<VentaEntity> ventas;
}
