package com.gxdxy.seguradora.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.gxdxy.seguradora.bean.Cliente;

public class ApoliceDTO implements Serializable {
	private static final long serialVersionUID = 1L;

		private LocalDateTime inicioVigencia;
		
		private LocalDateTime fimVigencia;
		
		@NotBlank
		@Size(max=7)
		private String placaVeiculo;
		
		private BigDecimal valor;

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

}
