package io.github.alanpcavalcante.desafio_itau_backend.domain.estatistica;

import lombok.Getter;
import lombok.Setter;

import java.util.DoubleSummaryStatistics;

@Getter
@Setter
public class EstatisticaDTO {

    double count;
    double sum;
    double min;
    double max;
    double average;

    public EstatisticaDTO(DoubleSummaryStatistics stats) {
        this.count = stats.getCount();
        this.sum = stats.getSum();
        this.average = stats.getAverage();
        this.min = (stats.getCount() == 0) ? 0 : stats.getMin();
        this.max = (stats.getCount() == 0) ? 0 : stats.getMax();
    }
}
