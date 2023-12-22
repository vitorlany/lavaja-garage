package com.lavaja.app.infra.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ServicoPortifolioModel {

    @Id
    private String id;

    private String titulo;

    private double precoBase;

    private int tempoBase;

    @ManyToMany
    private List<AdicionalModel> adicionais;

    @OneToOne
    private AvaliacaoTecnicaModel avaliacaoTecnica;
}
