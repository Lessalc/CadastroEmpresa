package com.codeanywhere.lessalc.apiempresa.exception;

public class NomeNotFound extends Exception{

    public NomeNotFound(String nome){
        super("Empresa not found with name: "+nome);
    }
}
