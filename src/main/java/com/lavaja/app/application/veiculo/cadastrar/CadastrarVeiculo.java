package com.lavaja.app.application.veiculo.cadastrar;

import com.lavaja.app.mapper.mapstruct.VeiculoMSMapper;
import com.lavaja.app.domain.Veiculo;
import com.lavaja.app.infra.model.VeiculoModel;
import com.lavaja.app.infra.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class CadastrarVeiculo {
    static final VeiculoMSMapper veiculoMSMapper = VeiculoMSMapper.INSTANCE;
    VeiculoRepository veiculoRepository;

    public Veiculo execute(VeiculoDTO veiculoDTO) {
        if (veiculoRepository.existsByPlaca(veiculoDTO.placa()))
            throw new IllegalArgumentException("Veículo já registrado");
        Veiculo veiculo = veiculoMSMapper.dtoToDomain(veiculoDTO);
        VeiculoModel veiculoModel = veiculoMSMapper.domainToModel(veiculo);
        veiculoRepository.save(veiculoModel);
        log.info("Veículo cadastrado: " + veiculo.getId());
        return veiculo;
    }
}
