package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "livro")
@Getter
@Setter
public class Livro {

    /**
     *  - id - 
#### 1. Cadastro de Livros
- id - Livro
- **Título**: Nome do livro

- **Autor**: Nome completo do autor

- **Editora**: Nome da editora

- **Ano de Publicação**: Ano em que o livro foi publicado

- **Gênero/Categoria**: Ficção, Não-ficção, Técnico, Acadêmico, etc.

- **Idioma**: Português, Inglês, Espanhol, etc.

- **Preço**: Valor de aquisição

- **Status**: Disponível, Emprestado, Em Manutenção, Perdido
     * 
     */
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String editora;
    private int anoPublicacao;
    private String genero;  
    private String idioma;
    private double preco;
    private String status; // Disponível, Emprestado, Em Manutenção, Perdido

    public long getId() {
        return this.id != null ? this.id : 0L;
    }
}