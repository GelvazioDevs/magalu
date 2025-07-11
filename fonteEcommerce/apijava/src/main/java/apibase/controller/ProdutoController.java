package apibase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import apibase.model.Produto;
import apibase.repository.ProdutoRepository;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    // Listar todos os produtos
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> getAll() {
        return this.repository.findAll();
    }

    // Criar um novo produto
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto createProduto(@RequestBody Produto model) {
        return this.repository.save(model);
    }

    // Atualizar um produto
    @PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Produto updateCadastro(@PathVariable Long id, @RequestBody Produto model)
	throws ResourceNotFoundException {
		// Verifica se o cadastro existe
		Produto cadastro = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException
						("Cadastro não encontrado para o ID : " + id));
		
        if (model.getDescricao() != null) { 
            cadastro.setDescricao(model.getDescricao());
        }
        if (model.getPreco() != null) { 
            cadastro.setPreco(model.getPreco());
        }
        if (model.getEstoque() != 0) { 
            cadastro.setEstoque(model.getEstoque());
        }

		return this.repository.save(cadastro);
	}

    // Deletar um produto
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable Long id) {
        this.repository.deleteById(id);
    }

    // Buscar um produto por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto getById(@PathVariable Long id) {
        return this.repository.findById(id).orElse(null);
    }    
}
