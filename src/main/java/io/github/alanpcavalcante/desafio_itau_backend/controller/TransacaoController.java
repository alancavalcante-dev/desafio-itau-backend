package io.github.alanpcavalcante.desafio_itau_backend.controller;


import io.github.alanpcavalcante.desafio_itau_backend.domain.transacao.Transacao;
import io.github.alanpcavalcante.desafio_itau_backend.domain.transacao.TransacaoService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
@Tag(name = "Endpoint de Transações")
@Slf4j
public class TransacaoController {


    @Autowired
    private TransacaoService service;


    @PostMapping
    @Operation(summary = "Registra uma transação")
    public ResponseEntity<Void> registrarTransacao(@RequestBody Transacao transacao) {
        log.info("Adicionando Transação");

        service.salvarTransacao(transacao);
        log.info("Transação adicionada com sucesso.");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping
    @Operation(summary = "Limpa todas transações")
    public ResponseEntity<Void> limparCacheTransacao() {
        log.info("Limpando Transações");

        service.limparCache();
        log.info("Cache das transações limpas com sucesso.");
        return ResponseEntity.noContent().build();

    }

}
