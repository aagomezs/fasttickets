package com.unir.fasttickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.fasttickets.repository.VentaRepository;
import com.unir.fasttickets.repository.entity.VentaEntity;

@Service
public class VentaService {

    @Autowired
    VentaRepository ventaRepository;

    public List<VentaEntity> findAll(){ 
        return (List<VentaEntity>) ventaRepository.findAll();

    }

    public VentaEntity save(VentaEntity venta){
        return ventaRepository.save(venta);

    }

    public String delete(int id){
        ventaRepository.deleteById(id);
        return "Registro eliminado";
    }
}