package com.example.pessoaslivroscarros.repository;

import com.example.pessoaslivroscarros.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
