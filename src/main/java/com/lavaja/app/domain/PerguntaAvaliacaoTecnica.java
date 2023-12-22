package com.lavaja.app.domain;

import com.lavaja.app.domain.annotation.Default;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
public class PerguntaAvaliacaoTecnica {
    private UUID id;
    private String descricao;
    private int porcentagem;

    @Default
    public PerguntaAvaliacaoTecnica(@NonNull UUID id, String descricao, int porcentagem) {
        this.setId(id);
        this.descricao = descricao;
        this.porcentagem = porcentagem;
    }

    public PerguntaAvaliacaoTecnica(String descricao, int porcentagem) {
        this(UUID.randomUUID(), descricao, porcentagem);
    }

    public void setPorcentagem(int porcentagem) {
        if (porcentagem < 1 || porcentagem > 100)
            throw new IllegalArgumentException("A porcentagem deve ser entre 0-100.");
        this.porcentagem = porcentagem;
    }

    private void setId(UUID id) {
        this.id = id;
    }
}
