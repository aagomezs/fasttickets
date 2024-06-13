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

import com.unir.fasttickets.domain.service.ProductoService;
import com.unir.fasttickets.persistence.entity.ProductoEntity;

import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping ("/productos")

public class ProductoController {
    @Autowired
    ProductoService productoService;

   @GetMapping("/all")
    public List<ProductoEntity> getAll(){
        return productoService.findAll();
    }

    @PostMapping("/save")
        public ProductoEntity save(@Valid @RequestBody ProductoEntity productoEntity) {
            return productoService.save(productoEntity);
        }
    
    @PutMapping("/update/{id}")
    public ProductoEntity update(@RequestBody ProductoEntity productoEntity, @PathVariable(name = "id") int id ) {
        ProductoEntity producto = new ProductoEntity();
        producto = productoEntity;
        producto.setId(id);
        
        return productoService.save(producto);
    }
    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id){
        return productoService.delete(id);
    } 

}
