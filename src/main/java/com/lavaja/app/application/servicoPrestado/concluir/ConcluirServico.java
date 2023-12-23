package com.lavaja.app.application.servicoPrestado.concluir;

import com.lavaja.app.mapper.mapstruct.ServicoPrestadoMSMapper;
import com.lavaja.app.domain.ServicoPrestado;
import com.lavaja.app.infra.model.ServicoPrestadoModel;
import com.lavaja.app.infra.repository.ServicoPrestadoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class ConcluirServico {
    static final ServicoPrestadoMSMapper servicoPrestadoMSMapper = ServicoPrestadoMSMapper.INSTANCE;
    ServicoPrestadoRepository servicoPrestadoRepository;

    public ServicoPrestado execute(ConcluirServicoDTO concluirServicoDTO) {
        String servicoId = concluirServicoDTO.servicoId().toString();
        ServicoPrestadoModel servicoPrestadoModel = servicoPrestadoRepository
                .findById(servicoId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Serviço (" + servicoId + ") não encontrado")
                );
        ServicoPrestado servicoPrestado = servicoPrestadoMSMapper.modelToDomain(servicoPrestadoModel);
        servicoPrestado.concluirServico();
        servicoPrestadoModel = servicoPrestadoMSMapper.domainToModel(servicoPrestado);
        log.info("Serviço finalizado: " + servicoId);
        servicoPrestadoRepository.save(servicoPrestadoModel);
        return servicoPrestado;
    }
}
