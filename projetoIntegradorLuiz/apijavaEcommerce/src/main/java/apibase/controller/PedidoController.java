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
import apibase.model.Pedido;
import apibase.repository.PedidoRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    // Listar todos os registros
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Pedido> getAll() {
        return this.repository.findAll();
    }

    // Criar um novo registro
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido createPedido(@RequestBody Pedido model) {
        return this.repository.save(model);
    }

    // Atualizar um registro
    @PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Pedido updatePedido(@PathVariable Long id, @RequestBody Pedido model)
	throws ResourceNotFoundException {
		// Verifica se o cadastro existe
		Pedido pedido = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException
						("Cadastro não encontrado para o ID : " + id));
    
        // Atualiza os campos do pedido
        if (model.getUsuario() != null) {
            pedido.setUsuario(model.getUsuario());
        }
        if (model.getDataPedido() != null) {
            pedido.setDataPedido(model.getDataPedido());
        }

        if (model.getValorFrete() != null) {
            pedido.setValorFrete(model.getValorFrete());
        }
        if (model.getValorDescontos() != null) {
            pedido.setValorDescontos(model.getValorDescontos());
        }
        if (model.getMetodoPagamento() != null) {
            pedido.setMetodoPagamento(model.getMetodoPagamento());
        }
        if (model.getStatusPagamento() != null) {
            pedido.setStatusPagamento(model.getStatusPagamento());
        }
        if (model.getEnderecoEntrega() != null) {
            pedido.setEnderecoEntrega(model.getEnderecoEntrega());
        }
        if (model.getCodigoRastreamento() != null) {
            pedido.setCodigoRastreamento(model.getCodigoRastreamento());
        }
        if (model.getDataEntregaPrevista() != null) {
            pedido.setDataEntregaPrevista(model.getDataEntregaPrevista());
        }
        if (model.getDataEntregaReal() != null) {
            pedido.setDataEntregaReal(model.getDataEntregaReal());
        }

		return this.repository.save(pedido);
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
    public Pedido getById(@PathVariable Long id) {
        return this.repository.findById(id).orElse(null);
    }    
}
