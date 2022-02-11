package com.gxdxy.seguradora.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gxdxy.seguradora.bean.Apolice;
import com.gxdxy.seguradora.dto.ApoliceDTO;
import com.gxdxy.seguradora.service.ApoliceService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/apolices")
public class ApoliceController {

	@Autowired
	ApoliceService apoliceService;
	
	@PostMapping
	public ResponseEntity<Object> salvar(@RequestBody @Valid ApoliceDTO apoliceDTO){
		Apolice apolice = new Apolice();
		BeanUtils.copyProperties(apoliceDTO, apolice);
		apolice.setNumero(null);
		return ResponseEntity.status(HttpStatus.CREATED).body(apoliceService.salvar(apolice));
	}
	
	@GetMapping
	public ResponseEntity<List<Apolice>> listarTodos(){
		return ResponseEntity.status(HttpStatus.OK).body(apoliceService.listarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> listarApolice(@PathVariable(value="id") Integer id){
		Optional<Apolice> apoliceOptional = apoliceService.listarApolice(id);
		StringBuilder response = new StringBuilder("Informações: ");
		response.append(System.getProperty("line.separator"));
		
		if(!apoliceOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("[Erro ao buscar apolice] Documento não encontrado no sistema");
		}
		
		if(apoliceOptional.get().getFimVigencia().isBefore(LocalDateTime.now())) {
			Integer dias = apoliceOptional.get().getFimVigencia().getDayOfMonth()-
			LocalDateTime.now().getDayOfMonth();
			
			Integer meses = apoliceOptional.get().getFimVigencia().getMonthValue()-
			LocalDateTime.now().getMonthValue();
			
			Integer anos = apoliceOptional.get().getFimVigencia().getYear()-
			LocalDateTime.now().getYear();
			
			response.append("Apólice vencida há "+anos+" ano(s), "+meses+" meses, "+dias+" dia(s)");
			
			
		} else if (apoliceOptional.get().getFimVigencia().isAfter(LocalDateTime.now())) {
			
			Integer dias = apoliceOptional.get().getFimVigencia().getDayOfMonth()-
			apoliceOptional.get().getInicioVigencia().getDayOfMonth();
			
			Integer meses = apoliceOptional.get().getFimVigencia().getMonthValue()-
			apoliceOptional.get().getInicioVigencia().getMonthValue();
			
			Integer anos = apoliceOptional.get().getFimVigencia().getYear()-
			apoliceOptional.get().getInicioVigencia().getYear();
			
			response.append("Apólice vence em "+anos+" ano(s), "+meses+" meses, "+dias+" dia(s)");

		} 
		
		response.append(System.getProperty("line.separator"));
		response.append("Placa do veículo: "+apoliceOptional.get().getPlacaVeiculo());
		response.append(System.getProperty("line.separator"));
		response.append("Valor: "+apoliceOptional.get().getValor());

			
			return ResponseEntity.status(HttpStatus.OK).body(response+
					System.getProperty("line.separator")+apoliceOptional.get().toString());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> apagarApolice(@PathVariable(value="id") Integer id){
		Optional<Apolice> apoliceOptional = apoliceService.listarApolice(id);
		
			if(!apoliceOptional.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("[Erro ao apagar apolice] Documento não encontrado no sistema");
			}
			
			apoliceService.apagarApolice(apoliceOptional.get());
			return ResponseEntity.status(HttpStatus.OK).body("Documento apagado do sistema com sucesso");
	}
	
}
