package com.lavaja.app.application.cliente.atribuirPessoaConfianca;

import com.lavaja.app.mapper.mapstruct.ClienteMSMapper;
import com.lavaja.app.domain.Cliente;
import com.lavaja.app.infra.model.ClienteModel;
import com.lavaja.app.infra.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class AtribuirPessoaConfianca {
    static final ClienteMSMapper clienteMSMapper = ClienteMSMapper.INSTANCE;
    ClienteRepository clienteRepository;

    public Cliente execute(PessoaConfiancaDTO pessoaConfiancaDTO) {
        String clienteId = pessoaConfiancaDTO.cliente().toString();
        ClienteModel cliente = clienteRepository
                .findById(clienteId)
                .orElseThrow(() ->
                   new EntityNotFoundException("Cliente (" + clienteId + ") não encontrado")
                );

        String pessoaDeConfiancaId = pessoaConfiancaDTO.pessoaDeConfianca().toString();
        ClienteModel pessoaDeConfianca = clienteRepository
                .findById(pessoaDeConfiancaId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Pessoa de confiança (" + pessoaDeConfiancaId + ") não encontrado")
                );

        log.info("Pessoa " + pessoaDeConfianca.getId() + " cadastrada como pessoa de confiança de " + cliente.getId());
        cliente.setPessoaDeConfianca(pessoaDeConfianca);
        clienteRepository.save(cliente);
        return clienteMSMapper.modelToDomain(cliente);
    }
}
