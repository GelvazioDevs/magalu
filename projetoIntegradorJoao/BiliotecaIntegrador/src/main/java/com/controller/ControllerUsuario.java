package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exception.ResourceNotFoundException;
import com.model.Login;
import com.model.Usuario;
import com.repository.UsuarioRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/v1/usuarios")
public class ControllerUsuario {
    
    @Autowired 
    private UsuarioRepository repository;

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> getAll() {
		return this.repository.findAll();
	}

	// Inserir
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)	
	public Usuario createCadastro(@RequestBody Usuario model){			
		return this.repository.save(model);
	}

    // Listar
	@GetMapping("/{usuario_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Usuario> getCadastroById(@PathVariable(value = "usuario_id") Long cadastroId)
		throws ResourceNotFoundException {
			Usuario cadastro = repository.findById(cadastroId)
			.orElseThrow(() -> new ResourceNotFoundException(
					"Usuario não encontrado para o ID: " + cadastroId));

		return ResponseEntity.ok().body(cadastro);
	}

	// Deletar
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable Long id) {
        this.repository.deleteById(id);
    }

	// Login
	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Login> login(@Validated @RequestBody Login cadastro) throws ResourceNotFoundException {
		String email = cadastro.getEmail();
		String senha = cadastro.getSenha();
		Usuario usuario = this.repository.findUsuarioByEmailAndSenha(email, senha)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario ou senha inválido!"));
		cadastro.setUsuario(usuario);
		
		cadastro.setData("DATA ATUAL");

		return ResponseEntity.ok().body(cadastro);
	}
}