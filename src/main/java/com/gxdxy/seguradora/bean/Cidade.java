package com.gxdxy.seguradora.bean;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="tbCidade")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	private String nome;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="fkUfCidade")
	private UnidadeFederal unidadeFederal;
	
	public Cidade() {
		
	}

	public Cidade(UUID id, String nome, UnidadeFederal unidadeFederal) {
		super();
		this.id = id;
		this.nome = nome;
		this.unidadeFederal = unidadeFederal;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UnidadeFederal getUnidadeFederal() {
		return unidadeFederal;
	}

	public void setUnidadeFederal(UnidadeFederal unidadeFederal) {
		this.unidadeFederal = unidadeFederal;
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
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
