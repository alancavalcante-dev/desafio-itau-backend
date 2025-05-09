package io.github.alanpcavalcante.desafio_itau_backend.controller;

import io.github.alanpcavalcante.desafio_itau_backend.domain.estatistica.EstatistaService;
import io.github.alanpcavalcante.desafio_itau_backend.domain.estatistica.EstatisticaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
@Slf4j
public class EstatisticaController {

    @Value("${transactions.timer.seconds:60}")
    private int periodoUltimasTransacoes;

    @Autowired
    private EstatistaService service;

    @GetMapping
    public ResponseEntity<EstatisticaDTO> mostrarEstatistica() {
        log.info("Mostrar Estatísticas");

        final var horaInicial = OffsetDateTime.now().minusSeconds(periodoUltimasTransacoes);
        DoubleSummaryStatistics estatisticaGerada = service.estatistica(horaInicial);
        EstatisticaDTO estatisticaDTO = new EstatisticaDTO(estatisticaGerada);
        return ResponseEntity.ok(estatisticaDTO);
    }

}
