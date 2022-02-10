package com.gxdxy.seguradora.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gxdxy.seguradora.bean.Cliente;
import com.gxdxy.seguradora.dto.ClienteDTO;
import com.gxdxy.seguradora.service.ClienteService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Object> salvar(@RequestBody @Valid ClienteDTO clienteDTO){
		Cliente cliente = new Cliente();
		BeanUtils.copyProperties(clienteDTO, cliente);

		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvar(cliente));
	}
	
}
