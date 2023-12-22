package com.lavaja.app.infra.controller;

import com.lavaja.app.application.dto.ConcluirServicoDTO;
import com.lavaja.app.application.dto.ServicoPrestadoDTO;
import com.lavaja.app.application.service.ServicoPrestadoService;
import com.lavaja.app.application.usecase.CadastrarServicoPrestado;
import com.lavaja.app.application.usecase.ConcluirServico;
import com.lavaja.app.domain.ServicoPrestado;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/servico")
public class ServicoPrestadoController {
    CadastrarServicoPrestado cadastrarServicoPrestado;
    ServicoPrestadoService servicoPrestadoService;
    ConcluirServico concluirServico;

    @PostMapping
    public ServicoPrestado cadastrarServicoPrestado(
            @RequestBody ServicoPrestadoDTO servicoPrestadoDTO) {
        return cadastrarServicoPrestado.execute(servicoPrestadoDTO);
    }


    @PostMapping("/concluir")
    public ServicoPrestado concluirServico(
            @RequestBody ConcluirServicoDTO concluirServicoDTO) {
        return concluirServico.execute(concluirServicoDTO);
    }

    // TODO: paginação
    @GetMapping("/agendados")
    public List<ServicoPrestado> listarServicosAgendados() {
        return servicoPrestadoService.listarServicosAgendados();
    }

    // TODO: paginação
    @GetMapping("/prestados")
    public List<ServicoPrestado> listarServicosConcluidos() {
        return servicoPrestadoService.listarServicosConcluidos();
    }
}
