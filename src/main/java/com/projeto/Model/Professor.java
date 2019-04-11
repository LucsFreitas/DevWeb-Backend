package com.projeto.Model;

import javax.persistence.*;

@Entity
@Table(name="tb_professor")
public class Professor {
	
	@Id
	private String matricula;
	
	private String nome;
	
	private String email;

	public Professor() {
		super();
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String descricao) {
		this.nome = descricao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
