package com.lavaja.app.application.produto;

import com.lavaja.app.infra.model.ProdutoModel;
import com.lavaja.app.infra.model.ProdutoVendidoModel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/produto")
public class ProdutoController {
    ProdutoService produtoService;

    @PostMapping("/cadastrar")
    public ProdutoModel cadastrarProduto(@RequestBody ProdutoDTO produtoDTO) {
        return produtoService.cadastrarProduto(produtoDTO);
    }

    @PostMapping("/vender/{id}")
    public ProdutoVendidoModel venderProduto(@PathVariable UUID id) {
        return produtoService.registrarVenda(id);
    }

    @GetMapping("/listar")
    public List<ProdutoModel> listar() {
        return produtoService.listarProdutos();
    }
}
