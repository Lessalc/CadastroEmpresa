package com.codeanywhere.lessalc.apiempresa.dto.request;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SocioDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String nome;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String sobrenome;

    @NotEmpty
    @CPF
    private String cpf;

    public SocioDTO(){}

    public SocioDTO(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
