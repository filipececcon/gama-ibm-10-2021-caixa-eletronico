package br.com.caixaeletronico.services;

import org.springframework.stereotype.Service;

import br.com.caixaeletronico.entidades.CaixaEletronico;
import br.com.caixaeletronico.entidades.Saque;

@Service
public class CaixaEletronicoService {
	
	private boolean IsSaqueValido(CaixaEletronico caixa, Saque saque) throws RuntimeException {
		
		var tamanho = caixa.getCedulasDisponiveis().size();
		
		var menorNota = caixa.getCedulasDisponiveis().get(tamanho - 1);
		
		if(saque.getValor() <= 0) {
			throw new RuntimeException("O valor do saque deve ser maior que 0");			
		}
		
		if(saque.getValor() % menorNota != 0) {
			var msg = "Saque de valor: R$"+saque.getValor()+" inválido no momento. "
				 + "Notas disponíveis são:"+ caixa.getCedulasDisponiveis();
			
			throw new RuntimeException(msg);
		}
	
		return true;
	}
	
	public void addSaque(CaixaEletronico caixa, Saque saque) throws RuntimeException {
	
		if(!IsSaqueValido(caixa, saque)) return;
		
		int residuo = saque.getValor(); //250
				
		for (int i = 0; i < caixa.getCedulasDisponiveis().size() ; i++) {
						
			var valorDaNota = caixa.getCedulasDisponiveis().get(i);
		
			int qtde = (int) residuo/valorDaNota;
		
			if(qtde == 0) continue;
			
			saque.addCedula(valorDaNota, qtde);
			
			residuo -= qtde*valorDaNota;
			
			if(residuo == 0) break;
		}
		
		caixa.addSaque(saque);
		
	}
	
//	public static void main(String[] args) {
//		
//		
//		var caixa = new CaixaEletronico(100,50,20,10,5);
//				
//		var saque = new Saque(235);
//		
//		var service = new CaixaEletronicoService(caixa);
//		
//		try {
//			
//			service.addSaque(saque);
//			
//			System.out.println(caixa.getSaques().get(0).getCedulas());
//			
//		}
//		catch(RuntimeException ex) {
//			
//			System.out.println(ex.getMessage());
//			
//		}
//	}
	
	
}
