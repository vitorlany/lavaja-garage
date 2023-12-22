package com.lavaja.app.infra.controller;

import com.lavaja.app.application.dto.AtribuirClienteNoVeiculoDTO;
import com.lavaja.app.application.dto.VeiculoDTO;
import com.lavaja.app.application.service.ServicoPrestadoService;
import com.lavaja.app.application.service.VeiculoService;
import com.lavaja.app.application.usecase.AtribuirVeiculo;
import com.lavaja.app.application.usecase.CadastrarVeiculo;
import com.lavaja.app.domain.ServicoPrestado;
import com.lavaja.app.domain.Veiculo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/veiculo")
public class VeiculoController {
    VeiculoService veiculoService;
    CadastrarVeiculo cadastrarVeiculo;
    AtribuirVeiculo atribuirVeiculo;
    ServicoPrestadoService servicoPrestadoService;

    @PostMapping
    public Veiculo cadastrarVeiculo(@RequestBody VeiculoDTO veiculoDTO) {
        return cadastrarVeiculo.execute(veiculoDTO);
    }

    // TODO: paginação
    @GetMapping("/listar")
    public List<Veiculo> listarVeiculo() {
        return veiculoService.listarVeiculos();
    }

    @PostMapping("/atribuir/cliente")
    public Veiculo atribuirCliente(@RequestBody AtribuirClienteNoVeiculoDTO atribuirClienteNoVeiculoDTO) {
        return atribuirVeiculo.execute(atribuirClienteNoVeiculoDTO);
    }

    // TODO: paginação
    @GetMapping("/{id}/prestados")
    public List<ServicoPrestado> listarServicosConcluidosDoVeiculo(
            @PathVariable UUID id) {
        return servicoPrestadoService.listarServicosConcluidosDoVeiculo(id);
    }
}
