package com.educacionit.persona.api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.educacionit.student.api.model.Persona;

@Repository
public interface PersonaDao extends CrudRepository<Persona, Integer> {
	
	@Override
    List<Persona> findAll();
}
