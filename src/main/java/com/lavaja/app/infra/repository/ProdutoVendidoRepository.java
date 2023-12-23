package com.lavaja.app.infra.repository;

import com.lavaja.app.lavajato.metricas.dto.MetricasDeUmProdutoDTO;
import com.lavaja.app.infra.model.ProdutoVendidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoVendidoRepository extends JpaRepository<ProdutoVendidoModel, String> {
    @Query("SELECT new com.lavaja.app.lavajato.metricas.dto.MetricasDeUmProdutoDTO(spr.id, spr.nome, COUNT(spo), SUM(spo.valor)) " +
            "FROM ProdutoVendidoModel spo " +
            "JOIN ProdutoModel spr ON spr = spo.produto " +
            "GROUP BY spo.id")
    List<MetricasDeUmProdutoDTO> selectMetricasDeVendas();
}
