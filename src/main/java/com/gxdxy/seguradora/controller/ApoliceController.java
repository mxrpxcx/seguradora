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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gxdxy.seguradora.bean.Apolice;
import com.gxdxy.seguradora.bean.Cliente;
import com.gxdxy.seguradora.dto.ApoliceDTO;
import com.gxdxy.seguradora.service.ApoliceService;
import com.gxdxy.seguradora.service.ClienteService;
import com.gxdxy.seguradora.utils.ApoliceKeyGen;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/apolices")
public class ApoliceController {

	@Autowired
	ApoliceService apoliceService;

	@Autowired
	ClienteService clienteService;

	@PostMapping
	public ResponseEntity<Object> salvar(@RequestBody @Valid ApoliceDTO apoliceDTO, @RequestParam Integer idCli) {
		if (apoliceDTO.getFimVigencia().isBefore(apoliceDTO.getInicioVigencia())) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(
					"[Erro ao salvar aplice] A data de finalização da vigência não pode ser inferior à de início");
		}

		Apolice apolice = new Apolice();

		BeanUtils.copyProperties(apoliceDTO, apolice);
		Optional<Cliente> cliente = clienteService.listarCliente(idCli);

		if (cliente.isPresent()) {
			apolice.setCliente(cliente.get());
		}

		apolice.setNumero(ApoliceKeyGen.gerarNumeroApolice(10));

		return ResponseEntity.status(HttpStatus.CREATED).body(apoliceService.salvar(apolice));
	}

	@GetMapping
	public ResponseEntity<List<Apolice>> listarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(apoliceService.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> listarApolice(@PathVariable(value = "id") Integer id) {
		Optional<Apolice> apoliceOptional = apoliceService.listarApolice(id);

		if (!apoliceOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("[Erro ao buscar apolice] Documento não encontrado no sistema");
		}

		StringBuilder response = new StringBuilder("Informações: ");
		response.append(System.getProperty("line.separator"));

		response.append("Cliente: " + apoliceOptional.get().getCliente().getNomeCompleto());
		response.append(System.getProperty("line.separator"));

		if (apoliceOptional.get().getFimVigencia().isBefore(LocalDateTime.now())) {
			Integer dias = apoliceOptional.get().getFimVigencia().getDayOfMonth() - LocalDateTime.now().getDayOfMonth();

			Integer meses = apoliceOptional.get().getFimVigencia().getMonthValue()
					- LocalDateTime.now().getMonthValue();

			Integer anos = apoliceOptional.get().getFimVigencia().getYear() - LocalDateTime.now().getYear();

			response.append("Apólice vencida há " + anos + " ano(s), " + meses + " meses, " + dias + " dia(s)");

		} else if (apoliceOptional.get().getFimVigencia().isAfter(LocalDateTime.now())) {

			Integer dias = apoliceOptional.get().getFimVigencia().getDayOfMonth()
					- apoliceOptional.get().getInicioVigencia().getDayOfMonth();

			Integer meses = apoliceOptional.get().getFimVigencia().getMonthValue()
					- apoliceOptional.get().getInicioVigencia().getMonthValue();

			Integer anos = apoliceOptional.get().getFimVigencia().getYear()
					- apoliceOptional.get().getInicioVigencia().getYear();

			response.append("Apólice vence em " + anos + " ano(s), " + meses + " meses, " + dias + " dia(s)");

		} else {
			response.append("Apólice vence hoje");
		}

		response.append(System.getProperty("line.separator"));
		response.append("Placa do veículo: " + apoliceOptional.get().getPlacaVeiculo());
		response.append(System.getProperty("line.separator"));
		response.append("Valor: " + apoliceOptional.get().getValor());

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> apagarApolice(@PathVariable(value = "id") Integer id) {
		Optional<Apolice> apoliceOptional = apoliceService.listarApolice(id);

		if (!apoliceOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("[Erro ao apagar apolice] Documento não encontrado no sistema");
		}

		apoliceService.apagarApolice(apoliceOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Documento apagado do sistema com sucesso");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizarApolice(@PathVariable(value = "id") Integer id,
			@RequestBody @Valid ApoliceDTO apoliceDTO, @RequestParam Integer idCli) {
		Optional<Apolice> apoliceOptional = apoliceService.listarApolice(id);
		Optional<Cliente> clienteOptional = clienteService.listarCliente(idCli);
		
		if (!apoliceOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("[Erro ao buscar documento] Apolice não encontrada no sistema");
		}

		Apolice apolice = new Apolice();
		BeanUtils.copyProperties(apoliceDTO, apolice);
		apolice.setId(apoliceOptional.get().getId());
		apolice.setNumero(apoliceOptional.get().getNumero());
		apolice.setCliente(clienteOptional.get());

		return ResponseEntity.status(HttpStatus.OK).body(apoliceService.salvar(apolice));
	}

}
