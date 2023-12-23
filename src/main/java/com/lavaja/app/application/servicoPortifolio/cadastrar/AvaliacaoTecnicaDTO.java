package com.lavaja.app.application.servicoPortifolio.cadastrar;

import java.util.List;
import java.util.UUID;

public record AvaliacaoTecnicaDTO(
        List<PerguntaAvaliacaoTecnicaDTO> perguntas,
        UUID servicoIndicado,
        int porcentagemLimite
) {
}
