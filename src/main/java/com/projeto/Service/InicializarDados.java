package com.projeto.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.Model.Disciplina;
import com.projeto.Model.Professor;

@Service
public class InicializarDados {
	
	@Autowired
	ProfessorService professorService;
	
	@Autowired
	DisciplinaService disciplinaService;
	
	public void inicializar () {
		ArrayList<Professor> prof = new ArrayList<> ();
		
		Professor p1 = new Professor();
		p1.setMatricula("54625");
		p1.setNome("Fernando Wanderley");
		p1.setEmail("fernando@unicap.br");
		prof.add(p1);
		
		Professor p2 = new Professor();
		p2.setMatricula("325415");
		p2.setNome("Fernando Bertino");
		p2.setEmail("fernando.bertino@unicap.br");
		prof.add(p2);
		
		Professor p3 = new Professor();
		p3.setMatricula("546134");
		p3.setNome("Sérgio Murilo");
		p3.setEmail("sergio.murilo@unicap.br");
		prof.add(p3);
		
		Professor p4 = new Professor();
		p4.setMatricula("324857");
		p4.setNome("Antônio Cavalcanti");
		p4.setEmail("tj@unicap.br");
		prof.add(p4);
		
		ArrayList<Disciplina> disc = new ArrayList<> ();
		
		Disciplina d1 = new Disciplina();
		d1.setCodigo("INF1904");
		d1.setDescricao("Desenvolvimento WEB");
		d1.setQtdCreditos(6L);
		disc.add(d1);
		
		Disciplina d2 = new Disciplina();
		d2.setCodigo("INF3512");
		d2.setDescricao("Estrutura de Dados");
		d2.setQtdCreditos(4L);
		disc.add(d2);
		
		Disciplina d3 = new Disciplina();
		d3.setCodigo("INF2146");
		d3.setDescricao("Compiladores");
		d3.setQtdCreditos(4L);
		disc.add(d3);
		
		Disciplina d4 = new Disciplina();
		d4.setCodigo("INF2004");
		d4.setDescricao("Introdução a Programação");
		d4.setQtdCreditos(4L);
		disc.add(d4);
		
		
		for (Professor p : prof) {
			professorService.salvarProfessor(p);
		}
		
		for (Disciplina d : disc) {
			disciplinaService.salvarDisciplina(d);
		}
	}
}
