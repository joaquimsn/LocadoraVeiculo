package br.com.locadora.view.componentes;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.locadora.utils.SystemUtils;
import br.com.locadora.utils.locale.LocaleUtils;

public class MenuAcoesLateral extends JPanel implements Serializable{
	private static final long serialVersionUID = -3381377661549796928L;
	
	private JPanel telaParaControle;
	
	public MenuAcoesLateral() {
		inicializar();
	}
	
	public MenuAcoesLateral(JPanel tela) {
		telaParaControle = tela;
		inicializar();
	}
	
	public void inicializar() {
		this.setLayout(new GridLayout(12, 1, 20, 5));
		this.setSize(150, 400);
		
		// Borda para o menu lateral
		Border border = new TitledBorder(new LineBorder(Color.GRAY, 1, true), LocaleUtils.getLocaleView().getString("titulo_menu_lateral"));
		
		this.add(new JButton(LocaleUtils.getLocaleView().getString("btn_alterar_crud")));
		this.add(new JButton(LocaleUtils.getLocaleView().getString("btn_cadastrar_crud")));
		this.add(new JButton(LocaleUtils.getLocaleView().getString("btn_pesquisar_crud")));
		this.add(new JButton(LocaleUtils.getLocaleView().getString("btn_excluir_crud")));
		
		this.setBorder(border);
		
		if (SystemUtils.isTodosNulosOuVazios(telaParaControle)) {
			this.setVisible(false);
		} else {
			this.setVisible(true);
		}
		
	}
	
	public void setTelaParaControle(JPanel tela) {
		telaParaControle = tela;
		
		if (SystemUtils.isTodosNulosOuVazios(telaParaControle)) {
			this.setVisible(false);
		} else {
			this.setVisible(true);
		}
		
		this.repaint();
	}
}
