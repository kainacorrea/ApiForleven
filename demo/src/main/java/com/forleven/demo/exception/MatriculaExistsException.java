package com.forleven.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MatriculaExistsException extends RuntimeException{
    public MatriculaExistsException(String mensagem) {
        super(mensagem);
    }
}
