package com.lavaja.app.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PerguntaAvaliacaoTecnicaTest {
    PerguntaAvaliacaoTecnica perguntaAvaliacaoTecnica;

    @BeforeEach
    void setUp() {
        perguntaAvaliacaoTecnica = new PerguntaAvaliacaoTecnica("Descrição", 60);
    }

    @Test
    void porcentagemForaDe1a100() {
        List.of(0, 101).forEach(number -> {
            assertThrows(IllegalArgumentException.class, () -> {
                perguntaAvaliacaoTecnica.setPorcentagem(number);
            });
        });
    }

    @Test
    void porcentagemDentroDe1e100() {
        List.of(1, 50, 100).forEach(number -> {
            perguntaAvaliacaoTecnica.setPorcentagem(number);
        });
    }
}