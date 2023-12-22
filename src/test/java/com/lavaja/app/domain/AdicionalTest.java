package com.lavaja.app.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AdicionalTest {
    Adicional adicional;

    @BeforeEach
    void setUp() {
        adicional = new Adicional("Descrição", 50, 15);
    }

    @Test
    void valorAdicionalNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            adicional.setValor(-1);
        });
    }

    @Test
    void tempoAdicionalNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            adicional.setTempo(-1);
        });
    }

}