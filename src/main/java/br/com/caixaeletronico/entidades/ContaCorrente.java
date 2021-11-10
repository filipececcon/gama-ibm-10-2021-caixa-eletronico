package br.com.caixaeletronico.entidades;

public class ContaCorrente extends AbstractEntity {

	private double saldo;
	
	@OneToMany
	private List<Operacao> operacoes;
	
	
	
	
	public double getSaldo() {
		return saldo;
	}




	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}




	public void saque(double valor) {
	
		saldo -= valor;
		
	}
	
	public void deposito(double valor) {
		
		saldo += valor;
		
	}
	
}
