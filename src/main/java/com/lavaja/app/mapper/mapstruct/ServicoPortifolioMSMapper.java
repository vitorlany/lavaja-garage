package com.lavaja.app.mapper.mapstruct;

import com.lavaja.app.domain.ServicoPortifolio;
import com.lavaja.app.infra.model.ServicoPortifolioModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServicoPortifolioMSMapper {
    ServicoPortifolioMSMapper INSTANCE = Mappers.getMapper(ServicoPortifolioMSMapper.class);

    ServicoPortifolio modelToDomain(ServicoPortifolioModel servicoPortifolioModel);
    ServicoPortifolioModel domainToModel(ServicoPortifolio servicoPortifolioModel);
}
