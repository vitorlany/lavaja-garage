package com.lavaja.app.domain;

import com.lavaja.app.domain.annotation.Default;
import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

@Data
public class ServicoPortifolio {
    private UUID id;
    private String titulo;
    private double precoBase;
    private int tempoBase;
    private List<Adicional> adicionais;
    private AvaliacaoTecnica avaliacaoTecnica;

    @Default
    public ServicoPortifolio(@NonNull UUID id, String titulo, double precoBase, int tempoBase) {
        this.setId(id);
        this.titulo = titulo;
        this.setPrecoBase(precoBase);
        this.setTempoBase(tempoBase);
    }

    public ServicoPortifolio(String titulo, double precoBase, int tempoBase) {
        this(UUID.randomUUID(), titulo, precoBase, tempoBase);
    }

    public void setPrecoBase(double precoBase) {
        if (precoBase < 0)
            throw new IllegalArgumentException("O preço base deve ser positivo.");
        this.precoBase = precoBase;
    }

    public void setTempoBase(int tempoBase) {
        if (tempoBase < 0)
            throw new IllegalArgumentException("O tempo base deve ser positivo.");
        this.tempoBase = tempoBase;
    }

    private void setId(UUID id) {
        this.id = id;
    }
}
