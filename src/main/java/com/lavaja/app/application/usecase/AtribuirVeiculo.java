package com.lavaja.app.application.usecase;

import com.lavaja.app.application.dto.AtribuirClienteNoVeiculoDTO;
import com.lavaja.app.application.mapper.mapstruct.ClienteMSMapper;
import com.lavaja.app.application.mapper.mapstruct.VeiculoMSMapper;
import com.lavaja.app.application.service.ClienteService;
import com.lavaja.app.application.service.VeiculoService;
import com.lavaja.app.domain.Cliente;
import com.lavaja.app.domain.Veiculo;
import com.lavaja.app.infra.model.ClienteModel;
import com.lavaja.app.infra.model.VeiculoModel;
import com.lavaja.app.infra.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class AtribuirVeiculo {
    static final VeiculoMSMapper veiculoMSMapper = VeiculoMSMapper.INSTANCE;
    VeiculoService veiculoService;
    ClienteService clienteService;
    VeiculoRepository veiculoRepository;

    public Veiculo execute(AtribuirClienteNoVeiculoDTO atribuirVeiculoDTO) {
        Veiculo veiculo = veiculoService.getById(atribuirVeiculoDTO.veiculo());
        Cliente cliente = clienteService.getById(atribuirVeiculoDTO.cliente());
        veiculo.setDono(cliente);

        VeiculoModel veiculoModel = veiculoMSMapper.domainToModel(veiculo);
        veiculoRepository.save(veiculoModel);
        return veiculo;
    }
}
