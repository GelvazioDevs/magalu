package model;

import java.util.Vector;

/**
 *
 * @author Yasmim
 */
public class ModelTarefa {
// colocar os campos da tabela
    //CREATE TABLE public.tbtarefa (
//	codigo serial4 NOT NULL,
//	descricao varchar(300) NULL,
//	procodigo int NOT NULL,
//	-- quando esta default, ele pega o valor padrao quando nao e passado
//	status smallint not null default 1,	--(1 - FAZER, 2 - FAZENDO, 3 - FINALIZADO)
//	CONSTRAINT pk_tbtarefa PRIMARY KEY (codigo, procodigo)
//);
        private int codigo;
        private String descricao;
        private int procodigo;
        private int status;
        
//        private Vector<String> afazer;

    public ModelTarefa(int codigo, String descricao, int procodigo, int status) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.procodigo = procodigo;
        this.status = status;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getProcodigo() {
        return procodigo;
    }

    public void setProcodigo(int procodigo) {
        this.procodigo = procodigo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

