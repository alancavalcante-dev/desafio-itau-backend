package io.github.alanpcavalcante.desafio_itau_backend.infrastructure;

import io.github.alanpcavalcante.desafio_itau_backend.domain.transaction.Transaction;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component
public class TransactionRepository {

    public List<Transaction> transactions = new ArrayList<>();


    public void register(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void clear() {
        this.transactions.clear();
    }
}
