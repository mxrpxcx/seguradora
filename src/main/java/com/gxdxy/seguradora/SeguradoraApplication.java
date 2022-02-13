package com.gxdxy.seguradora;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gxdxy.seguradora.bean.Apolice;
import com.gxdxy.seguradora.bean.Cidade;
import com.gxdxy.seguradora.bean.Cliente;
import com.gxdxy.seguradora.bean.Endereco;
import com.gxdxy.seguradora.bean.UnidadeFederal;
import com.gxdxy.seguradora.repository.ApoliceRepository;
import com.gxdxy.seguradora.repository.CidadeRepository;
import com.gxdxy.seguradora.repository.ClienteRepository;
import com.gxdxy.seguradora.repository.EnderecoRepository;
import com.gxdxy.seguradora.repository.UnidadeFederalRepository;
import com.gxdxy.seguradora.utils.ApoliceKeyGen;

@SpringBootApplication
public class SeguradoraApplication implements CommandLineRunner {

	@Autowired
	private ApoliceRepository apoliceRepo;
	
	@Autowired
	private UnidadeFederalRepository ufRepo;
	
	@Autowired
	private CidadeRepository cidadeRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private EnderecoRepository enderecoRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SeguradoraApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		UnidadeFederal uf1 = new UnidadeFederal(null, "Paraná", "PR");
		UnidadeFederal uf2 = new UnidadeFederal(null, "São Paulo", "SP");
		
		Cidade cid1 = new Cidade(null, "Curitiba", uf1);
		Cidade cid2 = new Cidade(null, "São Paulo", uf2);

		ufRepo.saveAll(Arrays.asList(uf1,uf2));
		cidadeRepo.saveAll(Arrays.asList(cid1,cid2));
		
		Cliente cli1 = new Cliente(null,"Renan","51066249083");
		Cliente cli2 = new Cliente(null,"Joel","28788497011");
		
		clienteRepo.saveAll(Arrays.asList(cli1,cli2));
		
		Endereco end1 = new Endereco(null,"Rua Teste","1", "Complemento Teste", "Bairro Teste",
				"1", cli1, cid1);
		
		Endereco end2 = new Endereco(null,"Rua Teste","2", "Complemento Teste", "Bairro Teste",
				"2", cli2, cid2);
		
		enderecoRepo.saveAll(Arrays.asList(end1,end2));
		

		Apolice ap1 = new Apolice(null,ApoliceKeyGen.gerarNumeroApolice(10), LocalDateTime.now(), LocalDateTime.now(), "TET0123", BigDecimal.valueOf(259.99), cli1);
		Apolice ap2 = new Apolice(null,ApoliceKeyGen.gerarNumeroApolice(10), LocalDateTime.now(), LocalDateTime.now(), "TET0125", BigDecimal.valueOf(259.99), cli2);

		apoliceRepo.saveAll(Arrays.asList(ap1,ap2));
		
	}

}
