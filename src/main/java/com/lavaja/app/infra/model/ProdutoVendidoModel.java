package com.lavaja.app.infra.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ProdutoVendidoModel {

    @Id
    private String id;

    @ManyToOne
    private ProdutoModel produto;

    private double valor;
}
