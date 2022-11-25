package com.obligatorio.dda.service;

import com.obligatorio.dda.entity.PlanViaje;
import com.obligatorio.dda.repository.BaseRepository;

import org.springframework.stereotype.Service;

@Service
public class PlanViajeService extends BaseServiceImpl<PlanViaje, Long>{
	public PlanViajeService(BaseRepository<PlanViaje, Long> baseRepository) {
		super(baseRepository);
	}
}
