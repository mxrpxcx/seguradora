package com.gxdxy.seguradora.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gxdxy.seguradora.bean.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

	
	
}
