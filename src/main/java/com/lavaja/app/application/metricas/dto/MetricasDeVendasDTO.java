package com.lavaja.app.application.metricas.dto;

import java.util.List;

public record MetricasDeVendasDTO(
        List<MetricasDeUmProdutoDTO> metricas,
        double faturamentoTotal,
        long numeroDeVendasTotal
) {
}
