package com.lavaja.app.application.veiculo.atribuirCliente;

import java.util.UUID;

public record AtribuirClienteNoVeiculoDTO(
        UUID cliente,
        UUID veiculo
) {
}
