package com.lavaja.app.lavajato.adicional;

import com.lavaja.app.lavajato.adicional.cadastrar.AdicionalDTO;
import com.lavaja.app.application.service.AdicionalService;
import com.lavaja.app.lavajato.adicional.cadastrar.CadastrarAdicional;
import com.lavaja.app.domain.Adicional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/adicional")
public class AdicionalController {
    AdicionalService adicionalService;
    CadastrarAdicional cadastrarAdicional;

    @PostMapping
    public Adicional cadastrarAdicional(@RequestBody AdicionalDTO adicional) {
        return cadastrarAdicional.execute(adicional);
    }

    // TODO: paginação
    @GetMapping("/listar")
    public List<Adicional> listarAdicionais() {
        return adicionalService.listarAdicionais();
    }
}
