package com.lavaja.app.infra.repository;

import com.lavaja.app.infra.model.AdicionalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdicionalRepository extends JpaRepository<AdicionalModel, String> {
}
