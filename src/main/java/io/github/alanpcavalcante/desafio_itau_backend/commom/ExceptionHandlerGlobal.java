package io.github.alanpcavalcante.desafio_itau_backend.commom;


import io.github.alanpcavalcante.desafio_itau_backend.exceptions.DateTimeGreaterThanCurrent;
import io.github.alanpcavalcante.desafio_itau_backend.exceptions.ValueLessThanZero;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerGlobal {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntime(RuntimeException ex) {
        return ResponseEntity.unprocessableEntity().build();
    }

    @ExceptionHandler(DateTimeGreaterThanCurrent.class)
    public ResponseEntity<String> handleDateTime(DateTimeGreaterThanCurrent ex) {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(ValueLessThanZero.class)
    public ResponseEntity<String> handleValueLess(ValueLessThanZero ex) {
        return ResponseEntity.badRequest().build();
    }
}
