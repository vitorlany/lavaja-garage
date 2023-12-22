package com.lavaja.app.application.mapper;

import com.lavaja.app.application.dto.PerguntaAvaliacaoTecnicaDTO;
import com.lavaja.app.application.mapper.mapstruct.PerguntaAvaliacaoTecnicaMSMapper;
import com.lavaja.app.domain.PerguntaAvaliacaoTecnica;
import com.lavaja.app.infra.model.PerguntaAvaliacaoTecnicaModel;
import com.lavaja.app.infra.repository.PerguntaAvaliacaoTecnicaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PerguntaAvaliacaoTecnicaMapper {
    static final PerguntaAvaliacaoTecnicaMSMapper perguntaAvaliacaoTecnicaMSMapper = PerguntaAvaliacaoTecnicaMSMapper.INSTANCE;
    PerguntaAvaliacaoTecnicaRepository perguntaAvaliacaoTecnicaRepository;

    List<PerguntaAvaliacaoTecnica> createAllFromDto (List<PerguntaAvaliacaoTecnicaDTO> listaDto) {
        List<PerguntaAvaliacaoTecnica> list = listaDto.stream()
                .map(perguntaAvaliacaoTecnicaMSMapper::dtoToDomain)
                .toList();

        list.forEach(domain -> {
            PerguntaAvaliacaoTecnicaModel perguntaAvaliacaoTecnicaModel = perguntaAvaliacaoTecnicaMSMapper.domainToModel(domain);
            perguntaAvaliacaoTecnicaRepository.save(perguntaAvaliacaoTecnicaModel);
        });

        return list;
    }
}
