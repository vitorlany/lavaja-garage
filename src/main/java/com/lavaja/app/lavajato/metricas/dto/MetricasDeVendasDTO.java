package com.lavaja.app.lavajato.metricas.dto;

import java.util.List;

public record MetricasDeVendasDTO(
        List<MetricasDeUmProdutoDTO> metricas,
        double faturamentoTotal,
        long numeroDeVendasTotal
) {
}
