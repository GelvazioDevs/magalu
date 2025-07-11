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
import apibase.model.ItemPedido;
import apibase.repository.ItemPedidoRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/itempedidos")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoRepository repository;

    // Listar todos os registros
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemPedido> getAll() {
        return this.repository.findAll();
    }

    // Criar um novo registro
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemPedido createItemPedido(@RequestBody ItemPedido model) {
        return this.repository.save(model);
    }

    // Atualizar um registro
    @PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ItemPedido updateItemPedido(@PathVariable Long id, @RequestBody ItemPedido model)
	throws ResourceNotFoundException {
		// Verifica se o cadastro existe
		ItemPedido itemPedido = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException
						("ItemPedido não encontrado para o ID : " + id));
    
        
        // Atualiza os campos do pedido
        if (model.getPedido() != null) {
            itemPedido.setPedido(model.getPedido());
        }
        if (model.getProduto() != null) {
            itemPedido.setProduto(model.getProduto());
        }
        if (model.getQuantidade() != null) {
            itemPedido.setQuantidade(model.getQuantidade());
        }
        if (model.getPrecoUnitario() != null) {
            itemPedido.setPrecoUnitario(model.getPrecoUnitario());
        }
        if (model.getPrecoTotal() != null) {
            itemPedido.setPrecoTotal(model.getPrecoTotal());
        }
        if (model.getDescontoAplicado() != null) {
            itemPedido.setDescontoAplicado(model.getDescontoAplicado());
        }

		return this.repository.save(itemPedido);
	}

    // Deletar um registro
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable Long id) {
        this.repository.deleteById(id);
    }

    // Buscar um registro por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ItemPedido getById(@PathVariable Long id) {
        return this.repository.findById(id).orElse(null);
    }    
}
