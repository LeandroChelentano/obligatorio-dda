package com.obligatorio.dda.controller;

import com.obligatorio.dda.entity.Cliente;
import com.obligatorio.dda.service.ClienteService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientesController extends BaseControllerImpl<Cliente, ClienteService> { }
