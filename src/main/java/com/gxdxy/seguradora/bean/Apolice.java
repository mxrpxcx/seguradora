package com.gxdxy.seguradora.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="tbApolice")
public class Apolice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	//número deve ser gerado aleatoriamente e único
	@Column(unique=true, length=10)
	private String numero;
	
	private LocalDateTime inicioVigencia;
	private LocalDateTime fimVigencia;
	
	@Column(unique=true, length=7)
	private String placaVeiculo;
	
	private BigDecimal valor;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="fkClienteApolice")
	private Cliente clienteApolice;
	
	public Apolice() {
		
	}

	public Apolice(Integer id, String numero, LocalDateTime inicioVigencia, LocalDateTime fimVigencia, String placaVeiculo,
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(LocalDateTime inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public LocalDateTime getFimVigencia() {
		return fimVigencia;
	}

	public void setFimVigencia(LocalDateTime fimVigencia) {
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

	@Override
	public String toString() {
		return "Apolice [id=" + id + ", numero=" + numero + ", inicioVigencia=" + inicioVigencia + ", fimVigencia="
				+ fimVigencia + ", placaVeiculo=" + placaVeiculo + ", valor=" + valor + ", clienteApolice="
				+ clienteApolice + "]";
	}
	
}
