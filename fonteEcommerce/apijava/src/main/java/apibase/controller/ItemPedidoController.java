package apibase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import apibase.exception.ResourceNotFoundException;
import apibase.model.ItemPedido;
import apibase.repository.ItemPedidoRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/v1/itempedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoRepository repository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ItemPedido criarItemPedido(@RequestBody ItemPedido model) {
        return this.repository.save(model);
    }

    // Listar tudo
    @GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<ItemPedido> getAll() {
		return this.repository.findAll();
	}

    // Listar um item do pedido
	@GetMapping("/{item_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ItemPedido> getCadastroById(@PathVariable(value = "item_id") Long cadastroId)
		throws ResourceNotFoundException {
			//  select * from usuario where id = cadastroId
			ItemPedido cadastro = repository.findById(cadastroId)
			.orElseThrow(() -> new ResourceNotFoundException(
					"Registro não encontrado para o ID: " + cadastroId));

		return ResponseEntity.ok().body(cadastro);
	}


    // Alterar um item do pedido
    // @PutMapping("/{id}")
    // public ItemPedido atualizarItemPedido(@PathVariable Long id, @RequestBody ItemPedido item) {
    //     if (itensPedidoDB.containsKey(id)) {
    //         item.setId(id);
    //         item.setPrecoTotal(
    //             item.getPrecoUnitario()
    //                 .multiply(new java.math.BigDecimal(item.getQuantidade()))
    //                 .subtract(item.getDescontoAplicado())
    //         );
    //         itensPedidoDB.put(id, item);
    //         return item;
    //     }
    //     return null;
    // }

    @DeleteMapping("/{id}")
    public void deletarItemPedido(@PathVariable Long id) {
        repository.deleteById(id);
    }
}