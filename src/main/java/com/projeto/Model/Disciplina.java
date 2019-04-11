package com.projeto.Model;

import javax.persistence.*;

@Entity
@Table(name="tb_disciplina")
public class Disciplina {

	@Id
	private String codigo;
	
	private String descricao;
	
	private Long qtdCreditos;
	
	public Disciplina() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getQtdCreditos() {
		return qtdCreditos;
	}

	public void setQtdCreditos(Long qtdCreditos) {
		this.qtdCreditos = qtdCreditos;
	}
}
