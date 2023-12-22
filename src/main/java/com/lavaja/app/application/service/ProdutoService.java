package com.lavaja.app.application.service;

import com.lavaja.app.application.dto.MetricasDeUmProdutoDTO;
import com.lavaja.app.application.dto.ProdutoDTO;
import com.lavaja.app.infra.model.ProdutoModel;
import com.lavaja.app.infra.model.ProdutoVendidoModel;
import com.lavaja.app.infra.repository.ProdutoRepository;
import com.lavaja.app.infra.repository.ProdutoVendidoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@AllArgsConstructor
public class ProdutoService {
    ProdutoRepository produtoRepository;
    ProdutoVendidoRepository produtoVendidoRepository;
    //TODO: refatoração - adicionar domain / segregar mapper

    public ProdutoModel cadastrarProduto(ProdutoDTO produtoDTO) {
        ProdutoModel produto = new ProdutoModel();
            produto.setId(UUID.randomUUID().toString());
            produto.setNome(produtoDTO.nome());
            produto.setValor(produtoDTO.valor());
        produtoRepository.save(produto);
        return produto;
    }

    public ProdutoVendidoModel registrarVenda(UUID idProduto) {
        String id = idProduto.toString();
        ProdutoModel produto = produtoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Produto (" + id + ") não encontrado")
                );

        ProdutoVendidoModel produtoVendido = new ProdutoVendidoModel();
            produtoVendido.setId(UUID.randomUUID().toString());
            produtoVendido.setProduto(produto);
            produtoVendido.setValor(produto.getValor());

        log.info("Venda do produto " + produto.getId() + " realizada");
        produtoVendidoRepository.save(produtoVendido);
        return produtoVendido;
    }

    public List<ProdutoModel> listarProdutos() {
        return produtoRepository.findAll();
    }
}
