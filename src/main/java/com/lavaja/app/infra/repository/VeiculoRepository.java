package com.lavaja.app.infra.repository;

import com.lavaja.app.infra.model.ClienteModel;
import com.lavaja.app.infra.model.VeiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoModel, String>{
    boolean existsByPlaca(String placa);
    List<VeiculoModel> findByDonoOrderByModelo(ClienteModel clienteModel);
}
