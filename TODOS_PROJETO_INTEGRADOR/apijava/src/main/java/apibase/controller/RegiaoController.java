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

import apibase.model.Regiao;
import apibase.repository.RegiaoRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class RegiaoController {

    @Autowired
    private RegiaoRepository regiaoRepository;

    // Listar todas as regiões
    @GetMapping("/regiao")
    @ResponseStatus(HttpStatus.OK)
    public List<Regiao> getAll() {
        return this.regiaoRepository.findAll();
    }

    // Criar uma nova região
    @PostMapping("/regiao")
    @ResponseStatus(HttpStatus.CREATED)
    public Regiao createRegiao(@RequestBody Regiao model) {
        return this.regiaoRepository.save(model);
    }

    // Atualizar uma região
    @PutMapping("/regiao/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Regiao updateRegiao(@PathVariable Long id, @RequestBody Regiao model) {
        return this.regiaoRepository.save(model);
    }

    // Deletar uma região
    @DeleteMapping("/regiao/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRegiao(@PathVariable Long id) {
        this.regiaoRepository.deleteById(id);
    }

    // Buscar uma região por ID
    @GetMapping("/regiao/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Regiao getById(@PathVariable Long id) {
        return this.regiaoRepository.findById(id).orElse(null);
    }

    // Buscar uma região por descrição
    @GetMapping("/regiao/descricao/{descricao}")
    @ResponseStatus(HttpStatus.OK)
    public List<Regiao> getByDescricao(@PathVariable String descricao) {
        return this.regiaoRepository.findByDescricao(descricao);
    }
    
}