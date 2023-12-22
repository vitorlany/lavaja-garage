package com.lavaja.app.application.mapper;

import com.lavaja.app.application.dto.ServicoPrestadoDTO;
import com.lavaja.app.application.service.ServicoPortifolioService;
import com.lavaja.app.application.service.VeiculoService;
import com.lavaja.app.domain.Adicional;
import com.lavaja.app.domain.ServicoPortifolio;
import com.lavaja.app.domain.ServicoPrestado;
import com.lavaja.app.domain.Veiculo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
public class ServicoPrestadoMapper {
    ServicoPortifolioService servicoPortifolioService;
    VeiculoService veiculoService;
    AdicionalMapper adicionalMapper;

    public ServicoPrestado dtoToDomain(ServicoPrestadoDTO servicoPrestadoDTO) {
        ServicoPortifolio servicoPortifolio = servicoPortifolioService.getById(servicoPrestadoDTO.servico().toString());
        Veiculo veiculo = veiculoService.getById(servicoPrestadoDTO.veiculo());
        List<Adicional> adicionais = adicionalMapper.idsAdicionaisToDomainList(servicoPrestadoDTO.adicionais());
        LocalDateTime dataEHora = servicoPrestadoDTO.dataEHora();
        return new ServicoPrestado(servicoPortifolio, veiculo, adicionais, dataEHora);
    }
}
