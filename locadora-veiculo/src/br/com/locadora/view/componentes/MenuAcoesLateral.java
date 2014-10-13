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
import br.com.locadora.view.AgenciaGUI;
import br.com.locadora.view.ClienteGUI;
import br.com.locadora.view.ConsultaAgenciaGUI;
import br.com.locadora.view.ConsultaClienteGUI;
import br.com.locadora.view.ConsultaFuncionarioGUI;
import br.com.locadora.view.DevolucaoGUI;
import br.com.locadora.view.FuncionarioGUI;
import br.com.locadora.view.LocacaoGUI;
import br.com.locadora.view.TelaPrincipalGUI;

public class MenuAcoesLateral extends JPanel implements Serializable, ActionListener{
	private static final long serialVersionUID = -3381377661549796928L;
	
	private JPanel telaParaControle;
	
	private JButton btnLocacao;
	private JButton btnDevolucao;
	private JButton btnCadastrar;
	private JButton btnPesquisar;
	
	private static TelaPrincipalGUI telaPrincipalGUI;
	
	private static JPanel panelContainer;
	
	public MenuAcoesLateral() {
		inicializar();
	}
	
	public MenuAcoesLateral(JPanel tela, TelaPrincipalGUI telaPrincipalGUI) {
		telaParaControle = tela;
		this.telaPrincipalGUI = telaPrincipalGUI;
		
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
		btnDevolucao = new JButton(LocaleUtils.getLocaleView().getString("btn_devolucao"));
		btnDevolucao.addActionListener(this);
		panelContainer.add(btnLocacao);
		panelContainer.add(btnDevolucao);
		
	}

	private void criarBotoesCrud() {
		
		btnPesquisar = new JButton(LocaleUtils.getLocaleView().getString("btn_pesquisar"));
		btnPesquisar.addActionListener(this);
		
		btnCadastrar = new JButton(LocaleUtils.getLocaleView().getString("btn_cadastrar"));
		btnCadastrar.addActionListener(this);
		
		panelContainer.add(btnCadastrar);
		panelContainer.add(btnPesquisar);
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
		} else if (e.getSource() == btnPesquisar) {
			// Tela pesquisa cliente
			if (telaParaControle.getClass() == ClienteGUI.class) {
				telaPrincipalGUI.mudarTelaContainer(new ConsultaClienteGUI());
			
			// Tela pesquisa agência	
			} else if (telaParaControle.getClass() == AgenciaGUI.class) {
				telaPrincipalGUI.mudarTelaContainer(new ConsultaAgenciaGUI());
			
			// Tela pesquisa funcionário
			} else if (telaParaControle.getClass() == FuncionarioGUI.class) {
				telaPrincipalGUI.mudarTelaContainer(new ConsultaFuncionarioGUI());
			} 
			
		} else if (e.getSource() == btnCadastrar) {
			// Tela cadastro cliente
			if (telaParaControle.getClass() == ConsultaClienteGUI.class) {
				telaPrincipalGUI.mudarTelaContainer(new ClienteGUI(LocaleUtils.getLocaleView().getString("titulo_cadastro_cliente")));
			
			// Tela cadastro agência	
			} else if (telaParaControle.getClass() == ConsultaAgenciaGUI.class) {
				telaPrincipalGUI.mudarTelaContainer(new AgenciaGUI(LocaleUtils.getLocaleView().getString("titulo_cadastro_agencia")));
			
			// Tela cadastro agência	
			} else if (telaParaControle.getClass() == ConsultaFuncionarioGUI.class) {
				telaPrincipalGUI.mudarTelaContainer(new FuncionarioGUI(LocaleUtils.getLocaleView().getString("titulo_cadastro_funcionario")));
			}
		} else if (e.getSource() == btnDevolucao) {
			new DevolucaoGUI();
		}
		
	}
}
