package com.unir.fasttickets.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.fasttickets.repository.ProductoRepository;
import com.unir.fasttickets.repository.entity.ProductoEntity;

@Service

public class ProductoService {
    @Autowired
    ProductoRepository productoRepostory;

    public List<ProductoEntity> findAll(){ 
        return (List<ProductoEntity>) productoRepostory.findAll();

    }

    public ProductoEntity save(ProductoEntity producto){
        return productoRepostory.save(producto);

    }

    public String delete(int id){
        productoRepostory.deleteById(id);
        return "Registro eliminado";
    }

    
}
