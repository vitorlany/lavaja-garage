package com.lavaja.app.infra.repository;

import com.lavaja.app.lavajato.metricas.dto.MetricasDeUmProdutoDTO;
import com.lavaja.app.infra.model.ServicoPortifolioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ServicoPortifolioRepository extends JpaRepository<ServicoPortifolioModel, String> {

    @Query("SELECT new com.lavaja.app.application.dto.MetricasDeUmProdutoDTO(spo.id, spo.titulo, COUNT(spr), SUM(spr.valor)) " +
            "FROM ServicoPortifolioModel spo " +
            "JOIN ServicoPrestadoModel spr ON spo = spr.servico " +
            "GROUP BY spo.id")
    List<MetricasDeUmProdutoDTO> selectMetricasDeVendas();

    @Query("SELECT new com.lavaja.app.application.dto.MetricasDeUmProdutoDTO(spo.id, spo.titulo, COUNT(spr), SUM(spr.valor)) " +
            "FROM ServicoPortifolioModel spo " +
            "JOIN ServicoPrestadoModel spr " +
            "ON (spo = spr.servico " +
            "AND spr.dataEHora BETWEEN :fromDate AND :toDate) " +
            "GROUP BY spo.id")
    List<MetricasDeUmProdutoDTO> selectMetricasDeVendasPorMes(
            @Param("fromDate") LocalDateTime fromDate,
            @Param("toDate") LocalDateTime toDate);
}
