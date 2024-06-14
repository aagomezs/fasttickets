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

import com.unir.fasttickets.domain.dto.VentaDto;
import com.unir.fasttickets.domain.service.VentaService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    VentaService ventaService;

    @GetMapping("/all")
    public ResponseEntity<List<VentaDto>> getAll() {
        return new ResponseEntity<>(ventaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaDto> getById(@PathVariable int id) {
        return ventaService.getById(id)
                .map(venta -> new ResponseEntity<>(venta, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<VentaDto> save(@Valid @RequestBody VentaDto ventaDto) {
        VentaDto savedVentaDto = ventaService.save(ventaDto);
        return new ResponseEntity<>(savedVentaDto, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<VentaDto> update(@RequestBody VentaDto ventaDto, @PathVariable int id) {
        ventaDto.setId(id);
        return ventaService.getById(id)
                .map(existingVenta -> new ResponseEntity<>(ventaService.save(ventaDto), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        if (ventaService.delete(id)) {
            return new ResponseEntity<>("Venta eliminada con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Venta no encontrada", HttpStatus.NOT_FOUND);
        }
    }
}