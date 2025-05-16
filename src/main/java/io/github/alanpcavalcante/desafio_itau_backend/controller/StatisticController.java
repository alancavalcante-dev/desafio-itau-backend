package io.github.alanpcavalcante.desafio_itau_backend.controller;

import io.github.alanpcavalcante.desafio_itau_backend.domain.statistics.StatisticsService;
import io.github.alanpcavalcante.desafio_itau_backend.domain.statistics.StatisticsDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Endpoint de Estatistica")
public class StatisticController {

    /**
     * Este controller define o endpoint responsável por retornar estatísticas das transações.
     *
     * Optei por utilizar a anotação @Value para obter o valor do período das transações
     * diretamente do arquivo de variáveis de ambiente, tornando o sistema mais flexível.
     */

    @Value("${transactions.timer.seconds:60}")
    private int periodLastTransactions;

    @Autowired
    private StatisticsService service;

    @GetMapping
    @Operation(
            summary = "Estatísticas das transações efetuadas",
            description = "Exibe as estatísticas das transações a partir do momento da requisição, considerando um período de tempo configurável."
    )
    public ResponseEntity<StatisticsDTO> showStatistics() {
        log.info("Mostrar Estatísticas");

        final var hourStarted = OffsetDateTime.now().minusSeconds(periodLastTransactions);
        DoubleSummaryStatistics statisticsGenerated = service.statistics(hourStarted);
        StatisticsDTO statisticsDTO = new StatisticsDTO(statisticsGenerated);

        return ResponseEntity.ok(statisticsDTO);
    }

}
