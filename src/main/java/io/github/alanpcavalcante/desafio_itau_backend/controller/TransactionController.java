package io.github.alanpcavalcante.desafio_itau_backend.controller;


import io.github.alanpcavalcante.desafio_itau_backend.domain.transaction.Transaction;
import io.github.alanpcavalcante.desafio_itau_backend.domain.transaction.TransactionService;
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
public class TransactionController {


    @Autowired
    private TransactionService service;


    @PostMapping
    @Operation(summary = "Registra uma transação")
    public ResponseEntity<Void> registerTransaction(@RequestBody Transaction transaction) {
        log.info("Adicionando Transação");

        service.saveTransaction(transaction);
        log.info("Transação adicionada com sucesso.");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping
    @Operation(summary = "Limpa todas transações")
    public ResponseEntity<Void> clearCacheTransaction() {
        log.info("Limpando Transações");

        service.clearCache();
        log.info("Cache das transações limpas com sucesso.");
        return ResponseEntity.noContent().build();

    }

}
