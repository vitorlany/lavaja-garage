package com.lavaja.app.infra.repository;

import com.lavaja.app.infra.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, String> {
}
