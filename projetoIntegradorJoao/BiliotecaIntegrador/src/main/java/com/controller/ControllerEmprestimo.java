package com.controller;

import com.exception.ResourceNotFoundException;

import com.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.model.Emprestimo;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/emprestimos")
public class ControllerEmprestimo {

    @Autowired
    private EmprestimoRepository repository;

    @PostMapping()
	@ResponseStatus(HttpStatus.CREATED)	
	public Emprestimo inserirEmprestimo(@RequestBody Emprestimo model){			
		return this.repository.save(model);
	}
    
    @GetMapping
    public List<Emprestimo> listarEmprestimos() {
        return repository.findAll();
    }

	// Atualizar
    @PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Emprestimo updateEmprestimo(@PathVariable Long id, @RequestBody Emprestimo model)
		throws ResourceNotFoundException {
		// Verifica se o cadastro existe
		Emprestimo cadastro = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException
						("Cadastro não encontrado para o ID : " + id));
        
		// Atualiza os campos do cadastro
		if (model.getLivro_id() != null) {
			cadastro.setLivro_id(model.getLivro_id());
		}		
		if (model.getUsuario_id() != null) {
			cadastro.setUsuario_id(model.getUsuario_id());
		}

		if (model.getDataEmprestimo() != null) {
			cadastro.setDataEmprestimo(model.getDataEmprestimo());
		}

		if (model.getDataDevolucaoPrevista() != null) {
			cadastro.setDataDevolucaoPrevista(model.getDataDevolucaoPrevista());
		}

		if (model.getDataDevolucaoReal() != null) {
			cadastro.setDataDevolucaoReal(model.getDataDevolucaoReal());
		}

		if (model.getLivro_id() != null) {
			cadastro.setLivro_id(model.getLivro_id());
		}

		if (model.getMultaAplicada() != 0) {
			cadastro.setMultaAplicada(model.getMultaAplicada());
		}
	
		if (model.getStatus() != null) {
			cadastro.setStatus(model.getStatus());
		}		

		return this.repository.save(cadastro);
	}
}
