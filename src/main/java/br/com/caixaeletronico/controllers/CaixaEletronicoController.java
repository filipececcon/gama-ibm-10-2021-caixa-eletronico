package br.com.caixaeletronico.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caixaeletronico.entidades.CaixaEletronico;
import br.com.caixaeletronico.entidades.Saque;
import br.com.caixaeletronico.forms.SaqueForm;
import br.com.caixaeletronico.services.CaixaEletronicoService;

@RestController
@RequestMapping("caixa-eletronico")
public class CaixaEletronicoController {

	@Autowired
	private CaixaEletronicoService service;
	
	private CaixaEletronico caixa;
	
	public CaixaEletronicoController() {
		caixa = new CaixaEletronico(100,50,20,10,5);
	}
	
	
	@PostMapping("/saque")
	public ResponseEntity<?> addSaque(@RequestBody @Valid SaqueForm form){
						
		var saque = new Saque(form.valor);
		
		service.addSaque(caixa, saque);
				
		return ResponseEntity.ok(caixa);
	}
	
	
	
}
