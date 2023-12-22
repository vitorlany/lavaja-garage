package com.lavaja.app.application.dto;

import java.util.UUID;

public record AtribuirClienteNoVeiculoDTO(
        UUID cliente,
        UUID veiculo
) {
}
