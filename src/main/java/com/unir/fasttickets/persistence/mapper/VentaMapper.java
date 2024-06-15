package com.unir.fasttickets.persistence.mapper;

import com.unir.fasttickets.persistence.entity.VentaEntity;
import com.unir.fasttickets.domain.dto.VentaDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VentaMapper {
    VentaMapper INSTANCE = Mappers.getMapper(VentaMapper.class);

    @Mapping(source = "cliente.id", target = "clienteId")
    @Mapping(source = "producto.id", target = "productoId")
    @Mapping(source = "cliente.nombre", target = "nombreCliente")
    @Mapping(source = "producto.nombreEvento", target = "nombreEvento")
    @Mapping(source = "producto.localidad", target = "localidad") 
    VentaDto toDto(VentaEntity entity);
 
    VentaEntity toEntity(VentaDto dto);
}