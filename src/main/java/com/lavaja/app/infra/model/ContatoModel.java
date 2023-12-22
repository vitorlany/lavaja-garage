package com.lavaja.app.infra.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ContatoModel {
    @Id
    private String id;

    private String valor;
}
