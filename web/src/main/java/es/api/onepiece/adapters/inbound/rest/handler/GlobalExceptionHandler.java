package es.api.onepiece.adapters.inbound.rest.handler;

import es.api.onepiece.core.exceptions.BoatException;
import es.api.onepiece.core.exceptions.CharacterException;
import es.api.onepiece.core.exceptions.FruitException;
import es.api.onepiece.core.exceptions.HakiException;
import es.api.onepiece.core.exceptions.SwordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * The Class GlobalExceptionHandler.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle character exception.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(CharacterException.class)
    public ResponseEntity<Map<String, String>> handleCharacterException(final CharacterException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("code", exception.getCode(), "message", exception.getMessage()));
    }

    /**
     * Handle fruit exception.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(FruitException.class)
    public ResponseEntity<Map<String, String>> handleFruitException(final FruitException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("code", exception.getCode(), "message", exception.getMessage()));
    }

    /**
     * Handle haki exception.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(HakiException.class)
    public ResponseEntity<Map<String, String>> handleHakiException(final HakiException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("code", exception.getCode(), "message", exception.getMessage()));
    }

    /**
     * Handle sword exception.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(SwordException.class)
    public ResponseEntity<Map<String, String>> handleSwordException(final SwordException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("code", exception.getCode(), "message", exception.getMessage()));
    }

    /**
     * Handle boat exception.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(BoatException.class)
    public ResponseEntity<Map<String, String>> handleBoatException(final BoatException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("code", exception.getCode(), "message", exception.getMessage()));
    }
}
