package com.lavaja.app.domain;

import com.lavaja.app.domain.annotation.Default;
import com.lavaja.app.domain.enumerator.StatusServico;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class ServicoPrestado {
    private UUID id;
    private ServicoPortifolio servico;
    private Veiculo veiculo;
    private List<Adicional> adicionais;
    private LocalDateTime dataEHora;
    private int duracao;
    private double valor;
    private StatusServico status;

    @Default
    public ServicoPrestado(@NonNull UUID id, ServicoPortifolio servico, Veiculo veiculo, List<Adicional> adicionais, LocalDateTime dataEHora) {
        this.setId(id);
        this.servico = servico;
        this.veiculo = veiculo;
        this.adicionais = adicionais;
        this.dataEHora = dataEHora;

        this.status = StatusServico.AGENDADO;
        this.setDuracao();
        this.setValor();
    }

    public ServicoPrestado(ServicoPortifolio servico, Veiculo veiculo, List<Adicional> adicionais, LocalDateTime dataEHora) {
        this(UUID.randomUUID(), servico, veiculo, adicionais, dataEHora);
    }

    public void concluirServico() {
        if (status == StatusServico.CONCLUIDO)
            throw new IllegalStateException("Serviço (" + id + ") já está concluído");
        this.status = StatusServico.CONCLUIDO;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    private void setStatus(StatusServico status) {
        this.status = status;
    }

    private void setDuracao() {
        int tempo = this.getServico().getTempoBase();
        if (this.adicionais != null) {
            tempo += this.getAdicionais().stream()
                    .mapToInt(Adicional::getTempo)
                    .sum();
        }
        this.duracao = tempo;
    }

    private void setValor() {
        double preco = this.getServico().getPrecoBase();
        if (this.adicionais != null) {
            preco += this.getAdicionais().stream()
                    .mapToDouble(Adicional::getValor)
                    .sum();
        }
        this.valor = preco;
    }
}
