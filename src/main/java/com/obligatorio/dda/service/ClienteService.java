package com.obligatorio.dda.service;

import com.obligatorio.dda.entity.Cliente;
import com.obligatorio.dda.repository.BaseRepository;
import com.obligatorio.dda.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends BaseServiceImpl<Cliente, Long>{

	@Autowired
	private UserRepository userRepository;

	public ClienteService(BaseRepository<Cliente, Long> baseRepository) {
		super(baseRepository);
	}
}
