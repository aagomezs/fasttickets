package com.unir.fasttickets.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    
    //se renombran algunas propiedades de la entidad, la razón está en que si la tabla se llama clientes no es necesario que la propiedad se llame nombreCliente, idCliente, celularCliente. 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String nombre;
    private String celular;
    @Email(message = "no tiene formato válido")
    private String email;
}
