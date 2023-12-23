package com.lavaja.app.application.cliente.atribuirPessoaConfianca;

import java.util.UUID;

public record PessoaConfiancaDTO(
        UUID cliente,
        UUID pessoaDeConfianca
) {
}
