package apibase.model;
    
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Produto")
public class Produto {
    
    private Long id;
    private String descricao;
    private Double preco;
    private Double precopromocional;
    private String categoria; // Eletrônicos, Roupas, Livros, etc.
    private int estoque;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return this.id != null ? this.id : 0L;
    }
}