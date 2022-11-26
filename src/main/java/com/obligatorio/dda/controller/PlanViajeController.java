package com.obligatorio.dda.controller;

import com.obligatorio.dda.entity.PlanViaje;
import com.obligatorio.dda.service.PlanViajeService;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/planes")
public class PlanViajeController extends BaseControllerImpl<PlanViaje, PlanViajeService> {
  @Override
  @PostMapping
	public ResponseEntity<?> create (@RequestBody PlanViaje plan) throws Exception {
    if (plan.getFecha().isBefore(LocalDate.now())) {
      return ResponseEntity.badRequest().build();
    }

		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(plan));
	}

  @PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody PlanViaje plan, @PathVariable Long id) throws Exception {
		Optional<PlanViaje> existingEntity = servicio.findById(id);
		if (!existingEntity.isPresent())
			return ResponseEntity.notFound().build();

    if (plan.getFecha().isBefore(LocalDate.now()))
      return ResponseEntity.badRequest().build();
		
		return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, plan));
	}
}
