package com.lavaja.app.application.service;

import com.lavaja.app.application.mapper.mapstruct.ClienteMSMapper;
import com.lavaja.app.application.mapper.mapstruct.VeiculoMSMapper;
import com.lavaja.app.domain.Cliente;
import com.lavaja.app.domain.Veiculo;
import com.lavaja.app.infra.model.ClienteModel;
import com.lavaja.app.infra.model.VeiculoModel;
import com.lavaja.app.infra.repository.VeiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VeiculoService {
    static final VeiculoMSMapper veiculoMSMapper = VeiculoMSMapper.INSTANCE;
    static final ClienteMSMapper clienteMSMapper = ClienteMSMapper.INSTANCE;
    VeiculoRepository veiculoRepository;
    ClienteService clienteService;

    public Veiculo getById(UUID id) {
        VeiculoModel model = veiculoRepository
                .findById(id.toString())
                .orElseThrow(() ->
                        new EntityNotFoundException("Veiculo (" + id + ") não encontrado")
                );
        return veiculoMSMapper.modelToDomain(model);
    }

    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.findAll().stream()
                .map(veiculoMSMapper::modelToDomain)
                .toList();
    }

    public List<Veiculo> listarVeiculosDeUmCliente(UUID id) {
        Cliente cliente = clienteService.getById(id);
        ClienteModel clienteModel = clienteMSMapper.domainToModel(cliente);
        return veiculoRepository.findByDonoOrderByModelo(clienteModel)
                .stream()
                .map(veiculoMSMapper::modelToDomain)
                .toList();
    }
}
