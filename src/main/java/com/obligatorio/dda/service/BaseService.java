package com.obligatorio.dda.service;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.obligatorio.dda.entity.Base;

public interface BaseService<E extends Base, ID> extends Serializable {
	
	public Iterable<E> findAll() throws Exception;
	
	public Page<E> findAll(Pageable pageable) throws Exception;
	
	public Optional<E> findById(ID Id) throws Exception;
	
	public E save(E entity) throws Exception;
	
	public void deleteById (ID Id) throws Exception;

	public E update(Long id, E entity) throws Exception;
}
