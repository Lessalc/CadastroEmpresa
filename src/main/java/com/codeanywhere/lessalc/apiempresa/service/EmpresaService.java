package com.codeanywhere.lessalc.apiempresa.service;


import com.codeanywhere.lessalc.apiempresa.dto.request.EmpresaDTO;
import com.codeanywhere.lessalc.apiempresa.dto.response.MessageResponseDTO;
import com.codeanywhere.lessalc.apiempresa.entity.Empresa;
import com.codeanywhere.lessalc.apiempresa.exception.EmpresaNotFoundException;
import com.codeanywhere.lessalc.apiempresa.exception.NomeNotFound;
import com.codeanywhere.lessalc.apiempresa.mapper.EmpresaMapper;
import com.codeanywhere.lessalc.apiempresa.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmpresaService {

    private EmpresaRepository empresaRepository;

    private EmpresaMapper empresaMapper;

    public MessageResponseDTO createEmpresa(EmpresaDTO empresaDTO) {
        Empresa empresaToSave = empresaMapper.toModel(empresaDTO);

        Empresa savedEmpresa = empresaRepository.save(empresaToSave);

        MessageResponseDTO messageResponseDTO = createMessageResponse("Company soccesfully created with ID: ", savedEmpresa.getId());

        return messageResponseDTO;
    }


    public List<EmpresaDTO> listAll() {
        List<Empresa> listEmpresas = empresaRepository.findAll();
        return listEmpresas.stream()
                .map(empresaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EmpresaDTO findById(Long id) throws EmpresaNotFoundException {
        Empresa empresaFound = empresaRepository.findById(id)
                .orElseThrow(() -> new EmpresaNotFoundException(id));
        return empresaMapper.toDTO(empresaFound);
    }

    public EmpresaDTO findByName(String nome) throws NomeNotFound {
        Empresa empresaFoundName = empresaRepository.findByNome(nome)
                .orElseThrow(() -> new NomeNotFound(nome));
        return empresaMapper.toDTO(empresaFoundName);
    }

    public MessageResponseDTO updateById(Long id, EmpresaDTO empresaDTO) throws EmpresaNotFoundException {
        empresaRepository.findById(id)
                .orElseThrow(() -> new EmpresaNotFoundException(id));
        Empresa updatedEmpresa = empresaMapper.toModel(empresaDTO);
        Empresa savedEmpresa = empresaRepository.save(updatedEmpresa);

        MessageResponseDTO messageResponse = createMessageResponse("Company succesfully updated with ID: ",savedEmpresa.getId());
        return messageResponse;

    }

    public void deleteById(Long id) throws EmpresaNotFoundException {
        empresaRepository.findById(id)
                .orElseThrow(() -> new EmpresaNotFoundException(id));

        empresaRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id) {
        return MessageResponseDTO
                .builder()
                .message(s + id)
                .build();
    }
}
