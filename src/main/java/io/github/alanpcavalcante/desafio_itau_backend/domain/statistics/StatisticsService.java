package io.github.alanpcavalcante.desafio_itau_backend.domain.statistics;

import io.github.alanpcavalcante.desafio_itau_backend.infrastructure.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;

@Service
public class StatisticsService {

    @Autowired
    private TransactionRepository repository;

    public DoubleSummaryStatistics statistics(OffsetDateTime timeStarted) {
        final BigDecimal[] filtered = this.repository.transactions.stream()
                .filter(t -> t.getDateTime().isAfter(timeStarted) || t.getDateTime().equals(timeStarted))
                .map(t -> t.getValue()).toArray(BigDecimal[]::new);

        DoubleStream doubleStream = Arrays.stream(filtered).mapToDouble(BigDecimal::doubleValue);
        return doubleStream.summaryStatistics();
    }
}
