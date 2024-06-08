package com.unir.fasttickets.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unir.fasttickets.repository.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity,Integer>{

}
