package com.system.management_system.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionUser {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        if (ex.getMessage().contains("($username) não existente...favor inserir um usuário correto")) {
            String errorMessage = "Não foi possível adicionar a carteira. O usuário '$username' não foi encontrado.";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Ocorreu um erro ao processar a solicitação.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
