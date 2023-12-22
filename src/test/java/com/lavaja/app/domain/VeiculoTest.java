package com.lavaja.app.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VeiculoTest {

    @Test
    void placasInvalidas() {
        List.of(
                "ABC-1K23", // Ultrapassando J na letra à direita
                "1BC-1J23", // Número à esquerda
                "ABC-1A2B"  // Letra a direita
        ).forEach((placa) -> {
            assertThrows(IllegalArgumentException.class,
                    () -> new Veiculo(placa));
        });
    }

    @Test
    void placaValida() {
        List.of(
                "AAA-0A00",
                "HZY-4416",
                "MYP-2330",
                "JFM-9058",
                "MXE-8382",
                "JFM-9058",
                "KIM-0731",
                "ABC-0A00",
                "ABC-0J00"
        ).forEach(Veiculo::new);
    }
}