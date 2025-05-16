package io.github.alanpcavalcante.desafio_itau_backend.domain.transaction;

import io.github.alanpcavalcante.desafio_itau_backend.exceptions.DateTimeGreaterThanCurrent;
import io.github.alanpcavalcante.desafio_itau_backend.exceptions.ValueLessThanZero;
import io.github.alanpcavalcante.desafio_itau_backend.infrastructure.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
@Slf4j
public class TransactionService {

    /** Lógica de négocio do nosso objeto Transacao.
     *
     * Antes de persistir em qualquer alteração dos dados é passado por uma camada de filtros,
     * que é o validacaoDeTransacoes, para incrementar qualquer validação no futuro, basta
     * inserir neste metodo.
     *
     */

    @Autowired
    private TransactionRepository repository;


    public void saveTransaction(Transaction transaction) {
        validateTransactions(transaction);
        repository.register(transaction);
    }


    public void clearCache() {
        repository.clear();
    }


    public void validateTransactions(Transaction transaction) {
        validateFields(transaction);
        validateValue(transaction.getValue());
        validateDate(transaction.getDateTime());
    }


    public void validateFields(Transaction transaction) {
        if (transaction.getValue() == null || transaction.getDateTime() == null) {
            log.info("ERROR: Campos não preenchidos");
            throw new RuntimeException();
        }
    }

    public void validateValue(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            log.info("ERROR: O valor tem que ser maior que zero");
            throw new ValueLessThanZero();
        }
    }

    public void validateDate(OffsetDateTime dateTime) {
        if (dateTime.isAfter(OffsetDateTime.now())) {
            log.info("ERROR: A data não pode ultrapassar a data atual");
            throw new DateTimeGreaterThanCurrent();
        }
    }
}
