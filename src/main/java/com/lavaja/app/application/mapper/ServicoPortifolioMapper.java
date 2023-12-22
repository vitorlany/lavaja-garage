package com.lavaja.app.application.mapper;

import com.lavaja.app.application.dto.AvaliacaoTecnicaDTO;
import com.lavaja.app.application.dto.ServicoPortifolioDTO;
import com.lavaja.app.application.mapper.mapstruct.AvaliacaoTecnicaMSMapper;
import com.lavaja.app.application.service.ServicoPortifolioService;
import com.lavaja.app.domain.AvaliacaoTecnica;
import com.lavaja.app.domain.PerguntaAvaliacaoTecnica;
import com.lavaja.app.domain.ServicoPortifolio;
import com.lavaja.app.infra.model.AvaliacaoTecnicaModel;
import com.lavaja.app.infra.repository.AvaliacaoTecnicaRepository;
import com.lavaja.app.infra.repository.PerguntaAvaliacaoTecnicaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ServicoPortifolioMapper {
    static final AvaliacaoTecnicaMSMapper avaliacaoTecnicaMSMapper = AvaliacaoTecnicaMSMapper.INSTANCE;
    ServicoPortifolioService servicoPortifolioService;
    AvaliacaoTecnicaRepository avaliacaoTecnicaRepository;
    PerguntaAvaliacaoTecnicaRepository perguntaAvaliacaoTecnicaRepository;
    AdicionalMapper adicionalMapper;
    PerguntaAvaliacaoTecnicaMapper perguntaAvaliacaoTecnicaMapper;

    public ServicoPortifolio dtoToDomain(ServicoPortifolioDTO dto) {
        AvaliacaoTecnicaDTO avaliacaoTecnicaDTO = dto.avaliacaoTecnica();

        ServicoPortifolio servicoPortifolio = new ServicoPortifolio(dto.titulo(), dto.precoBase(), dto.tempoBase());

        servicoPortifolio.setAdicionais(
                adicionalMapper.idsAdicionaisToDomainList(
                        dto.adicionais()
                ));

        if (avaliacaoTecnicaDTO != null) {
            String idServicoIndicado = avaliacaoTecnicaDTO.servicoIndicado().toString();

            ServicoPortifolio servicoIndicado = servicoPortifolioService.getById(idServicoIndicado);
            List<PerguntaAvaliacaoTecnica> saveAllPerguntasFromDto = perguntaAvaliacaoTecnicaMapper.
                    createAllFromDto(avaliacaoTecnicaDTO.perguntas());

            AvaliacaoTecnica avaliacaoTecnica =
                    new AvaliacaoTecnica(
                            saveAllPerguntasFromDto,
                            servicoIndicado,
                            avaliacaoTecnicaDTO.porcentagemLimite());

            AvaliacaoTecnicaModel avaliacaoTecnicaModel = avaliacaoTecnicaMSMapper.domainToEntity(avaliacaoTecnica);
            perguntaAvaliacaoTecnicaRepository.saveAll(avaliacaoTecnicaModel.getPerguntas());
            avaliacaoTecnicaRepository.save(avaliacaoTecnicaModel);

            servicoPortifolio.setAvaliacaoTecnica(avaliacaoTecnica);
        }

        return servicoPortifolio;
    }
}
