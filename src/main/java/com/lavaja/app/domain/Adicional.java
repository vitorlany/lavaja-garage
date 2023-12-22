package com.lavaja.app.domain;

import com.lavaja.app.domain.annotation.Default;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
public class Adicional {
    private UUID id;
    private String descricao;
    private double valor;
    private int tempo;

    @Default
    public Adicional(@NonNull UUID id, String descricao, double valor, int tempo) {
        this.setId(id);
        this.descricao = descricao;
        this.setValor(valor);
        this.setTempo(tempo);
    }

    public Adicional(String descricao, double valor, int tempo) {
        this(UUID.randomUUID(), descricao, valor, tempo);
    }

    public void setValor(double valor) {
        if (valor < 0) throw new IllegalArgumentException("O valor deve ser positivo.");
        this.valor = valor;
    }

    public void setTempo(int tempo) {
        if (tempo < 0) throw new IllegalArgumentException("O tempo deve ser positivo.");
        this.tempo = tempo;
    }

    private void setId(UUID id) {
        this.id = id;
    }
}
