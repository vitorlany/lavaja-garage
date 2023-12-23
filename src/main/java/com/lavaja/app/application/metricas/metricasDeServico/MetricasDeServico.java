package com.lavaja.app.application.metricas.metricasDeServico;


import com.lavaja.app.domain.enumerator.StatusServico;
import com.lavaja.app.infra.repository.ServicoPortifolioRepository;
import com.lavaja.app.infra.repository.ServicoPrestadoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class MetricasDeServico {
    ServicoPortifolioRepository servicoPortifolioRepository;
    ServicoPrestadoRepository servicoPrestadoRepository;

    public int servicosPrestados() {
        return servicoPrestadoRepository
                .findByStatusEquals(StatusServico.CONCLUIDO)
                .size();
    }

    public int servicosAgendados() {
        return servicoPrestadoRepository
                .findByStatusEquals(StatusServico.AGENDADO)
                .size();
    }

    public long servicosPortifolio() {
        return servicoPortifolioRepository.count();
    }
}
