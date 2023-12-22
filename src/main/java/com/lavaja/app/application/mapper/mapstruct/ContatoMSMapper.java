package com.lavaja.app.application.mapper.mapstruct;

import com.lavaja.app.domain.Contato;
import com.lavaja.app.infra.model.ContatoModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContatoMSMapper {
    ContatoMSMapper INSTANCE = Mappers.getMapper(ContatoMSMapper.class);

    ContatoModel domainToModel(Contato contato);

    Contato modelToDomain(ContatoModel contatoModel);
}
