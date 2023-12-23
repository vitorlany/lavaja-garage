package com.lavaja.app.application.mapper;

import com.lavaja.app.lavajato.cliente.cadastrar.ClienteDTO;
import com.lavaja.app.application.service.ContatoService;
import com.lavaja.app.domain.Cliente;
import com.lavaja.app.domain.Contato;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ClienteMapper {
    ContatoMapper contatoMapper;
    ContatoService contatoService;

    public Cliente dtoToDomain(ClienteDTO clienteDTO) {
        List<Contato> contatos = contatoMapper.dtoToDomain(clienteDTO.contatos());
        contatoService.cadastrarContatos(contatos);
        return new Cliente(clienteDTO.nome(), contatos);
    }
}
