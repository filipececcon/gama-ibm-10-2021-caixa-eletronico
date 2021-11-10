package br.com.caixaeletronico.entidades;


public class Operacao extends AbstractEntity {
	
	@ManyToOne
	private ContaCorrente contaOrigem;
	
	@ManyToOne
	private ContaCorrente contaDestino;
	
	private double valor;
	private TipoOperacao tipoOperacao;
	
	
	
	
	public ContaCorrente getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(ContaCorrente contaDestino) {
		this.contaDestino = contaDestino;
	}

	public ContaCorrente getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(ContaCorrente contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	public TipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	
	
	public static void main(String[] args) {
		
		var novaOperacao = new Operacao();
		
		var contaOrigem =  new ContaCorrente(); //vem da base
		var contaDestino =  new ContaCorrente(); //vem da base
		
		novaOperacao.setContaOrigem(contaOrigem);
		novaOperacao.setValor(100.0);
		novaOperacao.setTipoOperacao(TipoOperacao.TRANSFERENCIA);
		
		if(novaOperacao.getTipoOperacao() == TipoOperacao.TRANSFERENCIA && novaOperacao.getContaDestino() == null) {
			throw new RuntimeException("tranferencia sem conta destino");
		}
				
		
		if(novaOperacao.getTipoOperacao() == TipoOperacao.SAQUE && contaOrigem.getSaldo() <= 0) {
			throw new RuntimeException("saque nao permitido");
		}
		
		
		if(novaOperacao.getTipoOperacao() == TipoOperacao.SAQUE) {
			
			operacaoRepository.add(operacao);
			
			contaOrigem.saque(novaOperacao.valor);
			
		}
		
		if(novaOperacao.getTipoOperacao() == TipoOperacao.DEPOSITO) {
			
			operacaoRepository.add(operacao);
			
			contaOrigem.deposito(novaOperacao.valor);
			
		}
		
		if(novaOperacao.getTipoOperacao() == TipoOperacao.TRANSFERENCIA) {
			
			operacaoRepository.add(operacao);
			
			contaOrigem.saque(novaOperacao.valor);
			contaDestino.deposito(novaOperacao.valor);
			
			
			
		}
		
		
		
				  
				
	}
	
	
}
