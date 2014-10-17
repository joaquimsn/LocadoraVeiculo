package br.com.locadora.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.locadora.utils.SystemUtils;
import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.componentes.MenuAcoesLateral;

public class TelaPrincipalGUI extends JFrame implements Serializable, ActionListener{
	private static final long serialVersionUID = 5554966268958184617L;
	
	// Panel que compoem à estrutura da tela principal
	private JPanel panelFooter;
	private static JPanel panelContainerTela;
	private static JPanel panelMenuLateral;
	
	// Menus itens
	private JMenuItem mItemGerenciaAgencia;
	private JMenuItem mItemGerenciaFuncionario;
	private JMenuItem mItemGerenciaCliente;
	private JMenuItem mItemGerenciaVeiculo;
	private JMenuItem mItemLocacao;
	private JMenuItem mItemDevolucao;
	private JMenuItem mItemRelatorio;
	private JMenuItem mItemConfigConexaoDB;
	private JMenuItem mItemLogoff;
	
	// Componentes
	private MenuAcoesLateral menuAcoesLateral;

	public TelaPrincipalGUI() {
		super(LocaleUtils.getLocaleView().getString("titulo_tela_principal_sistema"));
		
		criarTela();
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
		JMenu menuGerencia = new JMenu(LocaleUtils.getLocaleView().getString("menu_gerencia"));
		menuGerencia.setFont(new Font("Sans Serif", Font.BOLD, 14));
		JMenu menuLocacao = new JMenu(LocaleUtils.getLocaleView().getString("menu_locacao"));
		menuLocacao.setFont(new Font("Sans Serif", Font.BOLD, 14));
		JMenu menuRelatorio = new JMenu(LocaleUtils.getLocaleView().getString("menu_relatorio"));
		menuRelatorio.setFont(new Font("Sans Serif", Font.BOLD, 14));
		JMenu menuConfiguracao = new JMenu(LocaleUtils.getLocaleView().getString("menu_configuracao"));
		menuConfiguracao.setFont(new Font("Sans Serif", Font.BOLD, 14));
		
		mItemGerenciaAgencia = new JMenuItem(LocaleUtils.getLocaleView().getString("menu_item_gen_agencia"));
		menuGerencia.add(mItemGerenciaAgencia);
		mItemGerenciaCliente = new JMenuItem(LocaleUtils.getLocaleView().getString("menu_item_gen_cliente"));
		menuGerencia.add(mItemGerenciaCliente);
		mItemGerenciaFuncionario = new JMenuItem(LocaleUtils.getLocaleView().getString("menu_item_gen_funcionario"));
		menuGerencia.add(mItemGerenciaFuncionario);
		mItemGerenciaVeiculo = new JMenuItem(LocaleUtils.getLocaleView().getString("menu_item_gen_veiculo"));
		menuGerencia.add(mItemGerenciaVeiculo);
		
		// Bloqueia os menus para nivel ATENDENTE
		mItemGerenciaAgencia.setEnabled(SystemUtils.isSupervisor());
		mItemGerenciaFuncionario.setEnabled(SystemUtils.isSupervisor());
		menuRelatorio.setEnabled(SystemUtils.isSupervisor());
		menuConfiguracao.setEnabled(SystemUtils.isSupervisor());
		
		mItemLocacao = new JMenuItem(LocaleUtils.getLocaleView().getString("menu_item_locacao"));
		menuLocacao.add(mItemLocacao);
		mItemDevolucao = new JMenuItem(LocaleUtils.getLocaleView().getString("menu_item_devolucao"));
		menuLocacao.add(mItemDevolucao);
		
		mItemRelatorio = new JMenuItem(LocaleUtils.getLocaleView().getString("menu_item_relatorio"));
		menuRelatorio.add(mItemRelatorio);
		
		mItemConfigConexaoDB = new JMenuItem(LocaleUtils.getLocaleView().getString("menu_item_conexao"));
		menuConfiguracao.add(mItemConfigConexaoDB);
		
		mItemLogoff = new JMenuItem(LocaleUtils.getLocaleView().getString("menu_item_logoff"));
		
		// Estrutura do menu
		menuBar.add(menuGerencia);
		menuBar.add(menuLocacao);
		menuBar.add(menuRelatorio);
		menuBar.add(menuConfiguracao);
		menuBar.add(mItemLogoff);
		panelMenuCabecalho.add(menuBar);
		
		// Menu lateral esquerdo
		panelMenuLateral = new JPanel(new FlowLayout());
		panelMenuLateral.setSize(150, 500);
		menuAcoesLateral = new MenuAcoesLateral(null, this);
		panelMenuLateral.add(menuAcoesLateral);
		
		// Menu informações do sistema no roda pé
		panelFooter = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
		panelFooter.setBorder(border);
		
		panelFooter.add(new JLabel("<html><b>Empresa:</b><html> " + SystemUtils.getAgenciaSelecionado().getRazaoSocial(), JLabel.LEFT));
		panelFooter.add(new JLabel("<html><b>Agência:</b><html> " + SystemUtils.getAgenciaSelecionado().getIdAgencia(), JLabel.LEFT));
		panelFooter.add(new JLabel("<html><b>Cidade:</b><html> " + SystemUtils.getAgenciaSelecionado().getCidade(), JLabel.LEFT));
		panelFooter.add(new JLabel("<html><b>Funcionário:</b><html> " + SystemUtils.getFuncionarioLogado().getNome(), JLabel.LEFT));
		panelFooter.add(new JLabel("<html><b>Usuário:</b><html> " + SystemUtils.getFuncionarioLogado().getUsuario(), JLabel.RIGHT));
		
		// Configurações do container das telas utilizadas no sistema
		panelContainerTela = new JPanel(null);
		
		// Define a tela default para ser exibida ao abrir o sistema
//		panelContainerTela.add();
		
		this.setLayout(new BorderLayout());
		this.setSize(1368, 768);
		this.add(panelMenuCabecalho, BorderLayout.NORTH);
		this.add(panelMenuLateral, BorderLayout.WEST);
		this.add(panelContainerTela, BorderLayout.CENTER);
		this.add(panelFooter, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		mItemGerenciaVeiculo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VeiculoGUI veiculoGUI = new VeiculoGUI(LocaleUtils.getLocaleView().getString("titulo_cadastro_veiculo"));
				mudarTelaContainer(veiculoGUI);
			}
		});
		
		mItemGerenciaAgencia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AgenciaGUI agenciaGUI = new AgenciaGUI(LocaleUtils.getLocaleView().getString("titulo_cadastro_agencia"));
				mudarTelaContainer(agenciaGUI);
			}
		});
		
		mItemGerenciaFuncionario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FuncionarioGUI funcionarioGUI = new FuncionarioGUI(LocaleUtils.getLocaleView().getString("titulo_cadastro_funcionario"));
				mudarTelaContainer(funcionarioGUI);
			}
		});
		
		mItemGerenciaCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClienteGUI clienteGUI = new ClienteGUI(LocaleUtils.getLocaleView().getString("titulo_cadastro_cliente"));
				mudarTelaContainer(clienteGUI);
			}
		});
		
		mItemLocacao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LocacaoGUI();
			}
		});
		
		mItemDevolucao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DevolucaoGUI();
			}
		});
		
		mItemRelatorio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RelatorioGUI relatorioGUI = new RelatorioGUI();
				mudarTelaContainer(relatorioGUI);
			}
		});
		
		mItemConfigConexaoDB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ConfiguracaoConexaoGUI();
			}
		});
		
		// Pega a instacia atual do frame principal do sistema para fazer o logoff
		final JFrame frm = this;
		mItemLogoff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LogoffGUI(frm);
			}
		});
		
	}
	
	/**
	 * Troca a tela do container de telas pela informada por parâmetro
	 * @param tela Panel da nova tela que será renderizada
	 * @author Joaquim Neto
	 */
	public void mudarTelaContainer(JPanel tela) {
		panelContainerTela.removeAll();
		panelContainerTela.add(tela);
		add(panelContainerTela, BorderLayout.CENTER);
		panelContainerTela.repaint();
		
		// Adiciona a tela ao componente menu lateral
		panelMenuLateral.removeAll();
		menuAcoesLateral = new MenuAcoesLateral(tela, this);
		panelMenuLateral.add(menuAcoesLateral);
		add(panelMenuLateral, BorderLayout.WEST);
		panelMenuLateral.repaint();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
