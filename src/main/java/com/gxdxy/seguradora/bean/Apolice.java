package com.gxdxy.seguradora.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Apolice implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer id;
	
	//número deve ser gerado aleatoriamente e único
	private Integer numero;
	
	private Date inicioVigencia;
	private Date fimVigencia;
	private String placaVeiculo;
	private BigDecimal valor;
	
	private Cliente clienteApolice;
	
	public Apolice() {
		
	}

	public Apolice(Integer id, Integer numero, Date inicioVigencia, Date fimVigencia, String placaVeiculo,
			BigDecimal valor, Cliente cliente) {
		super();
		this.id = id;
		this.numero = numero;
		this.inicioVigencia = inicioVigencia;
		this.fimVigencia = fimVigencia;
		this.placaVeiculo = placaVeiculo;
		this.valor = valor;
		this.clienteApolice = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(Date inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public Date getFimVigencia() {
		return fimVigencia;
	}

	public void setFimVigencia(Date fimVigencia) {
		this.fimVigencia = fimVigencia;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return clienteApolice;
	}

	public void setCliente(Cliente cliente) {
		this.clienteApolice = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apolice other = (Apolice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
