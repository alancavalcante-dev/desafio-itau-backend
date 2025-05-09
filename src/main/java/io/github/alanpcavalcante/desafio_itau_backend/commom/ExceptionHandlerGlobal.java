package io.github.alanpcavalcante.desafio_itau_backend.commom;


import io.github.alanpcavalcante.desafio_itau_backend.exceptions.DataHoraMaiorQueAtual;
import io.github.alanpcavalcante.desafio_itau_backend.exceptions.ValorMenorQueZero;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerGlobal {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntime(RuntimeException ex) {
        return ResponseEntity.unprocessableEntity().body(ex.getMessage());
    }

    @ExceptionHandler(DataHoraMaiorQueAtual.class)
    public ResponseEntity<String> handleDataTempo(DataHoraMaiorQueAtual ex) {
        return ResponseEntity.badRequest().body(ex.getMessage() + "DataTempo");
    }

    @ExceptionHandler(ValorMenorQueZero.class)
    public ResponseEntity<String> handleValorMenor(ValorMenorQueZero ex) {
        return ResponseEntity.badRequest().body(ex.getMessage() + "Valor");
    }
}
