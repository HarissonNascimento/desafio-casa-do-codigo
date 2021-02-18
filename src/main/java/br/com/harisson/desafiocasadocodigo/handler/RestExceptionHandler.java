package br.com.harisson.desafiocasadocodigo.handler;

import br.com.harisson.desafiocasadocodigo.exception.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDetails> handlerMethodArgumentNotValidException(MethodArgumentNotValidException manve) {
        List<FieldError> fieldErrors = manve.getBindingResult().getFieldErrors();

        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String fieldMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        return new ResponseEntity<>(
                new ExceptionDetails(
                        "Method argument not valid, check documentation!",
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        fields,
                        fieldMessage
                ), HttpStatus.BAD_REQUEST

        );
    }
}
