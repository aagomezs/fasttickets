package com.unir.fasttickets.repository; 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository; 
import com.unir.fasttickets.repository.entity.ProductoEntity;

@Repository

public interface ProductoRepository extends CrudRepository<ProductoEntity, Integer>{

}
