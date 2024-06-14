package com.unir.fasttickets.persistence.mapper;

import com.unir.fasttickets.persistence.entity.VentaEntity;
import com.unir.fasttickets.domain.dto.VentaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ClienteMapper.class, ProductoMapper.class})
public interface VentaMapper {
    VentaMapper INSTANCE = Mappers.getMapper(VentaMapper.class);

    @Mapping(source = "cliente.nombre", target = "nombreCliente")
    @Mapping(source = "producto.nombreEvento", target = "nombreEvento")
    @Mapping(source = "producto.localidad", target = "localidad")
    VentaDto toDto(VentaEntity entity);

    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "producto", ignore = true)
    VentaEntity toEntity(VentaDto dto);
}