package com.lavaja.app.application.mapper;

import com.lavaja.app.domain.Contato;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ContatoMapper {

    public Contato dtoToDomain(String contato) {
        return new Contato(contato);
    }

    public List<Contato> dtoToDomain(List<String> contato) {
        return contato.stream()
                .map(this::dtoToDomain)
                .toList();
    }
}
