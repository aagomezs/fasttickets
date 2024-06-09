package com.unir.fasttickets.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.unir.fasttickets.repository.entity.VentaEntity;
import com.unir.fasttickets.service.VentaService;
import jakarta.validation.Valid;
import java.util.List;


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
            return ventaService.save(ventaEntity);
        }
    
    @PutMapping("/update/{id}")
    public VentaEntity update(@RequestBody VentaEntity ventaEntity, @PathVariable(name = "id") int id ) {
        VentaEntity venta = new VentaEntity();
        venta = ventaEntity;
        venta.setId(id);
        
        return ventaService.save(venta);
    }
    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id){
        return ventaService.delete(id);
    } 



}