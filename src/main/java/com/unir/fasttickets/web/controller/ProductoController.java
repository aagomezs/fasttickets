package com.unir.fasttickets.web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.fasttickets.domain.dto.ProductoDto;
import com.unir.fasttickets.domain.service.ProductoService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping("/all")
    public List<ProductoDto> getAll() {
        return productoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> getById(@PathVariable int id) {
        return productoService.getById(id)
                .map(producto -> new ResponseEntity<>(producto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/localidad/{localidad}")
    public ResponseEntity<List<ProductoDto>> getByLocalidad(@PathVariable String localidad) {
        return new ResponseEntity<>(productoService.getByLocalidad(localidad), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ProductoDto save(@Valid @RequestBody ProductoDto productoDto) {
        return productoService.save(productoDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductoDto> update(@RequestBody ProductoDto productoDto, @PathVariable int id) {
        productoDto.setId(id);
        return new ResponseEntity<>(productoService.save(productoDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        if (productoService.delete(id)) {
            return new ResponseEntity<>("Producto eliminado con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}