package apibase.model;
    
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vendedor")
public class Vendedor {
    
    private Long id;
    private String nome;
    private double taxacomissao;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return this.id != null ? this.id : 0L;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTaxacomissao() {
        return taxacomissao;
    }

    public void setTaxacomissao(double taxacomissao) {
        this.taxacomissao = taxacomissao;
    }

    
}
