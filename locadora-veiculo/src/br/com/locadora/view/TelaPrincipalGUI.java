package br.com.locadora.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.componentes.MenuAcoesLateral;

public class TelaPrincipalGUI extends JFrame implements Serializable {
	private static final long serialVersionUID = 5554966268958184617L;
	
	// Panel que compoem à estrutura da tela principal
	private JPanel panelFooter;
	private static JPanel panelContainerTela;
	
	// Menus itens
	private JMenuItem miCadastroAgencia;
	private JMenuItem miCadastroFuncionario;
	private JMenuItem miCadastroCliente;
	private JMenuItem miCadastroVeiculo;
	
	// Componentes
	private MenuAcoesLateral menuAcoesLateral;

	public TelaPrincipalGUI() {
		super(LocaleUtils.getLocaleView().getString("titulo_tela_principal_sistema"));
		
		criarTela();
			
		// Abre o Dialog de login para autenticação do usuário e senha
		JDialog dilogLogin = new LoginGUI(this);
	}

	/**
	 * Inicializa todos os componentes da tela principal do sistema
	 * @author Joaquim Neto
	 */
	private void criarTela() {
		
		// Borda para os panels
		Border border = new TitledBorder(new LineBorder(Color.GRAY, 1, true));
		
		// Cria o menu do cabecalho
		JPanel panelMenuCabecalho = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelMenuCabecalho.setBorder(border);
		JMenuBar menuBar = new JMenuBar();
		JMenu menuCadastro = new JMenu(LocaleUtils.getLocaleView().getString("menu_cadastro"));
		menuCadastro.setFont(new Font("Sans Serif", Font.BOLD, 14));
		JMenu menuLocacao = new JMenu(LocaleUtils.getLocaleView().getString("menu_locacao"));
		menuLocacao.setFont(new Font("Sans Serif", Font.BOLD, 14));
		JMenu menuRelatorio = new JMenu(LocaleUtils.getLocaleView().getString("menu_relatorio"));
		menuRelatorio.setFont(new Font("Sans Serif", Font.BOLD, 14));
		JMenu menuConfiguracao = new JMenu(LocaleUtils.getLocaleView().getString("menu_configuracao"));
		menuConfiguracao.setFont(new Font("Sans Serif", Font.BOLD, 14));
		
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
		menuAcoesLateral = new MenuAcoesLateral(null);
		
		// Menu informações do sistema no roda pé
		panelFooter = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
		panelFooter.setBorder(border);
		
		panelFooter.add(new JLabel("BJ 	Locadora de veiculos LTDA", JLabel.LEFT));
		panelFooter.add(new JLabel("Agência: 08873 ", JLabel.LEFT));
		panelFooter.add(new JLabel("Cidade: São Paulo - SP ", JLabel.LEFT));
		panelFooter.add(new JLabel("Usuário: Joaquim Neto ", JLabel.LEFT));
		panelFooter.add(new JLabel("Acesso: 90 ", JLabel.RIGHT));
		
		// Configurações do container das telas utilizadas no sistema
		panelContainerTela = new JPanel(null);
		
		// Define a tela default para ser exibida ao abrir o sistema
		panelContainerTela.add(new JLabel("Teste"));
		
		this.setLayout(new BorderLayout());
		this.setSize(1368, 768);
		this.add(panelMenuCabecalho, BorderLayout.NORTH);
		this.add(menuAcoesLateral, BorderLayout.WEST);
		this.add(panelContainerTela, BorderLayout.CENTER);
		this.add(panelFooter, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		miCadastroVeiculo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VeiculoGUI cadastroVeiculoGUI = new VeiculoGUI(LocaleUtils.getLocaleView().getString("titulo_cadastro_veiculo"));
				mudarTelaContainer(cadastroVeiculoGUI);
			}
		});
		
	}
	
	/**
	 * Troca a tela do container de telas pela informada por parâmetro
	 * @param tela Panel da nova tela que será renderizada
	 * @author Joaquim Neto
	 */
	private void mudarTelaContainer(JPanel tela) {
		panelContainerTela.removeAll();
		panelContainerTela.add(tela);
		add(panelContainerTela, BorderLayout.CENTER);
		panelContainerTela.repaint();
		
		// Adiciona a tela ao componente menu lateral
		menuAcoesLateral.setTelaParaControle(tela);
		menuAcoesLateral.repaint();
	}

}
