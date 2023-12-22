package com.lavaja.app.application.usecase;

import com.lavaja.app.application.dto.ClienteDTO;
import com.lavaja.app.application.mapper.ClienteMapper;
import com.lavaja.app.application.mapper.mapstruct.ClienteMSMapper;
import com.lavaja.app.domain.Cliente;
import com.lavaja.app.infra.model.ClienteModel;
import com.lavaja.app.infra.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class CadastrarCliente {
    static final ClienteMSMapper clienteMSMapper = ClienteMSMapper.INSTANCE;
    ClienteMapper clienteMapper;
    ClienteRepository clienteRepository;

    public Cliente execute(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.dtoToDomain(clienteDTO);
        ClienteModel clienteModel = clienteMSMapper.domainToModel(cliente);
        clienteRepository.save(clienteModel);
        log.info("Cliente cadastrado: " + cliente.getId());
        return cliente;
    }
}
