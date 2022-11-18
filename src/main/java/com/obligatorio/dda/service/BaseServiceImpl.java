package com.obligatorio.dda.service;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.obligatorio.dda.entity.Base;
import com.obligatorio.dda.repository.BaseRepository;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {
	
	private static final long serialVersionUID = 1L;
	
	protected BaseRepository<E, ID> baseRepository;

	public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
		super();
		this.baseRepository = baseRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<E> findAll() throws Exception {
		try {
			return baseRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Page<E> findAll(Pageable pageable) throws Exception {
		try {
			return baseRepository.findAll(pageable);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<E> findById(ID Id) throws Exception {
		try {
			return baseRepository.findById(Id);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional
	public E save(E entity) throws Exception {
		try {
			return baseRepository.save((E) entity);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional
	public void deleteById(ID Id) throws Exception {
		try {
			baseRepository.deleteById(Id);
		} catch (Exception e) {
			throw e;
		}
	}

	public E update(ID Id, Optional<E> entity1) throws Exception{
		try {
			Optional<E> entityOptional = baseRepository.findById(Id);
			E entityUpdate = entityOptional.get();
			entityUpdate = baseRepository.save(entity1);
			return entityUpdate;
		}catch (Exception e){
			throw e;
		}
	}
}