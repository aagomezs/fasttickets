package com.unir.fasttickets.domain.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.fasttickets.domain.dto.VentaDto;
import com.unir.fasttickets.domain.repository.VentaRepository;
import com.unir.fasttickets.persistence.entity.VentaEntity;
import com.unir.fasttickets.persistence.mapper.VentaMapper;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<VentaDto> getAll() {
        return ventaRepository.findAll().stream()
                .map(VentaMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public Optional<VentaDto> getById(int id) {
        return ventaRepository.findById(id)
                .map(VentaMapper.INSTANCE::toDto);
    }

    public VentaDto save(VentaDto ventaDto) {
        VentaEntity ventaEntity = VentaMapper.INSTANCE.toEntity(ventaDto);
        VentaEntity savedEntity = ventaRepository.save(ventaEntity);
        return VentaMapper.INSTANCE.toDto(savedEntity);
    }

    public boolean delete(int id) {
        return ventaRepository.findById(id).map(ventaEntity -> {
            ventaRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}