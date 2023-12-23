package com.lavaja.app.application.servicoPortifolio.cadastrar;

import com.lavaja.app.mapper.mapstruct.ServicoPortifolioMSMapper;
import com.lavaja.app.mapper.ServicoPortifolioMapper;
import com.lavaja.app.application.adicional.AdicionalService;
import com.lavaja.app.domain.ServicoPortifolio;
import com.lavaja.app.infra.model.ServicoPortifolioModel;
import com.lavaja.app.infra.repository.ServicoPortifolioRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class CadastrarServicoNoPortifolio {
    static final ServicoPortifolioMSMapper portifolioMSMapper = ServicoPortifolioMSMapper.INSTANCE;
    ServicoPortifolioMapper portifolioMapper;
    ServicoPortifolioRepository servicoPortifolioRepository;
    AdicionalService adicionalService;

    public ServicoPortifolio execute(ServicoPortifolioDTO servicoDto) {
        ServicoPortifolio servicoPortifolio = portifolioMapper.dtoToDomain(servicoDto);
        ServicoPortifolioModel servicoPortifolioModel = portifolioMSMapper.domainToModel(servicoPortifolio);
        servicoPortifolioRepository.save(servicoPortifolioModel);
        log.info("Serviço no portfolio cadastrado: " + servicoPortifolio.getId());
        return servicoPortifolio;
    }
}
