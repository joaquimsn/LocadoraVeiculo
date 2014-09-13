package br.com.locadora.model.entity;

import br.com.locadora.utils.annotation.Required;

public class Agencia {
	
	@Required(label =  "Nome", minimo = 5)
	private String nome;
}
