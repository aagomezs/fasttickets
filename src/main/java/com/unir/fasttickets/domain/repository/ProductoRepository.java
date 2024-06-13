package com.unir.fasttickets.domain.repository; 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unir.fasttickets.persistence.entity.ProductoEntity;

@Repository

public interface ProductoRepository extends CrudRepository<ProductoEntity, Integer>{

}
