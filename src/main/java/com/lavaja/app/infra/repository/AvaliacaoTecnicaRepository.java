package com.lavaja.app.infra.repository;

import com.lavaja.app.infra.model.AvaliacaoTecnicaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoTecnicaRepository extends JpaRepository<AvaliacaoTecnicaModel, String> {
}
