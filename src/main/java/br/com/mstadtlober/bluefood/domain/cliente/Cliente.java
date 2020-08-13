package br.com.mstadtlober.bluefood.domain.cliente;

import javax.persistence.Entity;

import br.com.mstadtlober.bluefood.domain.usuario.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
public class Cliente extends Usuario {
	
	private String cpg;
	
	private String cep;

}
