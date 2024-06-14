package com.unir.fasttickets.domain.dto;

import java.util.List;

public class ClienteDto {
    private int id;
    private String nombre;
    private String celular;
    private String email;
    private List<VentaDto> ventas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }  
    
    public List<VentaDto> getVentas() {
        return ventas;
    }

    public void setVentas(List<VentaDto> ventas) {
        this.ventas = ventas;
    }
}
