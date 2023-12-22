package com.lavaja.app.infra.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class VeiculoModel {
    @Id
    private String id;

    private String placa;

    private String modelo;

    private String cor;

    @ManyToOne
    private ClienteModel dono;
}
