package com.educacionit.student.api.controller;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.educacionit.persona.api.dao.PersonaDao;
import com.educacionit.security.JwtProperties;
import com.educacionit.student.api.model.AuthorizationToken;
import com.educacionit.student.api.model.Persona;

@RestController
@RequestMapping("personas")
public class PersonaController {

	@Autowired
	PersonaDao dao;

	@GetMapping(value = "/all")
	public ResponseEntity<?> getAll(@RequestHeader("token") String token) {

		//this converts the token a username
		String userName = JWT.require(HMAC512(JwtProperties.SECRET.getBytes())).build().verify(token).getSubject();

		if (userName.equals("la prueba")) {
			return new ResponseEntity<List<Persona>>(dao.findAll(), HttpStatus.OK);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

		}
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

	@PostMapping(value = "/login")
	public ResponseEntity<AuthorizationToken> login(@RequestBody Persona persona) {
		Persona obj = dao.save(persona);

		String token = JWT.create().withSubject(obj.getNombre())
				.withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
				.sign(HMAC512(JwtProperties.SECRET.getBytes()));

		AuthorizationToken au = new AuthorizationToken(token);

		return new ResponseEntity<AuthorizationToken>(au, HttpStatus.OK);
	}

	@GetMapping(value = "/validate/{token}")
	public ResponseEntity<AuthorizationToken> validateToken(@PathVariable String token) {

		String userName = JWT.require(HMAC512(JwtProperties.SECRET.getBytes())).build().verify(token).getSubject();

		AuthorizationToken au = new AuthorizationToken(userName);
		// Jwts.parser().setSigningKey(JwtProperties.SECRET).
		return new ResponseEntity<AuthorizationToken>(au, HttpStatus.OK);
	}

}
