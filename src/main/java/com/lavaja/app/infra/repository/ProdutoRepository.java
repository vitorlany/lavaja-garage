package com.lavaja.app.infra.repository;

import com.lavaja.app.infra.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, String> {
}
