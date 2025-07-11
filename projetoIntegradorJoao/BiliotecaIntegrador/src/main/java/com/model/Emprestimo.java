package com.model;
 import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "emprestimo")
@Getter
@Setter
public class Emprestimo {
    

    /**
     * #### 3. Cadastro de Empréstimos
- **ID do Empréstimo**: Código único do empréstimo
- **Usuário**: Referência ao usuário que fez o empréstimo
- **Livro**: Referência ao livro emprestado
- **Data de Empréstimo**: Data em que o livro foi retirado
- **Data de Devolução Prevista**: Data limite para devolução
- **Data de Devolução Real**: Data em que foi realmente devolvido
- **Multa Aplicada se atrasar**: Valor da multa (se houver atraso)
- **Status**: Em Andamento, Devolvido, Atrasado

     */
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
 
    private Long usuario_id;

    private Long livro_id;
    private String dataEmprestimo;
    private String dataDevolucaoPrevista;
    private String dataDevolucaoReal;
    private double multaAplicada; // Valor da multa se houver atraso
    private String status; // Em Andamento, Devolvido, Atrasado
    
    
    public long getId() {
        return this.id != null ? this.id : 0L;
    }
}



