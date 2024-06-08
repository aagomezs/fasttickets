package com.unir.fasttickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.fasttickets.repository.entity.ClienteEntity;
import com.unir.fasttickets.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<ClienteEntity> findAll(){ 
        return (List<ClienteEntity>) clienteRepository.findAll();

    }
/* 
    public ClientesEntity save(ClientesEntity cliente){
        return clienteRepository.save(cliente);

    }

    public String delete(int id){
        clienteRepository.deleteById(id);
        return "Registro eliminado";
    }
*/
}
