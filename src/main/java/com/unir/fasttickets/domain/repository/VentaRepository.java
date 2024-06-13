package com.unir.fasttickets.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unir.fasttickets.persistence.entity.VentaEntity;

@Repository
public interface VentaRepository extends CrudRepository<VentaEntity, Integer> {

}
