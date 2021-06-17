package com.codeanywhere.lessalc.apiempresa.controller;

import com.codeanywhere.lessalc.apiempresa.dto.request.EmpresaDTO;
import com.codeanywhere.lessalc.apiempresa.entity.Empresa;
import com.codeanywhere.lessalc.apiempresa.exception.CnpjNotFound;
import com.codeanywhere.lessalc.apiempresa.exception.EmpresaNotFoundException;
import com.codeanywhere.lessalc.apiempresa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/apicadastro/v1/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    // *********** Inserindo Dados ***********
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa createEmpresa(@RequestBody @Valid EmpresaDTO empresaDTO){
        return empresaService.createEmpresa(empresaDTO);
    }

    // *********** Recuperando Dados ***********
    @GetMapping
    public List<Empresa> listAll(){
        return empresaService.listAll();
    }

    @GetMapping("/{id}")
    public Empresa findById(@PathVariable Long id) throws EmpresaNotFoundException {
        return empresaService.findById(id);
    }

    @GetMapping("/cnpj/{cnpj}")
    public Empresa findByCnpj(@PathVariable String cnpj) throws CnpjNotFound {
        return empresaService.findByCnpj(cnpj);
    }



    // *********** Alterando Dados ***********
    @PutMapping("/{id}")
    public Empresa updateById(@PathVariable Long id, @RequestBody @Valid Empresa empresa) throws EmpresaNotFoundException {
        return empresaService.updateById(id, empresa);
    }

    // *********** Deletando Dados ***********

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) throws EmpresaNotFoundException {
        empresaService.deleteById(id);
    }

}
