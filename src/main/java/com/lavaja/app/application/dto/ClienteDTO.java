package com.lavaja.app.application.dto;

import java.util.List;

public record ClienteDTO(
        String nome,
        List<String>contatos
) {
}
