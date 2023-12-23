package com.lavaja.app.application.metricas.metricasDeVenda;

import com.lavaja.app.application.metricas.dto.MetricasDeUmProdutoDTO;
import com.lavaja.app.application.metricas.dto.MetricasDeVendasDTO;
import com.lavaja.app.infra.repository.ProdutoVendidoRepository;
import com.lavaja.app.infra.repository.ServicoPortifolioRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class MetricasDeVenda {
    ServicoPortifolioRepository servicoPortifolioRepository;
    ProdutoVendidoRepository produtoVendidoRepository;

    public MetricasDeVendasDTO total() {
        List<MetricasDeUmProdutoDTO> metricasDeUmProdutoDTOS =
                servicoPortifolioRepository.selectMetricasDeVendas();
        return this.gerarRelatorioFinal(metricasDeUmProdutoDTOS);
    }

    public MetricasDeVendasDTO produtos() {
        List<MetricasDeUmProdutoDTO> metricasDeUmProdutoDTOS =
                produtoVendidoRepository.selectMetricasDeVendas();
        return this.gerarRelatorioFinal(metricasDeUmProdutoDTOS);
    }

    public MetricasDeVendasDTO mesEAno(int mes, int ano) {
        YearMonth anoMes = YearMonth.of(ano, mes);

        LocalDateTime primeiroDiaDoMes = LocalDateTime.of(anoMes.getYear(), anoMes.getMonth(), 1, 0, 0);
        LocalDateTime ultimoDiaDoMes = LocalDateTime.of(anoMes.getYear(), anoMes.getMonth(), 1, 23, 59)
                .with(TemporalAdjusters.lastDayOfMonth());

        List<MetricasDeUmProdutoDTO> metricasDeUmProdutoDTOS = servicoPortifolioRepository
                .selectMetricasDeVendasPorMes(primeiroDiaDoMes, ultimoDiaDoMes);
        return this.gerarRelatorioFinal(metricasDeUmProdutoDTOS);
    }

    private MetricasDeVendasDTO gerarRelatorioFinal(List<MetricasDeUmProdutoDTO> metricasDeUmProdutoDTOS) {
        double faturamentoTotal = metricasDeUmProdutoDTOS
                .stream()
                .mapToDouble(MetricasDeUmProdutoDTO::faturamento)
                .sum();

        long numeroTotalDeVendas = metricasDeUmProdutoDTOS
                .stream()
                .mapToLong(MetricasDeUmProdutoDTO::numeroDeVendas)
                .sum();

        return new MetricasDeVendasDTO(metricasDeUmProdutoDTOS,
                faturamentoTotal,
                numeroTotalDeVendas);
    }
}
