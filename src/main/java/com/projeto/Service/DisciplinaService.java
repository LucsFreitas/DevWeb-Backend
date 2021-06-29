package com.projeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.Model.Disciplina;
import com.projeto.Repository.DisciplinaRepository;


@Service
public class DisciplinaService {

	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	public Disciplina salvarDisciplina (Disciplina disciplina) {
		if (disciplina == null) {
			throw new RuntimeException("Um objeto disciplina é obrigatório");
		}
		if (disciplina.getCodigo() != null) {
			Disciplina exists = disciplinaRepository.findByCodigo(disciplina.getCodigo());
			if (exists != null) {
				throw new RuntimeException("Já existe uma disciplina cadastrada com este código");
			}
		}

		return disciplinaRepository.save(disciplina);
	}
	
	public List<Disciplina> listarDisciplinas(){
		return disciplinaRepository.findAll();
	}
	
	public Disciplina editarDisciplina(Disciplina disciplina) {
		if (disciplina == null) {
			throw new RuntimeException("Um objeto disciplina é obrigatório");
		}
		Disciplina disciplinaExists = disciplinaRepository.findById(disciplina.getId()).orElse(null);
		if (disciplinaExists == null) {
			throw new RuntimeException("Não há nenhuma disciplina cadastrada com este código");
		}

		return disciplinaRepository.save(disciplina);
	}
}
