package com.gxdxy.seguradora.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxdxy.seguradora.bean.Endereco;
import com.gxdxy.seguradora.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;

	@Transactional
	public Endereco salvar(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

}
