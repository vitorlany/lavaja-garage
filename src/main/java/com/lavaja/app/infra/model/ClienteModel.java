package com.lavaja.app.infra.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class ClienteModel {

    @Id
    private String id;

    private String nome;

    @OneToMany
    private List<ContatoModel> contatos;

    @JsonIgnoreProperties({"pessoaDeConfianca"})
    @ManyToOne
    private ClienteModel pessoaDeConfianca;

    private LocalDate dataCriacao;
}
