package com.unir.fasttickets.domain.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.fasttickets.domain.repository.ClienteRepository;
import com.unir.fasttickets.persistence.entity.ClienteEntity;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public List<ClienteEntity> findAll(){ 
        return (List<ClienteEntity>) clienteRepository.findAll();

    }

    public ClienteEntity save(ClienteEntity cliente){
        return clienteRepository.save(cliente);

    }

    public String delete(int id){
        clienteRepository.deleteById(id);
        return "Registro eliminado";
    }
}
