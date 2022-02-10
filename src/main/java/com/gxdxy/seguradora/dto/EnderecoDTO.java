package com.gxdxy.seguradora.dto;

import javax.validation.constraints.NotBlank;

import com.gxdxy.seguradora.bean.Cliente;

public class EnderecoDTO {

	@NotBlank
	private String logradouro;
	@NotBlank
	private String numero;

	private String complemento;
	@NotBlank
	private String bairro;
	@NotBlank
	private String cep;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
