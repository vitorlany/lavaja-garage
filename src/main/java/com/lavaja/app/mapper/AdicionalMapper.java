package com.lavaja.app.mapper;

import com.lavaja.app.application.adicional.AdicionalService;
import com.lavaja.app.domain.Adicional;
import com.lavaja.app.infra.repository.AdicionalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class AdicionalMapper {
    AdicionalRepository adicionalRepository;
    AdicionalService adicionalService;

    List<Adicional> idsAdicionaisToDomainList (List<UUID> listaIds) {
        List<Adicional> adicionais = new ArrayList<>();
        listaIds.forEach(id -> {
            Adicional adicional = adicionalService.getById(id.toString());
            adicionais.add(adicional);
        });
        return adicionais;
    }
}
