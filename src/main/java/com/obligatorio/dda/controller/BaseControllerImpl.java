package com.obligatorio.dda.controller;

import com.obligatorio.dda.entity.Base;
import com.obligatorio.dda.service.BaseServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E, Long>> implements BaseController<E, Long>{

	@Autowired
	protected S servicio;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody E entity) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(entity));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) throws Exception {
		Optional<E> oE = servicio.findById(id);
		if (!oE.isPresent()) 
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oE);
	}

	@PutMapping ("/{id}")
	public ResponseEntity <?> update (@RequestBody E entity, @PathVariable Long id) throws Exception{
		Optional<E> otherEntity = servicio.findById(id);
		if (!otherEntity.isPresent())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, otherEntity));
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity <?> delete (@PathVariable Long id) throws Exception{
		if (!servicio.findById(id).isPresent())
			return ResponseEntity.notFound().build();
		
		servicio.deleteById(id);
		return ResponseEntity.ok().build();	
	}
	
	@GetMapping
	public List<E> readAll() throws Exception{
		List<E> entities = (List<E>) StreamSupport
			.stream(servicio.findAll().spliterator(), false)
			.collect(Collectors.toList());
		
		return entities;
	}
}
