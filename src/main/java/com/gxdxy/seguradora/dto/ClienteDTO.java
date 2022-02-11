package com.gxdxy.seguradora.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

		@NotBlank
		private String nomeCompleto;
		
		@CPF
		@Size(max=11)
		private String cpf;

		public String getNomeCompleto() {
			return nomeCompleto;
		}

		public void setNomeCompleto(String nomeCompleto) {
			this.nomeCompleto = nomeCompleto;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

}
