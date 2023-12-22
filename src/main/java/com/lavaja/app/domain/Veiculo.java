package com.lavaja.app.domain;

import com.lavaja.app.domain.annotation.Default;
import com.lavaja.app.infra.model.ClienteModel;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
public class Veiculo {
    private UUID id;
    private String placa;
    private String modelo;
    private String cor;
    private Cliente dono;

    @Default
    public Veiculo(@NonNull UUID id, String placa) {
        this.setId(id);
        this.setPlaca(placa);
    }

    public Veiculo(String placa) {
        this(UUID.randomUUID(), placa);
    }

    public void setPlaca(String placa) {
        String regex = "^[A-Z]{3}(-?|\\s)[0-9]([0-9]|[A-J])[0-9]{2}$";
        if (!placa.matches(regex))
            throw new IllegalArgumentException(String.format(
                    "Placa inválida: %s", placa
            ));
        this.placa = placa;
    }

    private void setId(UUID id) {
        this.id = id;
    }
}
