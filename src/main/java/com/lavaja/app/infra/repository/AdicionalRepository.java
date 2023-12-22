package com.lavaja.app.infra.repository;

import com.lavaja.app.infra.model.AdicionalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdicionalRepository extends JpaRepository<AdicionalModel, String> {
}
