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
		
//		if (disciplina != null && disciplina.getCodigo() != null) {
//			Disciplina disciplinaExist = disciplinaRepository.findById(disciplina.getCodigo()).orElse(null);
//			
//			if(disciplinaExist!=null) {
//				return null;
//			}
//		}
//		
		return disciplinaRepository.save(disciplina);
	}
	
	public List<Disciplina> listarDisciplinas(){
		
		return disciplinaRepository.findAll();
	}
	
	public Disciplina editarDisciplina(Disciplina disciplina) {
		
		if (disciplina != null && disciplina.getCodigo() != null) {
			
			Disciplina disciplinaExists = disciplinaRepository.findById(disciplina.getId()).orElse(null);
			
			if(disciplinaExists != null) {
				return disciplinaRepository.save(disciplina);
			}
		}
		
		return null;
	}
}
