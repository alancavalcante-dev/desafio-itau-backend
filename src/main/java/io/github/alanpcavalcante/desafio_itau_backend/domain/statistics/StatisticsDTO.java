package io.github.alanpcavalcante.desafio_itau_backend.domain.statistics;

import lombok.Getter;
import lombok.Setter;

import java.util.DoubleSummaryStatistics;

@Getter
@Setter
public class StatisticsDTO {

    double count;
    double sum;
    double min;
    double max;
    double average;

    public StatisticsDTO(DoubleSummaryStatistics stats) {
        this.count = stats.getCount();
        this.sum = stats.getSum();
        this.average = stats.getAverage();
        this.min = (stats.getCount() == 0) ? 0 : stats.getMin();
        this.max = (stats.getCount() == 0) ? 0 : stats.getMax();
    }
}
