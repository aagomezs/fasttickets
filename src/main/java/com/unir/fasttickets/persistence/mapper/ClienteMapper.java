package com.unir.fasttickets.persistence.mapper;

import com.unir.fasttickets.persistence.entity.ClienteEntity;
import com.unir.fasttickets.persistence.entity.VentaEntity;
import com.unir.fasttickets.domain.dto.ClienteDto;
import com.unir.fasttickets.domain.dto.VentaDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = VentaMapper.class)
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(target = "ventas", ignore = true)
    ClienteEntity toEntity(ClienteDto dto);

    @Mapping(target = "venta.clienteId", ignore = true)  
    @Mapping(target = "venta.productoId", ignore = true) 
    @Mapping(target = "ventas", source = "ventas")
    ClienteDto toDto(ClienteEntity entity);

    @Mapping(source = "producto.nombreEvento", target = "nombreEvento")
    @Mapping(source = "producto.localidad", target = "localidad")
    @Mapping(target = "clienteId", ignore = true)  
    @Mapping(target = "productoId", ignore = true)  
    VentaDto toVentaDto(VentaEntity ventaEntity);

    @Mapping(source = "productoId", target = "producto.id")
    VentaEntity toVentaEntity(VentaDto ventaDto);

    default List<VentaEntity> toVentaEntities(List<VentaDto> ventaDtos) {
        return ventaDtos.stream()
                .map(this::toVentaEntity)
                .collect(Collectors.toList());
    }

    default List<VentaDto> toVentaDtos(List<VentaEntity> ventaEntities) {
        if (ventaEntities == null) {
            return Collections.emptyList();  
        }
        return ventaEntities.stream()
                .map(VentaMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}