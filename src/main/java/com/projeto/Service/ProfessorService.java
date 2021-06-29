package com.projeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.Model.Professor;
import com.projeto.Repository.ProfessorRepository;


@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository professorRepository;
	
	@Autowired
	InicializarDados dados;
	
	public Professor salvarProfessor (Professor professor) {
		if (professor == null) {
			throw new RuntimeException("Um objeto professor é obrigatório");
		}
		if (professor.getMatricula() != null) {
			Professor exists = professorRepository.findByMatricula(professor.getMatricula());
			if (exists != null) {
				throw new RuntimeException("Já existe um professor cadastrado com este código");
			}
		}

		return professorRepository.save(professor);
	}
	
	public List<Professor> listarProfessores(){
		return professorRepository.findAll();
	}
	
	public Professor editarProfessor(Professor professor) {
		if (professor == null) {
			throw new RuntimeException("Um objeto professor é obrigatório");
		}
		Professor exists = professorRepository.findById(professor.getId()).orElse(null);
		if (exists == null) {
			throw new RuntimeException("Não há nenhum professor cadastrado com esta matricula");
		}

		return professorRepository.save(professor);
	}
	
	public Professor consultarPorId(Long id) {
		return professorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Não foi encontrado nenhum professor com o id " + id));
	}

	public void delete (Long id) {
		professorRepository.deleteById(id);
	}
}
