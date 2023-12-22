package com.lavaja.app.infra.repository;

import com.lavaja.app.application.dto.MetricasDeUmProdutoDTO;
import com.lavaja.app.infra.model.ProdutoVendidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoVendidoRepository extends JpaRepository<ProdutoVendidoModel, String> {
    @Query("SELECT new com.lavaja.app.application.dto.MetricasDeUmProdutoDTO(spr.id, spr.nome, COUNT(spo), SUM(spo.valor)) " +
            "FROM ProdutoVendidoModel spo " +
            "JOIN ProdutoModel spr ON spr = spo.produto " +
            "GROUP BY spo.id")
    List<MetricasDeUmProdutoDTO> selectMetricasDeVendas();
}
