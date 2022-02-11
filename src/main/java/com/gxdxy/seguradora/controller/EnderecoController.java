package com.gxdxy.seguradora.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gxdxy.seguradora.bean.Endereco;
import com.gxdxy.seguradora.dto.EnderecoDTO;
import com.gxdxy.seguradora.service.EnderecoService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;
	
	@PostMapping
	public ResponseEntity<Object> salvar(@RequestBody @Valid EnderecoDTO enderecoDTO){
		
		Endereco endereco = new Endereco();
		BeanUtils.copyProperties(enderecoDTO, endereco);;

		return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.salvar(endereco));
	}
	
	@GetMapping
	public ResponseEntity<List<Endereco>> listarTodos(){
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.listarTodos());
	}
	
}
