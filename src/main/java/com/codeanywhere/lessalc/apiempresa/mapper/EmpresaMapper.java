package com.codeanywhere.lessalc.apiempresa.mapper;

import com.codeanywhere.lessalc.apiempresa.dto.request.EmpresaDTO;
import com.codeanywhere.lessalc.apiempresa.entity.Empresa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmpresaMapper {

    EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);

    @Mapping(target="dataCriacao", source = "criacao", dateFormat = "dd-MM-yyyy")
    Empresa toModel(EmpresaDTO empresaDTO);

    @Mapping(target="criacao", source = "dataCriacao")
    EmpresaDTO toDTO(Empresa empresa);
}
