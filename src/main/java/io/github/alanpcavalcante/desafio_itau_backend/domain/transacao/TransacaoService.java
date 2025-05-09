package io.github.alanpcavalcante.desafio_itau_backend.domain.transacao;

import io.github.alanpcavalcante.desafio_itau_backend.exceptions.DataHoraMaiorQueAtual;
import io.github.alanpcavalcante.desafio_itau_backend.exceptions.ValorMenorQueZero;
import io.github.alanpcavalcante.desafio_itau_backend.infrastructure.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    /** Lógica de négocio do nosso objeto Transacao.
     *
     * Antes de persistir em qualquer alteração dos dados é passado por uma camada de filtros,
     * que é o validacaoDeTransacoes, para incrementar qualquer validação no futuro, basta
     * inserir neste metodo.
     *
     */

    @Autowired
    private TransacaoRepository repository;


    public void salvarTransacao(Transacao transacao) {
        validacaoDeTransacoes(transacao);
        repository.registrar(transacao);
    }


    public void limparCache() {
        repository.limpar();
    }


    public void validacaoDeTransacoes(Transacao transacao) {
        validarCampos(transacao);
        validarValor(transacao.getValor());
        validarData(transacao.getDataHora());
    }


    public void validarCampos(Transacao transacao) {
        if (transacao.getValor() == null || transacao.getDataHora() == null) {
            throw new RuntimeException();
        }
    }


    public void validarData(OffsetDateTime dataHora) {
        if (dataHora.isAfter(OffsetDateTime.now())) {
            throw new DataHoraMaiorQueAtual();
        }
    }


    public void validarValor(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new ValorMenorQueZero();
        }
    }
}
