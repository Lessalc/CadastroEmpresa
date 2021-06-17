package com.codeanywhere.lessalc.apiempresa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CnpjNotFound extends Exception{

    public CnpjNotFound(String cnpj){
        super("Empresa not found with CNPJ: "+cnpj);
    }


}
