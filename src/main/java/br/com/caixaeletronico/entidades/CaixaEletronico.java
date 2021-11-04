package br.com.caixaeletronico.entidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CaixaEletronico extends AbstractEntity {

	private List<Integer> cedulasDisponiveis;
	private List<Saque> saques;
	
	
	public CaixaEletronico(Integer... cedulas) {
		Arrays.sort(cedulas, Collections.reverseOrder());
		cedulasDisponiveis = Arrays.asList(cedulas);
		saques = new ArrayList<Saque>();
	}

	public List<Integer> getCedulasDisponiveis() {
		return cedulasDisponiveis;
	}
	
	public void addSaque(Saque saque) {
		saques.add(saque);		
	}
	
	public List<Saque> getSaques(){
		return this.saques;
	}
	
}
