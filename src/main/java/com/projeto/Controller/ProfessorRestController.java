package com.projeto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projeto.Model.Professor;
import com.projeto.Service.ProfessorService;

@CrossOrigin
@RestController
@RequestMapping("/professor")
public class ProfessorRestController {

	@Autowired
	ProfessorService professorService;
	
	@PostMapping
	public ResponseEntity<Professor> criarProfessor(@RequestBody Professor professor) {
		
		Professor p = professorService.salvarProfessor(professor);
		
		if (p != null) {
			return new ResponseEntity<Professor> (p, HttpStatus.OK);
		}
		
		return new ResponseEntity<> (HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping
	public ResponseEntity<List<Professor>> listarProfessor(){
		
		return new ResponseEntity<> (professorService.listarProfessores(), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Professor> editarProfessor(@RequestBody Professor professor){
		
		Professor p = professorService.editarProfessor(professor);
		
		if (p != null) {
			return new ResponseEntity<Professor> (p, HttpStatus.OK);
		}
		
		return new ResponseEntity<> (HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Professor> consultarPorId(@PathVariable String id){
		
		Professor p = professorService.consultarPorId(id);
		
		if (p != null) {
			return new ResponseEntity<> (p, HttpStatus.OK);
		}
		
		return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
	}
}
