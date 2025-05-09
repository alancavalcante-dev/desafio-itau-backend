package io.github.alanpcavalcante.desafio_itau_backend.domain.estatistica;

import io.github.alanpcavalcante.desafio_itau_backend.domain.transacao.Transacao;
import io.github.alanpcavalcante.desafio_itau_backend.infrastructure.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;

@Service
public class EstatistaService {

    @Autowired
    private TransacaoRepository repository;

    public DoubleSummaryStatistics estatistica(OffsetDateTime horaInicial) {
        final BigDecimal[] filtrados = this.repository.transacaos.stream()
                .filter(t -> t.getDataHora().isAfter(horaInicial) || t.getDataHora().equals(horaInicial))
                .map(t -> t.getValor()).toArray(BigDecimal[]::new);

        DoubleStream doubleStream = Arrays.stream(filtrados).mapToDouble(BigDecimal::doubleValue);
        return doubleStream.summaryStatistics();
    }
}
