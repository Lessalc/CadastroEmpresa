package com.codeanywhere.lessalc.apiempresa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmpresaNotFoundException extends Exception {

    public EmpresaNotFoundException(Long id){
        super("Empresa not found with ID: "+id);
    }
}
