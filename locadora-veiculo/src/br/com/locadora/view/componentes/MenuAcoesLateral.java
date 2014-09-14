package br.com.locadora.view.componentes;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.locadora.utils.SystemUtils;
import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.LocacaoGUI;

public class MenuAcoesLateral extends JPanel implements Serializable, ActionListener{
	private static final long serialVersionUID = -3381377661549796928L;
	
	private JPanel telaParaControle;
	
	private JButton btnHome;
	private JButton btnLocacao;
	private JButton btnDevolucao;
	private JButton btnCadastrar;
	private JButton btnPesquisar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	
	private static JPanel panelContainer;
	
	public MenuAcoesLateral() {
		inicializar();
	}
	
	public MenuAcoesLateral(JPanel tela) {
		telaParaControle = tela;
		inicializar();
	}
	
	public void inicializar() {
		this.setLayout(new FlowLayout());
		this.setSize(150, 500);
		
		// Borda para o menu lateral
		Border border = new TitledBorder(new LineBorder(Color.GRAY, 1, true), LocaleUtils.getLocaleView().getString("titulo_menu_lateral"));
		
		panelContainer = new JPanel(new GridLayout(15, 1, 5, 5));
		this.add(panelContainer);
//		// Borda para o menu lateral
//		Border border = new TitledBorder(new LineBorder(Color.GRAY, 1, true), LocaleUtils.getLocaleView().getString("titulo_menu_lateral"));
		
		setTelaParaControle(telaParaControle);
		
		this.setBorder(border);
		this.setVisible(true);
	}
	
	private void criarBotoesLocacaoDevolucao() {
		btnLocacao = new JButton(LocaleUtils.getLocaleView().getString("menu_locacao"));
		btnLocacao.addActionListener(this);
		btnDevolucao = new JButton("Devolução");
		panelContainer.add(btnLocacao);
		panelContainer.add(btnDevolucao);
		
	}

	private void criarBotoesCrud() {
		btnHome = new JButton("Inicio");
		btnHome.addActionListener(this);
		btnHome.setActionCommand("btnHome");
		panelContainer.add(btnHome);
		panelContainer.add(new JButton(LocaleUtils.getLocaleView().getString("btn_alterar_crud")));
		panelContainer.add(new JButton(LocaleUtils.getLocaleView().getString("btn_cadastrar_crud")));
		panelContainer.add(new JButton(LocaleUtils.getLocaleView().getString("btn_pesquisar_crud")));
		panelContainer.add(new JButton(LocaleUtils.getLocaleView().getString("btn_excluir_crud")));
	}
	
	public void setTelaParaControle(JPanel tela) {
		if (panelContainer.getComponentCount() > 0) {
			panelContainer.removeAll();
		}
		
		if (SystemUtils.isNuloOuVazio(tela)) {
			criarBotoesLocacaoDevolucao();
		} else {
			criarBotoesCrud();
		}
		panelContainer.repaint();
		this.add(panelContainer);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLocacao) {
			new LocacaoGUI();
		} else if (e.getSource() == btnHome) {
			setTelaParaControle(null);
			panelContainer.repaint();
			this.add(panelContainer);
		}
		
	}
}