package com.lavaja.app.lavajato.metricas.dto;

public record MetricasDeUmProdutoDTO(
        String id,
        String produto,
        long numeroDeVendas,
        double faturamento
) {
}
