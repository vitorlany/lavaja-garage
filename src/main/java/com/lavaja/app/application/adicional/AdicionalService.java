package com.lavaja.app.application.adicional;

import com.lavaja.app.mapper.mapstruct.AdicionalMSMapper;
import com.lavaja.app.domain.Adicional;
import com.lavaja.app.infra.model.AdicionalModel;
import com.lavaja.app.infra.repository.AdicionalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdicionalService {
    AdicionalRepository adicionalRepository;
    static final AdicionalMSMapper adicionalMapper = AdicionalMSMapper.INSTANCE;

    public Adicional getById(String id) {
        AdicionalModel model = adicionalRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Adicional (" + id + ") não encontrado")
                );
        return adicionalMapper.modelToDomain(model);
    }

    public List<Adicional> listarAdicionais() {
        return adicionalRepository.findAll(
                    Sort.by("descricao")
                ).stream()
                .map(adicionalMapper::modelToDomain)
                .toList();
    }
}
