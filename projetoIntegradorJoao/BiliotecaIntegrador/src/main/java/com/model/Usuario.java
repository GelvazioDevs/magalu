package com.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario {
    /** 
#### 2. Cadastro de Usuários
 - id - 
- **Nome Completo**: Nome e sobrenome
- **Email**: Endereço de email único
- **Livros emprestados : lista de id de livro
- **Limite de Empréstimos**: Quantidade máxima de livros que pode emprestar
- **Status**: Ativo, Inativo, Bloqueado
     */
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String livros; // lista de livros emprestados (IDs separados por vírgula)
    private int limiteEmprestimos; // Quantidade máxima de livros que pode emprestar
    private String status;
    private String senha;

    public long getId() {
        return this.id != null ? this.id : 0L;
    }
}
