package br.com.caixaeletronico.entidades;

import java.util.HashMap;

public class Saque extends AbstractEntity {

	private int valor;
	
	private HashMap<Integer, Integer> cedulas;
	
	public Saque(int valor) {
		super();
		this.valor = valor;
		this.cedulas = new HashMap<>();
	}

	public int getValor() {
		return this.valor;
	}
	
	public void addCedula(Integer cedula, int qtde) {
		cedulas.put(cedula, qtde);
	}
	
	public HashMap<Integer, Integer> getCedulas() {
		return cedulas;
	}
}
