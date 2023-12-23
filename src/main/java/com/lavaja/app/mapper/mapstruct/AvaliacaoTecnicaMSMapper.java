package com.lavaja.app.mapper.mapstruct;

import com.lavaja.app.domain.AvaliacaoTecnica;
import com.lavaja.app.infra.model.AvaliacaoTecnicaModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AvaliacaoTecnicaMSMapper {
    AvaliacaoTecnicaMSMapper INSTANCE = Mappers.getMapper(AvaliacaoTecnicaMSMapper.class);

    AvaliacaoTecnicaModel domainToEntity(AvaliacaoTecnica avaliacaoTecnica);
}
