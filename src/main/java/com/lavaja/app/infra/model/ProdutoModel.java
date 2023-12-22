package com.lavaja.app.infra.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ProdutoModel {

    @Id
    private String id;

    String nome;

    double valor;
}
