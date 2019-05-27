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
		
//		if (professor != null) {
//			Professor professorExist = professorRepository.findById(professor.getId()).orElse(null);
//			
//			if(professorExist!=null) {
//				return null;
//			}
//		}
		
		return professorRepository.save(professor);
	}
	
	public List<Professor> listarProfessores(){
		
		List<Professor> lista = professorRepository.findAll();
		
//		if (lista.size() == 0) {
//			dados.inicializar();
			lista = professorRepository.findAll();
//		}
		
		return lista;
	}
	
	public Professor editarProfessor(Professor professor) {
		
		if (professor != null && professor.getId() != null) {
			
			Professor professorExists = professorRepository.findById(professor.getId()).orElse(null);
			
			if(professorExists != null) {
				return professorRepository.save(professor);
			}
		}
		
		return null;
	}
	
	public Professor consultarPorId(Long id) {
		return professorRepository.findById(id).orElse(null);
	}
}
