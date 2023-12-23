package com.lavaja.app.mapper.mapstruct;

import com.lavaja.app.application.adicional.cadastrar.AdicionalDTO;
import com.lavaja.app.domain.Adicional;
import com.lavaja.app.infra.model.AdicionalModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdicionalMSMapper {
    AdicionalMSMapper INSTANCE = Mappers.getMapper(AdicionalMSMapper.class);

    Adicional modelToDomain(AdicionalModel adicional);

    AdicionalModel domainToModel(Adicional adicionalDTO);


    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    Adicional dtoToDomain(AdicionalDTO adicionalDTO);
}
