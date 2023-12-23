package com.lavaja.app.application.mapper.mapstruct;

import com.lavaja.app.lavajato.servicoPortifolio.cadastrar.PerguntaAvaliacaoTecnicaDTO;
import com.lavaja.app.domain.PerguntaAvaliacaoTecnica;
import com.lavaja.app.infra.model.PerguntaAvaliacaoTecnicaModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PerguntaAvaliacaoTecnicaMSMapper {
    PerguntaAvaliacaoTecnicaMSMapper INSTANCE = Mappers.getMapper(PerguntaAvaliacaoTecnicaMSMapper.class);

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    PerguntaAvaliacaoTecnica dtoToDomain(PerguntaAvaliacaoTecnicaDTO perguntaAvaliacaoTecnica);

    PerguntaAvaliacaoTecnicaModel domainToModel(PerguntaAvaliacaoTecnica veiculo);
}
