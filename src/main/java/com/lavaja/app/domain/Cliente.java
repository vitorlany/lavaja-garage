package com.lavaja.app.domain;

import com.lavaja.app.domain.annotation.Default;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class Cliente {
    private UUID id;
    private String nome;
    private List<Contato> contatos;
    private Cliente pessoaDeConfianca;
    private LocalDate dataCriacao;

    @Default
    public Cliente(@NotNull UUID id, String nome, List<Contato> contatos, Cliente pessoaDeConfianca) {
        this.id = id;
        this.nome = nome;
        this.contatos = contatos;
        this.pessoaDeConfianca = pessoaDeConfianca;
        this.dataCriacao = LocalDate.now();
    }

    public Cliente(String nome, List<Contato> contatos, Cliente pessoaDeConfianca) {
        this(UUID.randomUUID(), nome, contatos, pessoaDeConfianca);
    }

    public Cliente(String nome, List<Contato> contatos) {
        this(nome, contatos, null);
    }

    private void setId(UUID id) {
        this.id = id;
    }
}
