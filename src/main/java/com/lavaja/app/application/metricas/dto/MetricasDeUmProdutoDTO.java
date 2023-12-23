package com.lavaja.app.application.metricas.dto;

public record MetricasDeUmProdutoDTO(
        String id,
        String produto,
        long numeroDeVendas,
        double faturamento
) {
}
