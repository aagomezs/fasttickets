package com.unir.fasttickets.persistencia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="producto")
public class ProductosEntity {
    @Id
    @Column(name="idproducto")
    private int productoid;
    @NotBlank
    @Column(name="nombreevento")
    private String nombre_evento;
    @NotBlank
    @Column(name="lugarevento")
    private String lugar_evento;
    @NotBlank
    private String localidad;
    private double precio;

    public int getProductoId() {
        return productoid;
    }
  
    public void setIdProductoId(int id) {
        this.productoid = id;
    }

    public String getNombreEvento() {
        return nombre_evento;
    }
  
    public void setNombreCliente(String nombre) {
        this.nombre_evento = nombre;
    }

    public String getLugarEvento() {
        return lugar_evento;
    }
  
    public void setLugarCliente(String evento) {
        this.lugar_evento = evento;
    }

    public String getLocalidad() {
        return localidad;
    }
  
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public double getPrecio() {
        return precio;
    }
  
    public void setPrecio(double precio) {
        this.precio = precio;
    }


}
