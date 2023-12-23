package com.lavaja.app.lavajato.cliente;

import com.lavaja.app.lavajato.cliente.cadastrar.ClienteDTO;
import com.lavaja.app.lavajato.cliente.atribuirPessoaConfianca.PessoaConfiancaDTO;
import com.lavaja.app.application.service.ClienteService;
import com.lavaja.app.application.service.VeiculoService;
import com.lavaja.app.lavajato.cliente.cadastrar.CadastrarCliente;
import com.lavaja.app.lavajato.cliente.atribuirPessoaConfianca.AtribuirPessoaConfianca;
import com.lavaja.app.domain.Cliente;
import com.lavaja.app.domain.Veiculo;
import com.lavaja.app.infra.model.ClienteModel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {
    ClienteService clienteService;
    AtribuirPessoaConfianca atribuirPessoaConfianca;
    CadastrarCliente cadastrarCliente;
    VeiculoService veiculoService;

    @PostMapping
    public Cliente cadastrarCliente(ClienteDTO clienteDTO) {
        return cadastrarCliente.execute(clienteDTO);
    }

    @PostMapping("/confianca")
    public Cliente atribuirPessoaConfianca(PessoaConfiancaDTO pessoaConfiancaDTO) {
        return atribuirPessoaConfianca.execute(pessoaConfiancaDTO);
    }

    // TODO: paginação (todas listagens)
    @GetMapping("/listar")
    public List<ClienteModel> listarClientesCadastrados() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable UUID id) {
        return clienteService.getById(id);
    }

    @GetMapping("/{id}/veiculos")
    public List<Veiculo> getClienteVeiculos(@PathVariable UUID id) {
        return veiculoService.listarVeiculosDeUmCliente(id);
    }
}