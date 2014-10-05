package br.com.locadora.controller;

import java.io.Serializable;

import br.com.locadora.model.DAO.AgenciaDAO;
import br.com.locadora.model.entity.Agencia;

public class AgenciaControl implements Serializable{
	private static final long serialVersionUID = 4056318420856682823L;
	
	private AgenciaDAO agenciaDAO;
	
	public AgenciaControl() {
		agenciaDAO = new AgenciaDAO();
	}
	
	public boolean salvar(Agencia agencia) {
		agenciaDAO.insert(agencia);
		
		return true;
	}
}
