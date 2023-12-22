package com.lavaja.app.application.usecase;

import com.lavaja.app.application.dto.AdicionalDTO;
import com.lavaja.app.application.mapper.mapstruct.AdicionalMSMapper;
import com.lavaja.app.domain.Adicional;
import com.lavaja.app.infra.model.AdicionalModel;
import com.lavaja.app.infra.repository.AdicionalRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class CadastrarAdicional {
    AdicionalRepository adicionalRepository;
    static final AdicionalMSMapper adicionalMapper = AdicionalMSMapper.INSTANCE;

    public Adicional execute(AdicionalDTO adicionalDTO) {
        Adicional adicional = adicionalMapper.dtoToDomain(adicionalDTO);
        AdicionalModel adicionalModel = adicionalMapper.domainToModel(adicional);
        adicionalRepository.save(adicionalModel);
        log.info("Adicional cadastrado: " + adicional.getId());
        return adicional;
    }
}
