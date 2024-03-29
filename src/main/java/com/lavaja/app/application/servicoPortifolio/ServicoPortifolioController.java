package com.lavaja.app.application.servicoPortifolio;

import com.lavaja.app.application.servicoPortifolio.cadastrar.ServicoPortifolioDTO;
import com.lavaja.app.application.servicoPortifolio.cadastrar.CadastrarServicoNoPortifolio;
import com.lavaja.app.domain.ServicoPortifolio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/portifolio")
public class ServicoPortifolioController {
    ServicoPortifolioService servicoPortifolioService;
    CadastrarServicoNoPortifolio cadastrarServicoNoPortifolio;

    @PostMapping
    public ServicoPortifolio cadastrarServicoNoPortifolio(
            @RequestBody ServicoPortifolioDTO servico) {
        return cadastrarServicoNoPortifolio.execute(servico);
    }

    @GetMapping("/listar")
    public List<ServicoPortifolio> listarServicosNoPortifolio() {
        return servicoPortifolioService.listarServicos();
    }
}
