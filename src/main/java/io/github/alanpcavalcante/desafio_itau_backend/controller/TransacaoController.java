package io.github.alanpcavalcante.desafio_itau_backend.controller;


import io.github.alanpcavalcante.desafio_itau_backend.domain.transacao.Transacao;
import io.github.alanpcavalcante.desafio_itau_backend.domain.transacao.TransacaoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
@Slf4j
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @PostMapping
    public ResponseEntity<Void> registrarTransacao(@RequestBody Transacao transacao) {
        log.info("Adicionando Transação");

        service.salvarTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> limparCacheTransacao() {
        log.info("Limpando Transações");

        service.limparCache();
        return ResponseEntity.noContent().build();

    }

}
