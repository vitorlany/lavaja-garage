package com.lavaja.app.application.mapper.mapstruct;

import com.lavaja.app.domain.Cliente;
import com.lavaja.app.infra.model.ClienteModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMSMapper {
    ClienteMSMapper INSTANCE = Mappers.getMapper(ClienteMSMapper.class);

    Cliente modelToDomain(ClienteModel clienteModel);

    ClienteModel domainToModel(Cliente cliente);
}
