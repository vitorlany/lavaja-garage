package com.lavaja.app.infra.model;

import com.lavaja.app.domain.enumerator.StatusServico;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class ServicoPrestadoModel {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private ServicoPortifolioModel servico;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private VeiculoModel veiculo;

    @ManyToMany
    private List<AdicionalModel> adicionais;

    private LocalDateTime dataEHora;

    private int duracao;

    private double valor;

    @Enumerated(EnumType.STRING)
    private StatusServico status;
}
