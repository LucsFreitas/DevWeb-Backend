package com.projeto.Controller;

import java.util.List;

import io.swagger.annotations.ApiOperation;
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
	@ApiOperation(value = "Cria um novo registro de disciplina")
	public ResponseEntity<Disciplina> criarDisciplina(@RequestBody Disciplina disciplina) {
		return new ResponseEntity<> (disciplinaService.salvarDisciplina(disciplina), HttpStatus.CREATED);
	}

	@GetMapping
	@ApiOperation(value = "Retorna a lista de disciplinas cadastradas")
	public ResponseEntity<List<Disciplina>> listarDisciplina(){
		return new ResponseEntity<> (disciplinaService.listarDisciplinas(), HttpStatus.OK);
	}

	@PutMapping
	@ApiOperation(value = "Atualiza um registro de disciplina")
	public ResponseEntity<Disciplina> editarDisciplina(@RequestBody Disciplina disciplina){
		return new ResponseEntity<> (disciplinaService.editarDisciplina(disciplina), HttpStatus.OK);
	}
}
