package com.obligatorio.dda.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.obligatorio.dda.entity.Base;

//Vamos a hacer los controllers genéricos. Para ello generamos esta Interface y los controladores implementarán
//a esta Interface, que será del tipo genérica y tendrá los métodos básicos, como hicimos con la interfaz BaseService
public interface BaseController<E extends Base, ID extends Serializable> {
	//Nuestros métodos van a retornar un ResponseEntity
	//El signo de interrogación indica que puede manejar un objeto de cualquier tipo
	public ResponseEntity<?> create(@RequestBody E entity) throws Exception;
	public ResponseEntity<?> read(@PathVariable ID id)throws Exception;
	public ResponseEntity <?> update (@RequestBody E entity, 
			@PathVariable ID id)throws Exception;
	public List<E> readAll()throws Exception;
	public ResponseEntity <?> delete (@PathVariable ID id)throws Exception;
}
//Ahora tenemos que hacer una implementación de esta Interface que llamaremos BaseControllerImpl
