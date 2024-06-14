package com.unir.fasttickets.persistence.mapper;

import com.unir.fasttickets.persistence.entity.ClienteEntity;
import com.unir.fasttickets.domain.dto.ClienteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(target = "ventas", ignore = true)  
    ClienteDto toDto(ClienteEntity entity);

    @Mapping(target = "ventas", ignore = true)  
    ClienteEntity toEntity(ClienteDto dto);
}