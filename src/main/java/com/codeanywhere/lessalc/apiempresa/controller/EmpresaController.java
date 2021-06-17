package com.codeanywhere.lessalc.apiempresa.controller;

import com.codeanywhere.lessalc.apiempresa.dto.request.EmpresaDTO;
import com.codeanywhere.lessalc.apiempresa.dto.response.MessageResponseDTO;
import com.codeanywhere.lessalc.apiempresa.exception.EmpresaNotFoundException;
import com.codeanywhere.lessalc.apiempresa.exception.NomeNotFound;
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
    public MessageResponseDTO createEmpresa(@RequestBody @Valid EmpresaDTO empresaDTO){
        return empresaService.createEmpresa(empresaDTO);
    }

    // *********** Recuperando Dados ***********
    @GetMapping
    public List<EmpresaDTO> listAll(){
        return empresaService.listAll();
    }

    @GetMapping("/{id}")
    public EmpresaDTO findById(@PathVariable Long id) throws EmpresaNotFoundException {
        return empresaService.findById(id);
    }

    @GetMapping("/nome/{nome}")
    public EmpresaDTO findByCnpj(@PathVariable String nome) throws NomeNotFound {
        return empresaService.findByName(nome);
    }



    // *********** Alterando Dados ***********
    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid EmpresaDTO empresaDTO) throws EmpresaNotFoundException {
        return empresaService.updateById(id, empresaDTO);
    }

    // *********** Deletando Dados ***********

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) throws EmpresaNotFoundException {
        empresaService.deleteById(id);
    }

}
