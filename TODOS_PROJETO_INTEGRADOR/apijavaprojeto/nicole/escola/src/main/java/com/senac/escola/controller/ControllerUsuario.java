package com.senac.escola.controller;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.senac.escola.model.Usuario;
import com.senac.escola.repository.UsuarioRepository;
import com.senac.escola.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1")
public class ControllerUsuario {
    
    @Autowired 
    private UsuarioRepository usuarioRepository;

    // Listar todos os usuarios
	@GetMapping("/usuario")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> getAll() {
		return this.usuarioRepository.findAll();
	}

	// Inserir
	@PostMapping("/usuario")
	@ResponseStatus(HttpStatus.CREATED)	
	public Usuario createCadastro(@RequestBody Usuario modelUsuario){			
		// // Verifica se o email já existe
		// if (usuarioRepository.existsByEmail(modelUsuario.getEmail())) {
		// 	throw new ResourceNotFoundException("E-mail já cadastrado: " + modelUsuario.getEmail());
		// }
		return this.usuarioRepository.save(modelUsuario);
	}

    // Listar um usuario
	@GetMapping("/usuario/{usuario_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Usuario> getCadastroById(@PathVariable(value = "usuario_id") Long cadastroId)
		throws ResourceNotFoundException {
			//  select * from usuario where id = cadastroId
			Usuario cadastro = usuarioRepository.findById(cadastroId)
			.orElseThrow(() -> new ResourceNotFoundException(
					"Usuario não encontrado para o ID: " + cadastroId));

		return ResponseEntity.ok().body(cadastro);
	}

	// Login
	// @PostMapping("/login")
	// @ResponseStatus(HttpStatus.OK)
	// public ResponseEntity<Login> login(@Validated @RequestBody Login cadastro) throws ResourceNotFoundException {

	// 	String email = cadastro.getEmail();
	// 	String senha = cadastro.getSenha();

	// 	Usuario usuario = this.usuarioRepository.findUsuarioByEmailAndSenha(email, senha)
	// 			.orElseThrow(() -> new ResourceNotFoundException("Usuario ou senha inválido!"));

	// 	cadastro.setUsuario(usuario);
	// 	cadastro.setData("DATA ATUAL");
	// 	return ResponseEntity.ok().body(cadastro);
	// }


	// // Atualizar um usuario
    // @PutMapping("/usuario/{id}")
	// @ResponseStatus(HttpStatus.OK)
	// public Usuario updateCadastro(@PathVariable Long id, @RequestBody Usuario model)
	// 	throws ResourceNotFoundException {
	// 	// Verifica se o cadastro existe
	// 	Usuario cadastro = usuarioRepository.findById(id)
	// 			.orElseThrow(() -> new ResourceNotFoundException
	// 					("Cadastro não encontrado para o ID : " + id));
        
	// 	if (model.getNome() != null) {
	// 		cadastro.setNome(model.getNome());
	// 	}

	// 	if (model.getEmail() != null) {
	// 		cadastro.setEmail(model.getEmail());
	// 	}
		
	// 	if (model.getSenha() != null) {
	// 		cadastro.setSenha(model.getSenha());
	// 	}

	// 	return this.usuarioRepository.save(cadastro);
	// }
}