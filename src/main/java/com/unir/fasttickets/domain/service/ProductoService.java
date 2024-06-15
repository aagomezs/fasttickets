package com.unir.fasttickets.domain.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.unir.fasttickets.domain.dto.ProductoDto;
import com.unir.fasttickets.domain.repository.ProductoRepository;
import com.unir.fasttickets.persistence.entity.ProductoEntity;
import com.unir.fasttickets.persistence.mapper.ProductoMapper;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<ProductoDto> getAll() {
        return productoRepository.findAll().stream()
                .map(ProductoMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public Optional<ProductoDto> getById(int id) {
        return productoRepository.findById(id)
                .map(ProductoMapper.INSTANCE::toDto);
    }

    public List<ProductoDto> getByLocalidad(String localidad) {
        return productoRepository.findByLocalidad(localidad).stream()
                .map(ProductoMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public ProductoDto save(ProductoDto productoDto) {
        ProductoEntity productoEntity = ProductoMapper.INSTANCE.toEntity(productoDto);
        ProductoEntity savedEntity = productoRepository.save(productoEntity);
        return ProductoMapper.INSTANCE.toDto(savedEntity);
    }

    public boolean delete(int id) {
     try {
            productoRepository.deleteById(id);
            return true;
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("No se puede eliminar este producto porque está asociado a una venta");
        }
    }
}