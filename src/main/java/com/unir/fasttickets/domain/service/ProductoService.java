package com.unir.fasttickets.domain.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.fasttickets.domain.repository.ProductoRepository;
import com.unir.fasttickets.persistence.entity.ProductoEntity;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoDtoRepository;

    public List<ProductoEntity> findAll(){ 
        return (List<ProductoEntity>) productoDtoRepository.findAll();

    }

    public ProductoEntity save(ProductoEntity producto){
        return productoDtoRepository.save(producto);

    }

    public String delete(int id){
        productoDtoRepository.deleteById(id);
        return "Registro eliminado";
    }

    
}
