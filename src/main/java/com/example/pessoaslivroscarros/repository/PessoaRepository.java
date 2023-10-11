package com.example.pessoaslivroscarros.repository;

import com.example.pessoaslivroscarros.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
