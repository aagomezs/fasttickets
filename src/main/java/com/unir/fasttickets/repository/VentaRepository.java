package com.unir.fasttickets.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unir.fasttickets.repository.entity.VentaEntity;

@Repository
public interface VentaRepository extends CrudRepository<VentaEntity, Integer> {

}
