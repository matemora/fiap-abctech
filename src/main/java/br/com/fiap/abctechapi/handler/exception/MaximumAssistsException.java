package br.com.fiap.abctechapi.handler.exception;

import lombok.Getter;

@Getter
public class MaximumAssistsException extends RuntimeException {
    private String description;

    public MaximumAssistsException(String message, String description) {
        super(message);
        this.description = description;
    }
}
