package com.lavaja.app.domain;

import com.lavaja.app.domain.annotation.Default;
import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

@Data
public class AvaliacaoTecnica {
    private UUID id;
    private List<PerguntaAvaliacaoTecnica> perguntas;
    private ServicoPortifolio servicoIndicado;
    private int porcentagemLimite;

    @Default
    public AvaliacaoTecnica(@NonNull UUID id, List<PerguntaAvaliacaoTecnica> perguntas, ServicoPortifolio servicoIndicado, int porcentagemLimite) {
        this.setId(id);
        this.perguntas = perguntas;
        this.servicoIndicado = servicoIndicado;
        this.porcentagemLimite = porcentagemLimite;
    }

    public AvaliacaoTecnica(List<PerguntaAvaliacaoTecnica> perguntas, ServicoPortifolio servicoIndicado, int porcentagemLimite) {
        this(UUID.randomUUID(), perguntas, servicoIndicado, porcentagemLimite);
    }

    private void setId(UUID id) {
        this.id = id;
    }
}
