package com.gxdxy.seguradora.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class EnderecoDTO {
		
		@NotBlank
		private String logradouro;
		@NotBlank
		private String numero;
		@NotBlank
		private String complemento;
		@NotBlank
		private String bairro;
		@NotBlank
		private String cep;
		
	
}
