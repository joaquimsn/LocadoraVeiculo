package br.com.locadora.controller;

import br.com.locadora.model.entity.Pagamento;

public class PagamentoControl {
	
	/**
	 * @author Joaquim Neto
	 * @param cartao
	 * @return <b>true</b> Se o pagamento for efetuado com sucesso
	 */
	public boolean processarPagamento(Pagamento cartao) {
		int numero = (int) (Math.random() * 100);
		
		if (numero >= 50) {
			return true;
		}
		
		return false;
	}
}
