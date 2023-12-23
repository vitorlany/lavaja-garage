package com.lavaja.app.lavajato.veiculo.atribuirCliente;

import java.util.UUID;

public record AtribuirClienteNoVeiculoDTO(
        UUID cliente,
        UUID veiculo
) {
}
