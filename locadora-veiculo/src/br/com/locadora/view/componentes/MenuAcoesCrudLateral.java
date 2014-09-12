package br.com.locadora.view.componentes;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.locadora.utils.locale.LocaleUtils;

public class MenuAcoesCrudLateral extends JPanel implements Serializable{
	private static final long serialVersionUID = -3381377661549796928L;

	public MenuAcoesCrudLateral() {
		inicializar();
	}
	
	public MenuAcoesCrudLateral(Object tela) {
		
	}
	
	public void inicializar() {
		this.setLayout(new GridLayout(12, 1, 10, 5));
		this.setSize(100, 300);
		
		this.add(new JButton(LocaleUtils.getLocaleView().getString("btn_alterar_crud")));
		this.add(new JButton(LocaleUtils.getLocaleView().getString("btn_cadastrar_crud")));
		this.add(new JButton(LocaleUtils.getLocaleView().getString("btn_pesquisar_crud")));
		this.add(new JButton(LocaleUtils.getLocaleView().getString("btn_excluir_crud")));
		
		this.setVisible(true);
	}
}
