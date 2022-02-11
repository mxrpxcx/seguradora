package com.gxdxy.seguradora.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxdxy.seguradora.bean.Apolice;
import com.gxdxy.seguradora.bean.Cliente;
import com.gxdxy.seguradora.repository.ApoliceRepository;

@Service
public class ApoliceService {

	@Autowired
	ApoliceRepository apoliceRepository;

	@Transactional
	public Apolice salvar(Apolice apolice) {
		return apoliceRepository.save(apolice);
	}

	public List<Apolice> listarTodos() {
		return apoliceRepository.findAll();
	}
	
}
