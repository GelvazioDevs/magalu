package apibase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Usuario", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
public class Usuario {

    private Long id;
    private String nome;
    private String email;
    private String senha;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
      return this.id != null ? this.id : 0L;
    }

    public void setId(Long id) {
        this.id = id;
    }
}