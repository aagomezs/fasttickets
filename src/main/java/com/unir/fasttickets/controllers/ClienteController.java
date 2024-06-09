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
import com.unir.fasttickets.repository.entity.ClienteEntity;
import com.unir.fasttickets.service.ClienteService;
import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/clientes")

public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/all")
    public List<ClienteEntity> getAll(){
        return clienteService.findAll();
    }

    @PostMapping("/save")
        public ClienteEntity save(@Valid @RequestBody ClienteEntity clienteEntity) {
            return clienteService.save(clienteEntity);
        }
    
    @PutMapping("/update/{id}")
    public ClienteEntity update(@RequestBody ClienteEntity clienteEntity, @PathVariable(name = "id") int id ) {
        ClienteEntity cliente = new ClienteEntity();
        cliente = clienteEntity;
        cliente.setId(id);
        
        return clienteService.save(cliente);
    }
    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id){
        return clienteService.delete(id);
    } 



}

