package com.obligatorio.dda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.obligatorio.dda.entity.Cliente;
import com.obligatorio.dda.entity.PlanViaje;
import com.obligatorio.dda.service.ClienteService;
import com.obligatorio.dda.service.PlanViajeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/relation")
public class RelationController {
  @Autowired
	protected ClienteService clienteService;

  @Autowired
	protected PlanViajeService planViajeService;

  @PostMapping
	public ResponseEntity<?> create(@RequestBody String body) throws Exception {
    Object dataO = JSONValue.parse(body);
    JSONObject data = (JSONObject) dataO;
 
    Long clienteId = (Long) data.get("cliente");
    Long viajeId = (Long) data.get("viaje");
    
    Optional<PlanViaje> viajeO = planViajeService.findById(viajeId);
    Optional<Cliente> clienteO = clienteService.findById(clienteId);

    if (!viajeO.isPresent() || !clienteO.isPresent()) 
			return ResponseEntity.notFound().build();
    
    Cliente cliente = clienteO.get();
    PlanViaje viaje = viajeO.get();

    List<PlanViaje> listaViajes = cliente.getViajes();
    Boolean founded = false;
    for (PlanViaje PV : listaViajes) {
      if (PV.getId() == viaje.getId()) {
        founded = true;
      }
    }

    if (founded || viaje.getFecha().isBefore(LocalDate.now())) {
      return ResponseEntity.badRequest().build();
    }
    
    listaViajes.add(viaje);
    cliente.setViajes(listaViajes);
    
    if (listaViajes.size() > 2) {
      cliente.setIsPremium(true);
    }

    return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
	}

  @DeleteMapping
	public ResponseEntity<?> delete(@RequestParam String cli, @RequestParam String plan) throws Exception {
    Long clienteId = Long.valueOf(cli);
    Long viajeId = Long.valueOf(plan);
    
    Optional<PlanViaje> viajeO = planViajeService.findById(viajeId);
    Optional<Cliente> clienteO = clienteService.findById(clienteId);

    if (!viajeO.isPresent() || !clienteO.isPresent()) 
			return ResponseEntity.notFound().build();
    
    Cliente cliente = clienteO.get();
    PlanViaje viaje = viajeO.get();

    List<PlanViaje> listaViajes = cliente.getViajes();
    Boolean founded = false;
    for (PlanViaje PV : listaViajes) {
      if (PV.getId() == viaje.getId()) {
        founded = true;
      }
    }

    if (!founded) {
      return ResponseEntity.badRequest().build();
    }
    
    listaViajes.remove(viaje);
    cliente.setViajes(listaViajes);

    return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
	}
}
