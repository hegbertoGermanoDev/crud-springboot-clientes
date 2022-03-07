package com.algaworks.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.crm.model.Cliente;
import com.algaworks.crm.repository.ClienteRepository;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping(path = "/clientes")
	public List<Cliente> listCliente() {
		return clienteRepository.findAll();
	}
	
	@GetMapping(path = "/clientes/{id}")
	public Optional<Cliente> getClienteById(@PathVariable("id") Long id) {
		return clienteRepository.findById(id);
	}
	
	@PostMapping(path = "/clientes/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente saveCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
}
