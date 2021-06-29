package com.projeto.Controller;

import java.util.List;

import io.swagger.annotations.ApiOperation;
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
	@ApiOperation(value = "Cria um novo registro de professor")
	public ResponseEntity<Professor> criarProfessor(@RequestBody Professor professor) {
		return new ResponseEntity<Professor> (professorService.salvarProfessor(professor), HttpStatus.CREATED);
	}
	
	@GetMapping
	@ApiOperation(value = "Retorna a lista de disciplinas professor")
	public ResponseEntity<List<Professor>> listarProfessor(){
		return new ResponseEntity<> (professorService.listarProfessores(), HttpStatus.OK);
	}

	@PutMapping
	@ApiOperation(value = "Atualiza um registro de professor")
	public ResponseEntity<Professor> editarProfessor(@RequestBody Professor professor){
		return new ResponseEntity<Professor> (professorService.editarProfessor(professor), HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	@ApiOperation(value = "Retorna um professor que corresponda ao id informado")
	public ResponseEntity<Professor> consultarPorId(@PathVariable Long id){
		return new ResponseEntity<> (professorService.consultarPorId(id), HttpStatus.OK);
	}

	@DeleteMapping(path="/{id}")
	@ApiOperation(value = "Deleta um professor que corresponda ao id informado")
	public ResponseEntity<HttpStatus> deletarProfessor(@PathVariable Long id){
		professorService.delete(id);
		return new ResponseEntity<> (HttpStatus.OK);
	}
}
