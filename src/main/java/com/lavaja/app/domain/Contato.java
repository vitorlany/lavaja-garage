package com.lavaja.app.domain;

import com.lavaja.app.domain.annotation.Default;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class Contato {
    private UUID id;
    private String valor;

    @Default
    public Contato(@NotNull UUID id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public Contato(String valor) {
        this(UUID.randomUUID(), valor);
    }


    private void setId(UUID id) {
        this.id = id;
    }
}
