package com.codeanywhere.lessalc.apiempresa.dto.request;

import com.codeanywhere.lessalc.apiempresa.entity.Endereco;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class EmpresaDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String nome;

    @NotEmpty
    private String cnpj;

    private String criacao;

    @Valid
    @NotNull
    private EnderecoDTO endereco;

    @Valid
    @NotNull
    private List<SocioDTO> socios;


    public EmpresaDTO(){}

    public EmpresaDTO(String nome, String cnpj, String criacao, EnderecoDTO endereco, List<SocioDTO> socios) {
        super();
        this.nome = nome;
        this.cnpj = cnpj;
        this.criacao = criacao;
        this.endereco = endereco;
        this.socios = socios;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCriacao() {
        return criacao;
    }

    public void setCriacao(String criacao) {
        this.criacao = criacao;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public List<SocioDTO> getSocios() {
        return socios;
    }

    public void setSocios(List<SocioDTO> socios) {
        this.socios = socios;
    }
}
