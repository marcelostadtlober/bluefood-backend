package br.com.mstadtlober.bluefood.domain.pagamento;

public enum StatusPagamento {
	
	Autorizado("Autorizado"),
	NaoAutorizado("N�o autorizado pela institui��o financeira"),
	CartaoInvalido("Cart�o inv�lido ou nloqueado");
	
	String descricao;
	
	StatusPagamento (String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
