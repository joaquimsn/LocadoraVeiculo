package br.com.locadora.controller;

import java.util.Date;

import br.com.locadora.model.DAO.PagamentoDAO;
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
	
	/**
	 * Persiste o pagamento passado por parâmetro
	 * @author Joaquim Neto
	 * @param pagamento
	 */
	public void salvarPagamento(Pagamento pagamento) {
		pagamento.setDataPagamento(new Date());
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		pagamentoDAO.insert(pagamento);
	}
	
	
	/**
	 * Busca o id do pagamento realizado
	 * @author Joaquim Neto
	 * @param pagamento
	 * @return Id do pagamento
	 */
	public int buscarIdPagamento(Pagamento pagamento) {
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		return pagamentoDAO.buscarIdPagamento(pagamento);
	}
}
