package com.obligatorio.dda.service;

import com.obligatorio.dda.entity.PlanViaje;
import com.obligatorio.dda.repository.BaseRepository;
import com.obligatorio.dda.repository.PlanViajeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanViajeService extends BaseServiceImpl<PlanViaje, Long>{

	@Autowired
	private PlanViajeRepository planViajeRepository;

	public PlanViajeService(BaseRepository<PlanViaje, Long> baseRepository) {
		super(baseRepository);
	}
}
