package com.lavaja.app.application.dto;

import java.util.List;
import java.util.UUID;

public record AvaliacaoTecnicaDTO(
        List<PerguntaAvaliacaoTecnicaDTO> perguntas,
        UUID servicoIndicado,
        int porcentagemLimite
) {
}
