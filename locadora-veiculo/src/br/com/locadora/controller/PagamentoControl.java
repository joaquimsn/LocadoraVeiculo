package br.com.locadora.controller;

import br.com.locadora.model.entity.Pagamento;

public class PagamentoControl {
	
	public boolean processarPagamento(Pagamento cartao) {
		int numero = (int) (Math.random() * 10);
		
		if (numero >= 50) {
			return true;
		}
		
		return false;
	}
}
