package com.lavaja.app.infra.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class AvaliacaoTecnicaModel {

    @Id
    private String id;

    @ManyToMany
    private List<PerguntaAvaliacaoTecnicaModel> perguntas;

    @ManyToOne
    @JoinColumn(name = "servico_id")

    private ServicoPortifolioModel servicoIndicado;

    private int porcentagemLimite;
}
