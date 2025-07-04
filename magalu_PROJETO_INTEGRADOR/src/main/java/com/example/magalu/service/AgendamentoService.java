package com.example.magalu.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.magalu.dto.AgendamentoRequestDTO;
import com.example.magalu.dto.AgendamentoResponseDTO;
import com.example.magalu.enums.Statusagendamento;
import com.example.magalu.model.Agendamento;
import com.example.magalu.repository.AgendamentoRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    // Request_NOME_DO_OBJETO_DTO = Dados de entrada da api 
    // Response = Dados de saída da api
    // Service = Lógica de negócio
    // Repository = Acesso aos dados
    // Model = Entidade do banco de dados
    // DTO = Data Transfer Object
    // Enums = Enumerações
    // Exception = Exceções
    // Controller = Endpoint da api
    public AgendamentoResponseDTO agendar(AgendamentoRequestDTO agendamentoRequestDTO) {
        Agendamento agendamento = agendamentoRepository.save(Agendamento.builder()
            .destinatario(agendamentoRequestDTO.destinatario())
            .mensagem(agendamentoRequestDTO.mensagem())
            .tipocomunicacao(agendamentoRequestDTO.tipocomunicacao())
            .datahoraenvio(agendamentoRequestDTO.datahoraenvio())
            .status(Statusagendamento.AGENDADO)
            .criadoem(LocalDateTime.now())
            .build());

            return toResponse(agendamentoRepository.save(agendamento));
    }

    public AgendamentoResponseDTO buscarPorId(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado"));
        return toResponse(agendamento);
    }

    public void remover(Long id) {
        if(!agendamentoRepository.existsById(id)) {
            throw new EntityNotFoundException("Agendamento não encontrado");
        }
        agendamentoRepository.deleteById(id);
    }

    public AgendamentoResponseDTO toResponse(Agendamento agendamento) {
        return new AgendamentoResponseDTO(
            agendamento.getId(),
            agendamento.getDestinatario(),
            agendamento.getMensagem(),
            agendamento.getTipocomunicacao(),
            agendamento.getDatahoraenvio(),
            agendamento.getStatus(),
            agendamento.getCriadoem()
        );
    }

    public java.util.List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll(); 
    }    

}
