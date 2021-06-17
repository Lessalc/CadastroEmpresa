package com.codeanywhere.lessalc.apiempresa.dto.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class EnderecoDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String logradouro;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String numero;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String complemento;

    public EnderecoDTO(){}

    public EnderecoDTO(String logradouro, String numero, String complemento) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
