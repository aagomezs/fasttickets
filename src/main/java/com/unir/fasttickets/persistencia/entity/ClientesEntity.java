package com.unir.fasttickets.persistencia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="clientes")
public class ClientesEntity {
    @Id
    @Column(name="idclientes")
    private int clienteid;
    @NotBlank
    @Column(name="nombrecliente")
    private String nombre;
    private String celular;
    private String email;
    
    public int getIdCliente() {
        return clienteid;
    }
  
    public void setIdCliente(int id) {
        this.clienteid = id;
    }

    public String getNombreCliente() {
        return nombre;
    }
  
    public void setNombreCliente(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }
  
    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String geteMail() {
        return email;
    }
  
    public void setEmail(String email) {
        this.email = email;
    }
}

