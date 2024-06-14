package com.unir.fasttickets.domain.repository;

import com.unir.fasttickets.persistence.entity.ClienteEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
    List<ClienteEntity> findByNombre(String nombre);
    Optional<ClienteEntity> findByEmail(String email);
}