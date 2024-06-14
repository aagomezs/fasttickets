package com.unir.fasttickets.domain.dto;

public class ProductoDto {
    private int id;
    private String nombreEvento;
    private String lugarEvento;
    private String localidad;
    private int precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String name) {
        this.nombreEvento = name;
    }

    public String getLugarEvento() {
        return lugarEvento;
    }

    public void setLugarEvento(String name) {
        this.lugarEvento = name;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String name) {
        this.localidad = name;
    } 

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int price) {
        this.precio = price;
    }
}
