package com.gxdxy.seguradora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gxdxy.seguradora.service.ApoliceService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/apolices")
public class ApoliceController {

	@Autowired
	ApoliceService apoliceService;
	
}
