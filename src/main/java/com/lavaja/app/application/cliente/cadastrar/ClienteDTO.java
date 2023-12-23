package com.lavaja.app.application.cliente.cadastrar;

import java.util.List;

public record ClienteDTO(
        String nome,
        List<String>contatos
) {
}
