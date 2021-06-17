package com.codeanywhere.lessalc.apiempresa.repository;

import com.codeanywhere.lessalc.apiempresa.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query("SELECT empresa "+
            "FROM Empresa empresa "+
            "WHERE empresa.nome = :nome")
    Optional<Empresa> findByNome(String nome);
}
