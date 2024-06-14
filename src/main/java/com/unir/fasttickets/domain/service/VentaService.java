package com.unir.fasttickets.domain.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.fasttickets.domain.dto.VentaDto;
import com.unir.fasttickets.domain.repository.ClienteRepository;
import com.unir.fasttickets.domain.repository.ProductoRepository;
import com.unir.fasttickets.domain.repository.VentaRepository;
import com.unir.fasttickets.persistence.entity.ClienteEntity;
import com.unir.fasttickets.persistence.entity.ProductoEntity;
import com.unir.fasttickets.persistence.entity.VentaEntity;
import com.unir.fasttickets.persistence.mapper.VentaMapper;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ProductoRepository productoRepository;

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
        ClienteEntity cliente = clienteRepository.findById(ventaDto.getClienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + ventaDto.getClienteId()));

        ProductoEntity producto = productoRepository.findById(ventaDto.getProductoId())
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + ventaDto.getProductoId()));

        VentaEntity ventaEntity = VentaMapper.INSTANCE.toEntity(ventaDto);
        ventaEntity.setCliente(cliente);
        ventaEntity.setProducto(producto);
        ventaEntity.setFecha(LocalDateTime.now());

        VentaEntity savedVentaEntity = ventaRepository.save(ventaEntity);

        return VentaMapper.INSTANCE.toDto(savedVentaEntity);
    }

    public boolean delete(int id) {
        return ventaRepository.findById(id).map(ventaEntity -> {
            ventaRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}