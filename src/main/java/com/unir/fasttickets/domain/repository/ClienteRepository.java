package com.unir.fasttickets.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unir.fasttickets.persistence.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity,Integer>{

}
