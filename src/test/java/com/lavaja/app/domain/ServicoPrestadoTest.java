package com.lavaja.app.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServicoPrestadoTest {
    ServicoPrestado servicoPrestado;

    @BeforeEach
    void setUp() {
        Adicional retrificacao = new Adicional("Retrificação de farois", 150, 30);
        Adicional limpezaInterna = new Adicional("Limpeza interna", 60, 60);
        ServicoPortifolio portifolio = new ServicoPortifolio("Limpeza externa expressa", 80, 60);
        servicoPrestado = new ServicoPrestado(
                portifolio,
                new Veiculo("ABC-1000"),
                List.of(retrificacao, limpezaInterna),
                LocalDateTime.now()
                );
    }

    @Test
    void calculoValor() {
        assertEquals(290, servicoPrestado.getValor());
    }

    @Test
    void calculoTempo() {
        assertEquals(150, servicoPrestado.getDuracao());
    }
}