package com.gxdxy.seguradora.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		if(clienteService.cpfExistente(clienteDTO.getCpf())) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body("[Erro ao salvar cliente] CPF já existente!");
		}
		
		Cliente cliente = new Cliente();
		BeanUtils.copyProperties(clienteDTO, cliente);

		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvar(cliente));
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarTodos(){
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.listarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> listarCliente(@PathVariable(value="id") Integer id){
		Optional<Cliente> clienteOptional = clienteService.listarCliente(id);
		
			if(!clienteOptional.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("[Erro ao buscar cliente] Cliente não encontrado no sistema");
			}
			return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> apagarCliente(@PathVariable(value="id") Integer id){
		Optional<Cliente> clienteOptional = clienteService.listarCliente(id);
		
			if(!clienteOptional.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("[Erro ao buscar cliente] Cliente não encontrado no sistema");
			}
			
			clienteService.apagarCliente(clienteOptional.get());
			return ResponseEntity.status(HttpStatus.OK).body("Cliente apagado do sistema com sucesso");
	}
	
}
