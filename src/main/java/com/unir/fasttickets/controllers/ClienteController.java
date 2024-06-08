package com.unir.fasttickets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.fasttickets.persistencia.entity.ClientesEntity;
import com.unir.fasttickets.service.ClienteService;

@RestController
@RequestMapping("/clientes")

public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/all")
    public List<ClientesEntity> getAll(){
        return clienteService.findAll();
    }

}

