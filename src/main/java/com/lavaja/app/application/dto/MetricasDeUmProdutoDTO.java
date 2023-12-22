package com.lavaja.app.application.dto;

public record MetricasDeUmProdutoDTO(
        String id,
        String produto,
        long numeroDeVendas,
        double faturamento
) {
}
