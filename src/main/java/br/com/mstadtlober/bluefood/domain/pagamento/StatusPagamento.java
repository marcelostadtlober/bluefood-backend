package br.com.mstadtlober.bluefood.domain.pagamento;

public enum StatusPagamento {
	
	Autorizado("Autorizado"),
	NaoAutorizado("Não autorizado pela instituição financeira"),
	CartaoInvalido("Cartão inválido ou nloqueado");
	
	String descricao;
	
	StatusPagamento (String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
