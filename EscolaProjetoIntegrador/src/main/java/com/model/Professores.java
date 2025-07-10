package com.model;
 import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "professor")
@Getter
@Setter
public class Professores {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
 
     private String nome;
    private String cidade;
    private String estado;
    private String telefone;
    private String email;
    private String dataContratacao;
    private String areaAtuacao;
    private String status; //Ativo, Inativo, Aposentado

 
 
 
    public long getId() {
        return this.id != null ? this.id : 0L;
    }
}



