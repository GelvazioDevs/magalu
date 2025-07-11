package com.example.magalu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.magalu.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findAll();

}
