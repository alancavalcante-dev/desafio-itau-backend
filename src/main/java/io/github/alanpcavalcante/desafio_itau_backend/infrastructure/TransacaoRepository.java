package io.github.alanpcavalcante.desafio_itau_backend.infrastructure;

import io.github.alanpcavalcante.desafio_itau_backend.domain.transacao.Transacao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransacaoRepository {

    public List<Transacao> transacaos = new ArrayList<>();


    public void registrar(Transacao transacao) {
        this.transacaos.add(transacao);
    }

    public void limpar() {
        this.transacaos.clear();
    }
}
