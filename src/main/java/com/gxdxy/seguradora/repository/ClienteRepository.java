package com.gxdxy.seguradora.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gxdxy.seguradora.bean.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
	
	Cliente findByCpf(String cpf);
	
}
