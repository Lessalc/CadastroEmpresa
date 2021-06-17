package com.codeanywhere.lessalc.apiempresa.service;


import com.codeanywhere.lessalc.apiempresa.dto.request.EmpresaDTO;
import com.codeanywhere.lessalc.apiempresa.dto.response.MessageResponseDTO;
import com.codeanywhere.lessalc.apiempresa.entity.Empresa;
import com.codeanywhere.lessalc.apiempresa.exception.CnpjNotFound;
import com.codeanywhere.lessalc.apiempresa.exception.EmpresaNotFoundException;
import com.codeanywhere.lessalc.apiempresa.mapper.EmpresaMapper;
import com.codeanywhere.lessalc.apiempresa.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmpresaService {

    private EmpresaRepository empresaRepository;

    private EmpresaMapper empresaMapper;

    public Empresa createEmpresa(EmpresaDTO empresaDTO) {
        Empresa empresaToSave = empresaMapper.toModel(empresaDTO);

        Empresa savedEmpresa = empresaRepository.save(empresaToSave);

        MessageResponseDTO messageResponseDTO = createMessageResponse("Company soccesfully created with ID: ", savedEmpresa.getId());

        return savedEmpresa;
    }

    private MessageResponseDTO createMessageResponse(String s, Long id) {
        return MessageResponseDTO
                .builder()
                .message(s + id)
                .build();
    }


    public List<Empresa> listAll() {
        List<Empresa> listEmpresas = empresaRepository.findAll();
        return listEmpresas;
    }

    public Empresa findById(Long id) throws EmpresaNotFoundException {
        Empresa empresaFound = verifyIfExists(id);
        return empresaFound;
    }

    public Empresa findByCnpj(String cnpj) throws CnpjNotFound {
        Empresa empresaFoundCnpj = verifyIfExistsCnpj(cnpj);
        return empresaFoundCnpj;
    }

    public Empresa verifyIfExists(Long id) throws EmpresaNotFoundException {
        return empresaRepository.findById(id).orElseThrow(() -> new EmpresaNotFoundException(id));
    }

    public Empresa verifyIfExistsCnpj(String cnpj) throws CnpjNotFound {
        Empresa empresa = empresaRepository.findByCnpj(cnpj).orElseThrow(() -> new CnpjNotFound(cnpj));
        return empresa;
    }


    public Empresa updateById(Long id, Empresa empresa) throws EmpresaNotFoundException {
        verifyIfExists(id);

        Empresa empresaToUpdate = empresaRepository.save(empresa);
        return empresaToUpdate;

    }

    public void deleteById(Long id) throws EmpresaNotFoundException {
        verifyIfExists(id);
        empresaRepository.deleteById(id);
    }
}
