package com.lavaja.app.application.service;

import com.lavaja.app.application.mapper.mapstruct.ServicoPrestadoMSMapper;
import com.lavaja.app.domain.ServicoPrestado;
import com.lavaja.app.domain.enumerator.StatusServico;
import com.lavaja.app.infra.model.VeiculoModel;
import com.lavaja.app.infra.repository.ServicoPrestadoRepository;
import com.lavaja.app.infra.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ServicoPrestadoService {
    static final ServicoPrestadoMSMapper servicoPrestadoMSMapper = ServicoPrestadoMSMapper.INSTANCE;
    ServicoPrestadoRepository servicoPrestadoRepository;
    VeiculoRepository veiculoRepository;

    public List<ServicoPrestado> listarServicosAgendados() {
        return servicoPrestadoRepository.findByStatusEqualsOrderByDataEHoraDesc(
                    StatusServico.AGENDADO
                ).stream()
                .map(servicoPrestadoMSMapper::modelToDomain)
                .toList();
    }

    public List<ServicoPrestado> listarServicosConcluidos() {
        return servicoPrestadoRepository.findByStatusEqualsOrderByDataEHoraDesc(
                    StatusServico.CONCLUIDO
                ).stream()
                .map(servicoPrestadoMSMapper::modelToDomain)
                .toList();
    }

    public List<ServicoPrestado> listarServicosConcluidosDoVeiculo(UUID id) {
        VeiculoModel veiculoModel = veiculoRepository.getReferenceById(id.toString());
        return servicoPrestadoRepository.findByStatusEqualsAndVeiculoEqualsOrderByDataEHoraDesc(
                    StatusServico.CONCLUIDO,
                    veiculoModel
                ).stream()
                .map(servicoPrestadoMSMapper::modelToDomain)
                .toList();
    }
}
