package com.lavaja.app.application.servicoPrestado.cadastrar;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ServicoPrestadoDTO(
        UUID servico, // ID
        UUID veiculo, // ID
        List<UUID>adicionais, // ID
        LocalDateTime dataEHora
) {
}
