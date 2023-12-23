package com.lavaja.app.application.servicoPrestado.cadastrar;


import com.lavaja.app.mapper.ServicoPrestadoMapper;
import com.lavaja.app.mapper.mapstruct.ServicoPrestadoMSMapper;
import com.lavaja.app.domain.ServicoPrestado;
import com.lavaja.app.infra.model.ServicoPrestadoModel;
import com.lavaja.app.infra.repository.ServicoPrestadoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class CadastrarServicoPrestado {
    static final ServicoPrestadoMSMapper servicoPrestadoMSMapper = ServicoPrestadoMSMapper.INSTANCE;
    ServicoPrestadoRepository servicoPrestadoRepository;
    ServicoPrestadoMapper servicoPrestadoMapper;

    public ServicoPrestado execute(ServicoPrestadoDTO servicoPrestadoDTO) {
        ServicoPrestado servicoPrestado = servicoPrestadoMapper.dtoToDomain(servicoPrestadoDTO);
        ServicoPrestadoModel servicoPrestadoModel = servicoPrestadoMSMapper.domainToModel(servicoPrestado);
        servicoPrestadoRepository.save(servicoPrestadoModel);
        log.info("Serviço Prestado cadastrado: " + servicoPrestado.getId());
        return servicoPrestado;
    }
}
