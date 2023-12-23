package com.lavaja.app.lavajato.servicoPortifolio.cadastrar;

import com.lavaja.app.lavajato.servicoPortifolio.cadastrar.PerguntaAvaliacaoTecnicaDTO;

import java.util.List;
import java.util.UUID;

public record AvaliacaoTecnicaDTO(
        List<PerguntaAvaliacaoTecnicaDTO> perguntas,
        UUID servicoIndicado,
        int porcentagemLimite
) {
}
