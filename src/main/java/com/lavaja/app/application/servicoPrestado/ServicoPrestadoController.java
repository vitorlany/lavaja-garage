package com.lavaja.app.application.servicoPrestado;

import com.lavaja.app.application.servicoPrestado.concluir.ConcluirServicoDTO;
import com.lavaja.app.application.servicoPrestado.cadastrar.ServicoPrestadoDTO;
import com.lavaja.app.application.servicoPrestado.cadastrar.CadastrarServicoPrestado;
import com.lavaja.app.application.servicoPrestado.concluir.ConcluirServico;
import com.lavaja.app.domain.ServicoPrestado;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
