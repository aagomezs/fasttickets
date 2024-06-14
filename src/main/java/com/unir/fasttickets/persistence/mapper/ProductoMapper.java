package com.unir.fasttickets.persistence.mapper;
 
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.unir.fasttickets.domain.dto.ProductoDto;
import com.unir.fasttickets.persistence.entity.ProductoEntity;

@Mapper
public interface ProductoMapper {
    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

    ProductoDto toDto(ProductoEntity entity);

    ProductoEntity toEntity(ProductoDto dto);
}