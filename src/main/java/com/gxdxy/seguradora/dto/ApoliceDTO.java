package com.gxdxy.seguradora.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ApoliceDTO {

		@NotBlank
		private String numero;
		
		@NotBlank
		private LocalDateTime inicioVigencia;
		
		@NotBlank
		private LocalDateTime fimVigencia;
		
		@NotBlank
		@Size(max=7)
		private String placaVeiculo;
		
		@NotBlank
		private BigDecimal valor;
	
}
