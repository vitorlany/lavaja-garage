package com.lavaja.app.application.usecase;


import com.lavaja.app.infra.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class MetricasDeCliente {
    ClienteRepository clienteRepository;

    public long total() {
        return clienteRepository.count();
    }
}
