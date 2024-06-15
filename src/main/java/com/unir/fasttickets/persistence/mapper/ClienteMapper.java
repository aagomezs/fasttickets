package com.unir.fasttickets.persistence.mapper;

import com.unir.fasttickets.persistence.entity.ClienteEntity;
import com.unir.fasttickets.domain.dto.ClienteDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDto toDto(ClienteEntity entity);

    ClienteEntity toEntity(ClienteDto dto);
} 