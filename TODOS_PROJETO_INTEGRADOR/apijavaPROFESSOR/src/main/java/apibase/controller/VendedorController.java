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

import apibase.model.Vendedor;
import apibase.repository.VendedorRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class VendedorController {

    @Autowired
    private VendedorRepository vendedorRepository;

    // Listar todos os vendedores
    @GetMapping("/vendedor")
    @ResponseStatus(HttpStatus.OK)
    public List<Vendedor> getAll() {
        return this.vendedorRepository.findAll();
    }

    // Criar um novo vendedor
    @PostMapping("/vendedor")
    @ResponseStatus(HttpStatus.CREATED)
    public Vendedor createVendedor(@RequestBody Vendedor model) {
        return this.vendedorRepository.save(model);
    }

    // Atualizar um vendedor
    @PutMapping("/vendedor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Vendedor updateVendedor(@PathVariable Long id, @RequestBody Vendedor model) {
        return this.vendedorRepository.save(model);
    }

    // Deletar um vendedor
    @DeleteMapping("/vendedor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendedor(@PathVariable Long id) {
        this.vendedorRepository.deleteById(id);
    }

    // Buscar um vendedor por ID
    @GetMapping("/vendedor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Vendedor getById(@PathVariable Long id) {
        return this.vendedorRepository.findById(id).orElse(null);
    }
}