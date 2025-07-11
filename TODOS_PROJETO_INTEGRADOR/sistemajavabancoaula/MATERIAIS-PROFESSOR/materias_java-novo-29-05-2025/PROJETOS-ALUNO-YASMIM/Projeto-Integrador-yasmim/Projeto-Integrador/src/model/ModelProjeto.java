/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author yasmi
 */
public class ModelProjeto {
//	Status: (1 - NAO INICIADO, 2 - INICIADO, 3 - CONCLUIDO)
        private int procodigo;
        private String pronome;
        private Date prodataprazo;
        private Date prodataentrega;
        private String descricao;
        private int prostatus;
        

    public ModelProjeto(int procodigo, String pronome, Date prodataprazo, Date prodataentrega, String descricao, int prostatus) {
        this.procodigo = procodigo;
        this.pronome = pronome;
        this.prodataprazo = prodataprazo;
        this.prodataentrega = prodataentrega;
        this.descricao = descricao;
        this.prostatus = prostatus;
    }

    public ModelProjeto() {
        
    }

    public int getProcodigo() {
        return procodigo;
    }

    public void setProcodigo(int procodigo) {
        this.procodigo = procodigo;
    }

    public String getPronome() {
        return pronome;
    }

    public void setPronome(String pronome) {
        this.pronome = pronome;
    }

    public Date getProdataprazo() {
        return prodataprazo;
    }

    public void setProdataprazo(Date prodataprazo) {
        this.prodataprazo = prodataprazo;
    }

    public Date getProdataentrega() {
        return prodataentrega;
    }

    public void setProdataentrega(Date prodataentrega) {
        this.prodataentrega = prodataentrega;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getProstatus() {
        return prostatus;
    }

    public void setProstatus(int prostatus) {
        this.prostatus = prostatus;
    }
    
}
