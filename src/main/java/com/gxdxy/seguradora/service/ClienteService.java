package com.gxdxy.seguradora.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxdxy.seguradora.bean.Cliente;
import com.gxdxy.seguradora.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Transactional
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public boolean cpfExistente(String cpf) {
		
		if(clienteRepository.findByCpf(cpf)!=null) {
			return true;
		} else {
			return false;
		}
		
	}

	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	public Optional<Cliente> listarCliente(Integer id) {
		return clienteRepository.findById(id);
	}

}
