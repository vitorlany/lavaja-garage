package com.lavaja.app.lavajato.cliente.atribuirPessoaConfianca;

import java.util.UUID;

public record PessoaConfiancaDTO(
        UUID cliente,
        UUID pessoaDeConfianca
) {
}
