package com.lavaja.app.mapper.mapstruct;

import com.lavaja.app.application.veiculo.cadastrar.VeiculoDTO;
import com.lavaja.app.domain.Veiculo;
import com.lavaja.app.infra.model.VeiculoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VeiculoMSMapper {
    VeiculoMSMapper INSTANCE = Mappers.getMapper(VeiculoMSMapper.class);

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    Veiculo dtoToDomain(VeiculoDTO veiculoDTO);

    VeiculoModel domainToModel(Veiculo veiculo);

    Veiculo modelToDomain(VeiculoModel veiculoModel);
}
