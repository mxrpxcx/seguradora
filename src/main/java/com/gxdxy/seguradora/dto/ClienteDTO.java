package com.gxdxy.seguradora.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class ClienteDTO {

		@NotBlank
		private String nomeCompleto;
		
		@CPF
		@Size(max=11)
		private String cpf;
		
	
}
