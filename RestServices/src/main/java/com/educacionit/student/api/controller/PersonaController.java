package com.educacionit.student.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.persona.api.dao.PersonaDao;
import com.educacionit.student.api.model.Persona;



@RestController
@RequestMapping ("personas")
public class PersonaController {
	
	@Autowired
	PersonaDao dao;
	
	@GetMapping(value = "/all")
	public List<Persona> getAll() {
		return dao.findAll();
	}

	@PostMapping(value = "/save")
	public ResponseEntity<Persona> save(@RequestBody Persona persona) {
		Persona obj = dao.save(persona);
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}
	
	@GetMapping(value = "/find/{id}")
	public Persona find(@PathVariable Integer id) {
		return dao.findById(id).get();
	}
}
