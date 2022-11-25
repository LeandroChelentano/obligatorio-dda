package com.obligatorio.dda.controller;

import com.obligatorio.dda.entity.PlanViaje;
import com.obligatorio.dda.service.PlanViajeService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/planes")
public class PlanViajeController extends BaseControllerImpl<PlanViaje, PlanViajeService> { }
