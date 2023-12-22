package com.lavaja.app.application.dto;

import java.util.List;
import java.util.UUID;

public record ServicoPortifolioDTO(
        String titulo,
        double precoBase,
        int tempoBase,
        List<UUID> adicionais,
        AvaliacaoTecnicaDTO avaliacaoTecnica
) {
}
