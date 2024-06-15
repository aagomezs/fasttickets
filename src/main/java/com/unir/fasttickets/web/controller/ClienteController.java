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

import com.unir.fasttickets.domain.dto.ClienteDto;
import com.unir.fasttickets.domain.service.ClienteService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/all")
    public List<ClienteDto> getAll() {
        return clienteService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> getById(@PathVariable int id) {
        return clienteService.getById(id)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ClienteDto>> getByNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(clienteService.getByNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ClienteDto> getByEmail(@PathVariable String email) {
        return clienteService.getByEmail(email)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ClienteDto save(@Valid @RequestBody ClienteDto clienteDto) {
        return clienteService.save(clienteDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClienteDto> update(@RequestBody ClienteDto clienteDto, @PathVariable int id) {
        clienteDto.setId(id);
        return new ResponseEntity<>(clienteService.save(clienteDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try{
            if (clienteService.delete(id)) {
                return new ResponseEntity<>("Cliente eliminado con éxito", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}