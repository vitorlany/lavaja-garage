package com.lavaja.app.application.service;

import com.lavaja.app.application.mapper.mapstruct.ClienteMSMapper;
import com.lavaja.app.domain.Cliente;
import com.lavaja.app.infra.model.ClienteModel;
import com.lavaja.app.infra.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClienteService {
    static final ClienteMSMapper clienteMSMapper = ClienteMSMapper.INSTANCE;
    ClienteRepository clienteRepository;

    public Cliente getById(UUID id) {
        ClienteModel clienteModel = clienteRepository
                .findById(id.toString())
                .orElseThrow(EntityNotFoundException::new);
        return clienteMSMapper.modelToDomain(clienteModel);
    }

    public List<ClienteModel> listarClientes() {
        return clienteRepository.findAll(
                    Sort.by("nome")
                );
    }
}
