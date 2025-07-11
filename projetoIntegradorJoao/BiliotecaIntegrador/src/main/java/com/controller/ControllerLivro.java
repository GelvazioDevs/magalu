package com.controller;

import java.util.List;
import java.util.Optional;

import com.model.Livro;
import com.repository.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/livros")
public class ControllerLivro {

    @Autowired
    private LivroRepository repository;

    @GetMapping
    public List<Livro> listarLivros() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Livro> buscarLivroPorId(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro) {
        return repository.save(livro);
    }

    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        return repository.findById(id).map(livro -> {
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
            livro.setEditora(livroAtualizado.getEditora());
            return repository.save(livro);
        }).orElseGet(() -> {
            livroAtualizado.setId(id);
            return repository.save(livroAtualizado);
        });
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {
        repository.deleteById(id);
    }
}