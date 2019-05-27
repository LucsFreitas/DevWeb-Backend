package com.projeto.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tb_disciplina")
public class Disciplina {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	@NotBlank
	@Column(unique=true)
	private String codigo;
	
	@NotBlank
	private String descricao;
	
	private Long qtdCreditos;
	
	public Disciplina() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
