package mg.rkmadagascar.gestionautomobile.controller;

import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public record ErreurReponse(int status, String message, LocalDateTime timestamp) {}

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErreurReponse> notFound(EntityNotFoundException e) {
        return build(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErreurReponse> regleMetier(IllegalStateException e) {
        return build(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErreurReponse> integrite(DataIntegrityViolationException e) {
        return build(HttpStatus.CONFLICT,
                "Opération impossible : cette donnée est liée à d'autres enregistrements ou viole une contrainte");
    }

    private ResponseEntity<ErreurReponse> build(HttpStatus status, String message) {
        return ResponseEntity.status(status)
                .body(new ErreurReponse(status.value(), message, LocalDateTime.now()));
    }
}
