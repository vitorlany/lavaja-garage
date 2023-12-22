package com.lavaja.app.application.dto;

import java.util.UUID;

public record PessoaConfiancaDTO(
        UUID cliente,
        UUID pessoaDeConfianca
) {
}
