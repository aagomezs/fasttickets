package com.unir.fasttickets.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.fasttickets.domain.repository.ClienteRepository;
import com.unir.fasttickets.domain.repository.ProductoRepository;
import com.unir.fasttickets.domain.repository.VentaRepository;
import com.unir.fasttickets.persistence.entity.VentaEntity;

@Service
public class VentaService {

    @Autowired
    VentaRepository ventaDtoRepository;

    @Autowired
    ClienteRepository clienteDtoRepository;

    @Autowired
    ProductoRepository productoDtoRepository;


    public List<VentaEntity> findAll(){ 
        return (List<VentaEntity>) ventaDtoRepository.findAll();

    }

    public VentaEntity findById(int id) {
        return ventaDtoRepository.findById(id).orElse(null);
    }

    public VentaEntity save(VentaEntity venta){
        return ventaDtoRepository.save(venta);

    }

    // public VentaEntity save(VentaEntity venta){ 
    //     ClienteEntity cliente = clienteDtoRepository.findById(venta.getIdCliente()).orElse(null);
    //     ProductoEntity producto = productoDtoRepository.findById(venta.getIdProducto()).orElse(null);
 
    //     venta.setCliente(cliente);
    //     venta.setProducto(producto);

    //     return ventaDtoRepository.save(venta);
    // }


    public String delete(int id){
        ventaDtoRepository.deleteById(id);
        return "Registro eliminado";
    }
}