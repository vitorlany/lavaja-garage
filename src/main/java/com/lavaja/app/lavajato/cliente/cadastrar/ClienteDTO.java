package com.lavaja.app.lavajato.cliente.cadastrar;

import java.util.List;

public record ClienteDTO(
        String nome,
        List<String>contatos
) {
}
