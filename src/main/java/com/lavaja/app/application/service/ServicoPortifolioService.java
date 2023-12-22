package com.lavaja.app.application.service;

import com.lavaja.app.application.mapper.mapstruct.ServicoPortifolioMSMapper;
import com.lavaja.app.domain.ServicoPortifolio;
import com.lavaja.app.infra.model.ServicoPortifolioModel;
import com.lavaja.app.infra.repository.ServicoPortifolioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicoPortifolioService {
    static final ServicoPortifolioMSMapper servicoPortifolioMSMapper = ServicoPortifolioMSMapper.INSTANCE;
    ServicoPortifolioRepository servicoPortifolioRepository;

    public ServicoPortifolio getById(String id) {
        ServicoPortifolioModel servicoPortifolioModel = servicoPortifolioRepository
                .findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Serviço (" + id + ") não encontrado")
                );
        return servicoPortifolioMSMapper.modelToDomain(servicoPortifolioModel);
    }

    public List<ServicoPortifolio> listarServicos() {
        return servicoPortifolioRepository.findAll(
                    Sort.by("titulo")
                ).stream()
                .map(servicoPortifolioMSMapper::modelToDomain)
                .toList();
    }
}
