package com.lavaja.app.application.mapper.mapstruct;

import com.lavaja.app.domain.ServicoPrestado;
import com.lavaja.app.infra.model.ServicoPrestadoModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServicoPrestadoMSMapper {
    ServicoPrestadoMSMapper INSTANCE = Mappers.getMapper(ServicoPrestadoMSMapper.class);

    ServicoPrestadoModel domainToModel(ServicoPrestado servicoPrestado);
    
    ServicoPrestado modelToDomain(ServicoPrestadoModel servicoPrestado);
}
