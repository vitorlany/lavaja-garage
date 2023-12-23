package com.lavaja.app.infra.repository;

import com.lavaja.app.infra.model.PerguntaAvaliacaoTecnicaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaAvaliacaoTecnicaRepository extends JpaRepository<PerguntaAvaliacaoTecnicaModel, String>{
}
