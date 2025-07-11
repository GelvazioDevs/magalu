package apibase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import apibase.exception.ResourceNotFoundException;
import apibase.model.Login;
import apibase.model.Usuario;
import apibase.repository.UsuarioRepository;
@CrossOrigin(origins = "*")


@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

	@Autowired // busca dados do banco de dados e altera
	private UsuarioRepository repository;

	// Listar todos 
	@GetMapping("")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> getAll() {
		return this.repository.findAll();
	}
	
	// Inserir
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)	
	public Usuario createCadastro(@RequestBody Usuario modelUsuario)
		throws ResourceNotFoundException {			
		// Verifica se o email já existe
		if (repository.existsByEmail(modelUsuario.getEmail())) {
			throw new ResourceNotFoundException("E-mail já cadastrado: " + modelUsuario.getEmail());
		}
		return this.repository.save(modelUsuario);
	}

    // Listar um usuario
	@GetMapping("/{usuario_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Usuario> getCadastroById(@PathVariable(value = "usuario_id") Long cadastroId)
		throws ResourceNotFoundException {
			//  select * from usuario where id = cadastroId
			Usuario cadastro = repository.findById(cadastroId)
			.orElseThrow(() -> new ResourceNotFoundException(
					"Registro não encontrado para o ID: " + cadastroId));

		return ResponseEntity.ok().body(cadastro);
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


	// Atualizar um usuario
    @PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Usuario updateCadastro(@PathVariable Long id, @RequestBody Usuario model)
		throws ResourceNotFoundException {
		// Verifica se o cadastro existe
		Usuario cadastro = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException
						("Cadastro não encontrado para o ID : " + id));
        
		if (model.getNome() != null) {
			cadastro.setNome(model.getNome());
		}

		if (model.getEmail() != null) {
			cadastro.setEmail(model.getEmail());
		}
		
		if (model.getSenha() != null) {
			cadastro.setSenha(model.getSenha());
		}

		return this.repository.save(cadastro);
	}

    // Deletar
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable Long id) {
        this.repository.deleteById(id);
    }

}