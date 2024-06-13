package com.unir.fasttickets.web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.fasttickets.domain.service.VentaService;
import com.unir.fasttickets.persistence.entity.VentaEntity;

import jakarta.validation.Valid;
import java.util.List;
import java.time.LocalDateTime;


@RestController
@RequestMapping("/ventas")

public class VentaController {

    @Autowired
    VentaService ventaService;

    @GetMapping("/all")
    public List<VentaEntity> getAll(){
        return ventaService.findAll();
    }

    @PostMapping("/save")
        public VentaEntity save(@Valid @RequestBody VentaEntity ventaEntity) {
            ventaEntity.setFecha(LocalDateTime.now());
            return ventaService.save(ventaEntity);
        }
    
    @PutMapping("/update/{id}")
    public VentaEntity update(@RequestBody VentaEntity ventaEntity, @PathVariable(name = "id") int id ) {
        VentaEntity venta = ventaService.findById(id);
        if (venta != null) {
            venta.setFecha(ventaEntity.getFecha());
            venta.setIdCliente(ventaEntity.getIdCliente());
            venta.setIdProducto(ventaEntity.getIdProducto());
            return ventaService.save(venta);
        } else {
            // Manejo de error: venta no encontrada
            return null;
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id){
        return ventaService.delete(id);
    } 



}