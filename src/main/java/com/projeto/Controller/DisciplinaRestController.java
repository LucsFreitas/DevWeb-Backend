package com.projeto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projeto.Model.Disciplina;
import com.projeto.Service.DisciplinaService;

@CrossOrigin
@RestController
@RequestMapping("/disciplina")
public class DisciplinaRestController {

	@Autowired
	DisciplinaService disciplinaService;
	
	@PostMapping
	public ResponseEntity<Disciplina> criarDisciplina(@RequestBody Disciplina disciplina) {
		
		Disciplina d = disciplinaService.salvarDisciplina(disciplina);
		
		if (d != null) {
			return new ResponseEntity<> (d, HttpStatus.OK);
		}
		return new ResponseEntity<> (HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping
	public ResponseEntity<List<Disciplina>> listarDisciplina(){
		
		return new ResponseEntity<> (disciplinaService.listarDisciplinas(), HttpStatus.OK);
	}

	
	@PutMapping
	public ResponseEntity<Disciplina> editarDisciplina(@RequestBody Disciplina disciplina){
		
		Disciplina d = disciplinaService.editarDisciplina(disciplina);
		
		if (d != null) {
			return new ResponseEntity<> (d, HttpStatus.OK);
		}
		return new ResponseEntity<> (HttpStatus.NOT_ACCEPTABLE);
		
	}
}
