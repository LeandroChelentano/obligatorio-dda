package com.obligatorio.dda.repository;

import org.springframework.stereotype.Repository; 

import com.obligatorio.dda.entity.Cliente;

@Repository
public interface UserRepository extends BaseRepository<Cliente, Long> { }
