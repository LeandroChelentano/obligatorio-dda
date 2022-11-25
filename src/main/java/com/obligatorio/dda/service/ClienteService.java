package com.obligatorio.dda.service;

import com.obligatorio.dda.entity.Cliente;
import com.obligatorio.dda.repository.BaseRepository;

import org.springframework.stereotype.Service;

@Service
public class ClienteService extends BaseServiceImpl<Cliente, Long>{
	public ClienteService(BaseRepository<Cliente, Long> baseRepository) {
		super(baseRepository);
	}
}
