package br.com.fiap.abctechapi.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.fiap.abctechapi.handler.exception.MinAssistsException;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(MinAssistsException.class)
    public ResponseEntity<ErrorMessageResponse> errorMinAssistRequired(MinAssistsException exception) {
        ErrorMessageResponse error = new ErrorMessageResponse(
            HttpStatus.BAD_REQUEST.value(),
            new Date(),
            exception.getMessage(),
            exception.getDescription()
        );

        return new ResponseEntity<ErrorMessageResponse>(error, HttpStatus.BAD_REQUEST);
    }
}
