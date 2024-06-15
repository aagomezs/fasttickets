package com.unir.fasttickets.domain.service;
import java.util.List;
import java.util.Optional;
//import java.util.stream.Collectors;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.unir.fasttickets.domain.dto.ClienteDto;
import com.unir.fasttickets.domain.repository.ClienteRepository;
import com.unir.fasttickets.persistence.entity.ClienteEntity;
import com.unir.fasttickets.persistence.mapper.ClienteMapper;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDto> getAll() {
        return clienteRepository.findAll().stream()
                .map(ClienteMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public Optional<ClienteDto> getById(int id) {
        return clienteRepository.findById(id)
                .map(ClienteMapper.INSTANCE::toDto);
    }

    public List<ClienteDto> getByNombre(String nombre) {
        return clienteRepository.findByNombre(nombre).stream()
                .map(ClienteMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public Optional<ClienteDto> getByEmail(String email) {
        return clienteRepository.findByEmail(email)
                .map(ClienteMapper.INSTANCE::toDto);
    }

    public ClienteDto save(ClienteDto clienteDto) {
        ClienteEntity clienteEntity = ClienteMapper.INSTANCE.toEntity(clienteDto);
        ClienteEntity savedEntity = clienteRepository.save(clienteEntity);
        return ClienteMapper.INSTANCE.toDto(savedEntity);
    }

    public boolean delete(int id) {
       try {
            clienteRepository.deleteById(id);
            return true;
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("No se puede eliminar este cliente porque está asociado a una venta");
        }
    }
}