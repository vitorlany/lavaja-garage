package com.lavaja.app.infra.repository;

import com.lavaja.app.domain.enumerator.StatusServico;
import com.lavaja.app.infra.model.ServicoPrestadoModel;
import com.lavaja.app.infra.model.VeiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestadoModel, String> {
    List<ServicoPrestadoModel> findByStatusEquals(StatusServico statusServico);
    List<ServicoPrestadoModel> findByStatusEqualsOrderByDataEHoraDesc(StatusServico statusServico);
    List<ServicoPrestadoModel> findByStatusEqualsAndVeiculoEqualsOrderByDataEHoraDesc(StatusServico statusServico, VeiculoModel veiculoModel);
}
