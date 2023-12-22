package com.lavaja.app.infra.controller;

import com.lavaja.app.application.dto.MetricasDeUmProdutoDTO;
import com.lavaja.app.application.dto.MetricasDeVendasDTO;
import com.lavaja.app.application.usecase.MetricasDeCliente;
import com.lavaja.app.application.usecase.MetricasDeServico;
import com.lavaja.app.application.usecase.MetricasDeVenda;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/metrica")
public class MetricasController {
    MetricasDeVenda metricasDeVenda;
    MetricasDeServico metricasDeServico;
    MetricasDeCliente metricasDeCliente;

    @GetMapping("vendas")
    public MetricasDeVendasDTO metricasDeVendas() {
        return metricasDeVenda.total();
    }

    @GetMapping("vendas/{mes}/{ano}")
    public MetricasDeVendasDTO metricasDeVendasEmMesAno(
            @PathVariable int mes,
            @PathVariable int ano) {
        return metricasDeVenda.mesEAno(mes, ano);
    }

    @GetMapping("/produtos")
    public MetricasDeVendasDTO getVendasProdutos() {
        return metricasDeVenda.produtos();
    }

    @GetMapping("clientes")
    public long metricasClientes() {
        return metricasDeCliente.total();
    }
    
    @GetMapping("servicos/portifolio")
    public long metricasPortifolio() {
        return metricasDeServico.servicosPortifolio();
    }
    
    @GetMapping("servicos/prestados")
    public long metricasPrestados() {
        return metricasDeServico.servicosPrestados();
    }
    
    @GetMapping("servicos/agendados")
    public long metricasAgendados() {
        return metricasDeServico.servicosAgendados();
    }
}
