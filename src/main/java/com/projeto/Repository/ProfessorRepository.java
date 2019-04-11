package com.projeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.Model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, String>{

}
