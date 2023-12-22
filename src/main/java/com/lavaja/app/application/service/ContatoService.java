package com.lavaja.app.application.service;

import com.lavaja.app.application.mapper.mapstruct.ContatoMSMapper;
import com.lavaja.app.domain.Contato;
import com.lavaja.app.infra.model.ContatoModel;
import com.lavaja.app.infra.repository.ContatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContatoService {
    static final ContatoMSMapper contatoMSMapper = ContatoMSMapper.INSTANCE;
    ContatoRepository contatoRepository;

    public List<ContatoModel> cadastrarContatos(List<Contato> contatos) {
        return contatos.stream().map(contato -> {
            ContatoModel contatoModel = contatoMSMapper.domainToModel(contato);
            return contatoRepository.save(contatoModel);
        })
        .toList();
    }
}
