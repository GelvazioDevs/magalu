package com.example.magalu.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.magalu.dto.AgendamentoRequestDTO;
import com.example.magalu.dto.AgendamentoResponseDTO;
import com.example.magalu.model.Agendamento;
import com.example.magalu.service.AgendamentoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    // Controller usa o Service e o Service usa o Repository
    private final AgendamentoService service;

    // Listar todos os agendamentos
    @GetMapping
    public ResponseEntity<List<Agendamento>> listarTodos() {
        List<Agendamento> responseDTO = service.listarTodos();
        return ResponseEntity.ok(responseDTO);
    }

    // @PostMapping("/agendar")
    // public ResponseEntity<AgendamentoResponseDTO> agendar(AgendamentoRequestDTO requestDTO) {
    //     AgendamentoResponseDTO responseDTO = service.agendar(requestDTO);        
    //     return ResponseEntity.ok(responseDTO);
    // }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponseDTO> buscarPorId(@PathVariable Long id) {
        AgendamentoResponseDTO responseDTO = service.buscarPorId(id);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<AgendamentoResponseDTO> agendar(@RequestBody AgendamentoRequestDTO requestDTO) {
        AgendamentoResponseDTO responseDTO = service.agendar(requestDTO);        
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

}
