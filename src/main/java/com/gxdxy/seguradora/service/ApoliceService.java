package com.gxdxy.seguradora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxdxy.seguradora.repository.ApoliceRepository;

@Service
public class ApoliceService {

	@Autowired
	ApoliceRepository apoliceRepository;
	
}
