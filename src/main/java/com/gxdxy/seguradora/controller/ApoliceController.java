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

import com.gxdxy.seguradora.bean.Apolice;
import com.gxdxy.seguradora.bean.Cliente;
import com.gxdxy.seguradora.dto.ApoliceDTO;
import com.gxdxy.seguradora.service.ApoliceService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/apolices")
public class ApoliceController {

	@Autowired
	ApoliceService apoliceService;
	
	@PostMapping
	public ResponseEntity<Object> salvar(@RequestBody @Valid ApoliceDTO apoliceDTO){
		Apolice apolice = new Apolice();
		BeanUtils.copyProperties(apoliceDTO, apolice);
		apolice.setNumero(null);
		return ResponseEntity.status(HttpStatus.CREATED).body(apoliceService.salvar(apolice));
	}
	
	@GetMapping
	public ResponseEntity<List<Apolice>> listarTodos(){
		return ResponseEntity.status(HttpStatus.OK).body(apoliceService.listarTodos());
	}
	
}
