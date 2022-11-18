package com.obligatorio.dda.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.obligatorio.dda.entity.Base;

public interface BaseController<E extends Base, ID extends Serializable> {
	
	public ResponseEntity<?> create(@RequestBody E entity) throws Exception;
	
	public ResponseEntity<?> read(@PathVariable ID id) throws Exception;
	
	public ResponseEntity <?> update (@RequestBody E entity, @PathVariable ID id) throws Exception;

	public List<E> readAll() throws Exception;

	public ResponseEntity <?> delete (@PathVariable ID id) throws Exception;

}