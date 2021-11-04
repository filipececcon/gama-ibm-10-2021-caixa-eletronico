package br.com.caixaeletronico.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.caixaeletronico.entidades.CaixaEletronico;
import br.com.caixaeletronico.entidades.Saque;

class CaixaEletronicoServiceTest {

	private CaixaEletronico caixa;
	
	private CaixaEletronicoService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Começando os teste de caixa eletronico");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Teminado os teste de caixa eletronico");
	}

	@BeforeEach
	void setUp() throws Exception {
		caixa = new CaixaEletronico(100,50,20,10,5);
		service = new CaixaEletronicoService();
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("proximo teste");
	}

	@Test
	void deveriaRetornarErroQuandoUmSaqueTemOValorNegativo() throws RuntimeException {
				
		var saque = new Saque(-10);
		
		var excecao = Assertions
		.assertThrows(RuntimeException.class, () -> service.addSaque(caixa, saque));
	
		Assertions
		.assertEquals("O valor do saque deve ser maior que 0", excecao.getMessage());
		
	}
	
	@Test
	void deveriaRetornarErroQuandoUmSaqueTemOValorZerado() throws RuntimeException {
		
		var saque = new Saque(0);
			
		var excecao = Assertions		
		.assertThrows(RuntimeException.class, () -> service.addSaque(caixa, saque));
			
		Assertions
		.assertEquals("O valor do saque deve ser maior que 0", excecao.getMessage());
	}
	
	@Test
	void deveriaRetornarErroQuantoUmSaqueTemOValorMenorQueOValorDaMenorNotaDisponivel() {
		
		var saque = new Saque(3);
			
		var excecao = Assertions
		.assertThrows(RuntimeException.class, () -> service.addSaque(caixa, saque));
		
		var msg = "Saque de valor: R$"+saque.getValor()+" inválido no momento. "
				 + "Notas disponíveis são:"+ caixa.getCedulasDisponiveis();
		
		Assertions
		.assertEquals(msg, excecao.getMessage());
	}
	
	
}

// testes de unidade -> tem o proposito de validar o funcionamento de uma logica
// testes de integraçao -> sao teste que dependem de integracao com uma unidade externa

// RGR -> Red, Green e Refactor
// AAA -> Arrange, Act e Assert

// DDD - Domain Driven Design -> Desenvolvimento dirigido pelo dominio(dominio é o dono da aplicaçao)
// TDD(tem o ddd dentro) - Test Driven Delopment -> Desenvolvimento dirigido por testes 
// BDD(tem o tdd dentro) - Behavior Driven DEvelopment -> Desenvolvimento dirigido por comportamento

// Given, When, Then -> Dado, Quando, Então
// Dado que é criado um caixa eletronico com as notas 100,50,20,10,5
// Quando realizo um novo saque de 250
// Então o caixa deve retonar notas de 100 em 2 quantidade
// E notas de 50 em 1 quantidade

