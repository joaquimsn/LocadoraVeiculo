package br.com.locadora.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.componentes.MenuAcoesCrudLateral;

public class TelaPrincipalGUI extends JFrame {

	// Panel que compoem à estrutura da tela principal
	private JPanel panelFooter;
	private static JPanel panelContainerTela;
	
	// Menus itens
	private JMenuItem miCadastroAgencia;
	private JMenuItem miCadastroFuncionario;
	private JMenuItem miCadastroCliente;
	private JMenuItem miCadastroVeiculo;

	public TelaPrincipalGUI() {
		super(LocaleUtils.getLocaleView().getString("titulo_sys"));
		
		criarTela();
			
		// Abre o Dialog de login para autenticação do usuário e senha
		JDialog dilogLogin = new LoginGUI(this);
	}

	/**
	 * Inicializa todos os componentes da tela principal do sistema
	 * @author Joaquim Neto
	 */
	private void criarTela() {
		
		JButton button = new JButton(LocaleUtils.getLocaleView().getString("titulo_sys"));
		button.setSize(300, 30);
		
		// Cria o menu do cabecalho
		JPanel panelMenuCabecalho = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JMenuBar menuBar = new JMenuBar();
		JMenu menuCadastro = new JMenu(LocaleUtils.getLocaleView().getString("menu_cadastro"));
		JMenu menuLocacao = new JMenu(LocaleUtils.getLocaleView().getString("menu_locacao"));
		JMenu menuRelatorio = new JMenu(LocaleUtils.getLocaleView().getString("menu_relatorio"));
		JMenu menuConfiguracao = new JMenu(LocaleUtils.getLocaleView().getString("menu_configuracao"));
		
		miCadastroAgencia = new JMenuItem(LocaleUtils.getLocaleView().getString("menu_item_cad_agencia"));
		menuCadastro.add(miCadastroAgencia);
		miCadastroCliente = new JMenuItem(LocaleUtils.getLocaleView().getString("menu_item_cad_cliente"));
		menuCadastro.add(miCadastroCliente);
		miCadastroFuncionario = new JMenuItem(LocaleUtils.getLocaleView().getString("menu_item_cad_funcionario"));
		menuCadastro.add(miCadastroFuncionario);
		miCadastroVeiculo = new JMenuItem(LocaleUtils.getLocaleView().getString("menu_item_cad_veiculo"));
		menuCadastro.add(miCadastroVeiculo);
		
		// Estrutura do menu
		menuBar.add(menuCadastro);
		menuBar.add(menuLocacao);
		menuBar.add(menuRelatorio);
		menuBar.add(menuConfiguracao);
		panelMenuCabecalho.add(menuBar);
		
		// Menu lateral esquerdo
		MenuAcoesCrudLateral menuCrudLateral = new MenuAcoesCrudLateral();
		menuCrudLateral.add(button);
		
		// Menu informações do sistema no roda pé
		panelFooter = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		panelFooter.add(new JLabel("Empresa locação"));
		panelFooter.add(new JLabel("Usuário: Joaquim Neto"));
		
		// Configurações do container das telas utilizadas no sistema
		panelContainerTela = new JPanel(null);
		panelContainerTela.setSize(900, 600);
		
		panelContainerTela.add(new JLabel("Teste oi "));
		
		this.setLayout(new BorderLayout());
		this.setSize(1368, 768);
		this.add(panelMenuCabecalho, BorderLayout.NORTH);
		this.add(menuCrudLateral, BorderLayout.WEST);
		this.add(panelContainerTela, BorderLayout.CENTER);
		this.add(panelFooter, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelContainerTela.removeAll();
				panelContainerTela.setSize(800, 600);
				BlocoPanel blocoPanel = new BlocoPanel();
				blocoPanel.setVisible(true);
				panelContainerTela.add(blocoPanel);
				add(panelContainerTela, BorderLayout.CENTER);
				panelContainerTela.repaint();
				
			}
		});
		
	}

}
