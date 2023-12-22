package com.lavaja.app.infra.repository;

import com.lavaja.app.infra.model.ContatoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<ContatoModel, String> {
}
