package com.lavaja.app.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicoPortifolioTest {
    ServicoPortifolio servicoPortifolio;

    @BeforeEach
    void setUp() {
        servicoPortifolio = new ServicoPortifolio("Teste", 80, 30);
    }

    @Test
    void precoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            servicoPortifolio.setPrecoBase(-1);
        });
    }

    @Test
    void tempoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            servicoPortifolio.setTempoBase(-1);
        });
    }
}