package br.com.locadora.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import br.com.locadora.controller.AgenciaControl;
import br.com.locadora.model.entity.Agencia;
import br.com.locadora.model.enums.ParametroPesquisaAgenciaEnum;
import br.com.locadora.utils.SystemUtils;
import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.componentes.InputSoTextoNumeros;

public class ConsultaAgenciaGUI extends JPanel {
	private static final long serialVersionUID = 65619500338126805L;
	
	// Lables
	private JLabel lblParametroPesquisa;
	
	// Inputs
	private JComboBox cbxParametroPesquisa;
	private JTextField txtPesquisa;
	
	// Buttons
	private JButton btnPesquisar;
	private JButton btnExcluir;
	private JButton btnAlterar;
	
	// Panles
	private JPanel panelTableResultado;
	private JPanel panelParametroPesquisa;
	private DefaultTableModel defaultTableModel;
	private JTable table;
	
	// Atributos da regra de negócio
	private List<Agencia> listaAgencia;
	private AgenciaControl agenciaControl;

	public ConsultaAgenciaGUI() {
		agenciaControl = new AgenciaControl();
		listaAgencia = new ArrayList<Agencia>();
		
		inicializar();
	}
	
	/**Inicializa todos os componetes da tela consulta de cliente
	 * @author Joaquim Neto
	 */
	private void inicializar() {
		setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1, true), 
				LocaleUtils.getLocaleView().getString("lbl_pesquisar_agencia"), TitledBorder.LEADING, 
				TitledBorder.TOP, null, Color.BLUE));
		setLayout(null);
		
		panelParametroPesquisa = new JPanel();
		panelParametroPesquisa.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelParametroPesquisa.setBounds(20, 20, 820, 62);
		add(panelParametroPesquisa);
		panelParametroPesquisa.setLayout(null);
		lblParametroPesquisa = new JLabel(LocaleUtils.getLocaleView().getString("lbl_parametro_pesquisa"));
		lblParametroPesquisa.setBounds(10, 5, 200, 20);
		panelParametroPesquisa.add(lblParametroPesquisa);
		
		cbxParametroPesquisa = new JComboBox(ParametroPesquisaAgenciaEnum.getDisplayList().toArray());
		cbxParametroPesquisa.setBounds(5, 25, 180, 30);
		panelParametroPesquisa.add(cbxParametroPesquisa);
		
		// Validação para campo soTextoNumero
		InputSoTextoNumeros soTextoNumeros = new InputSoTextoNumeros();
		txtPesquisa = new JTextField(10);
		txtPesquisa.setInputVerifier(soTextoNumeros);
		txtPesquisa.setBounds(195, 25, 300, 30);
		panelParametroPesquisa.add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		btnPesquisar = new JButton(LocaleUtils.getLocaleView().getString("btn_pesquisar"));
		btnPesquisar.setBounds(505, 25, 100, 30);
		panelParametroPesquisa.add(btnPesquisar);
		
		btnExcluir = new JButton(LocaleUtils.getLocaleView().getString("btn_excluir"));
		btnExcluir.setBounds(610, 25, 100, 30);
		panelParametroPesquisa.add(btnExcluir);
		
		btnAlterar = new JButton(LocaleUtils.getLocaleView().getString("btn_alterar"));
		btnAlterar.setBounds(715, 25, 100, 30);
		panelParametroPesquisa.add(btnAlterar);
		
		panelTableResultado = new JPanel();
		panelTableResultado.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelTableResultado.setBounds(20, 90, 820, 490);
		add(panelTableResultado);
		panelTableResultado.setLayout(new BorderLayout(0, 0));
		
		// Adiciona a JTable ao panelJTableResultado
		panelTableResultado.add(getScrollPane(), BorderLayout.CENTER);
		
		
		// Desabilita os botões de alterar e excluir caso não exista nenhuma agência selecionada
//		btnAlterar.setEnabled(isAgenciaSelecionada());
//		btnExcluir.setEnabled(isAgenciaSelecionada());
		
		this.setBounds(15, 10, 860, 600);
		setVisible(true);
		
		/*
		 * EVENTOS DOS BOTÕES
		 */
		btnPesquisar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int parametroSelecionado = ParametroPesquisaAgenciaEnum.getValueByDisplay((String) cbxParametroPesquisa.getSelectedItem());
				
				if (!(SystemUtils.isNuloOuVazio(txtPesquisa.getText()) && parametroSelecionado != ParametroPesquisaAgenciaEnum.SELECIONA_TODOS.getValue())) {
					pesquisar();
				} else {
					JOptionPane.showMessageDialog(txtPesquisa, LocaleUtils.getLocaleMessages().getString("falha_pesquisabranco"));
				}
			}
		});
		
		// Ação do botão Aleterar
		btnAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AgenciaGUI agenciaGUI = new AgenciaGUI(LocaleUtils.getLocaleView().getString("titulo_alterar_agencia"));
				
				if (!isAgenciaSelecionada()) {
					JOptionPane.showMessageDialog(table, LocaleUtils.getLocaleMessages().getString("falha_pesquisabranco"));
					return;
				}
				
				agenciaGUI.preencherCampos(getAgenciaSelecionado());
				
				ModalAlterarcaoGUI modalAlterarcaoGUI = new ModalAlterarcaoGUI(agenciaGUI, LocaleUtils.getLocaleView().getString("titulo_alterar_agencia"));
				modalAlterarcaoGUI.setLocationRelativeTo(table);
				modalAlterarcaoGUI.setModal(true);
				limparTabela();
				
			}
		});
		
		// Acão do botão excluir
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isAgenciaSelecionada()) {
					JOptionPane.showMessageDialog(table, LocaleUtils.getLocaleMessages().getString("falha_pesquisabranco"));
					return;
				}
				Agencia agencia = getAgenciaSelecionado();
				agencia.setAtivo(false);
				
				if (agenciaControl.salvarOuAlterar(agencia)) {
					JOptionPane.showMessageDialog(table, LocaleUtils.getLocaleMessages().getString("sucesso_agencia_desativada"));
					limparTabela();
				} else {
					JOptionPane.showMessageDialog(table, LocaleUtils.getLocaleMessages().getString("falha_agencia_desativada"));
				}
				
			}
		});
	}
	

	/**
	 * Cria a estrutura da tabela
	 * @author Joaquim Neto
	 * @return JTable
	 */
	public JTable getTable() {
		table = new JTable();
		table.setModel(getDefaultTabelModel());
		table.setVisible(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.LEFT);

		DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
		centerRenderer1.setHorizontalAlignment(JLabel.CENTER);

		TableColumn col = null;

		col = table.getColumnModel().getColumn(0);
		col.setPreferredWidth(60);
		col.setCellRenderer(centerRenderer1);
		
		col = table.getColumnModel().getColumn(1);
		col.setPreferredWidth(150);
		col.setCellRenderer(centerRenderer);

		col = table.getColumnModel().getColumn(2);
		col.setPreferredWidth(350);
		col.setCellRenderer(centerRenderer);

		col = table.getColumnModel().getColumn(3);
		col.setPreferredWidth(250);
		col.setCellRenderer(centerRenderer);

		return table;
	}

	/**
	 * Cria o scroll para a JTable
	 * @author Joaquim Neto
	 * @return ScrollPane contendo a JTable
	 */
	public JScrollPane getScrollPane() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 800, 450);
		// Adiciona a JTable ao scroll
		scrollPane.setViewportView(getTable());

		return scrollPane;
	}

	/**
	 * Define as conlunas da JTable
	 * @return implementação default da JTable
	 */
	public DefaultTableModel getDefaultTabelModel() {
		defaultTableModel = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		defaultTableModel.addColumn(LocaleUtils.getLocaleView().getString("col_codigo"));
		defaultTableModel.addColumn(LocaleUtils.getLocaleView().getString("lbl_cnpj"));
		defaultTableModel.addColumn(LocaleUtils.getLocaleView().getString("lbl_razao_social"));
		defaultTableModel.addColumn(LocaleUtils.getLocaleView().getString("lbl_responsavel"));

		return defaultTableModel;
	}
	
	/**
	 * Pesquisa as agências na base que correspodem ao 
	 * Parâmetro de pesquisa selecionado e valor da pesquisa
	 * @author Joaquim Neto
	 */
	public void pesquisar() {
		limparTabela();
		
		int parametro = ParametroPesquisaAgenciaEnum.getValueByDisplay((String) cbxParametroPesquisa.getSelectedItem());
		
		listaAgencia = agenciaControl.buscarPorCondicao(parametro, txtPesquisa.getText());
		
		// Preenche as linhas da tabela
		for (Agencia agencia : listaAgencia) {
			defaultTableModel.addRow(new Object[] {agencia.getIdAgencia(), agencia.getCnpj(), agencia.getRazaoSocial(),
					agencia.getResponsavel()});
		}
		
		if (!SystemUtils.isNuloOuVazio(listaAgencia)) {
			btnAlterar.repaint();
			btnExcluir.repaint();
			repaint();
		}
	}
	
	private void limparTabela() {
		// Verifica se já foi realizada uma pesquisa
		if (!SystemUtils.isNuloOuVazio(listaAgencia) && defaultTableModel.getRowCount() > 0) {
			// Remove as linhas da pesquisa anterior
			for (int i = 0; i < listaAgencia.size(); i++) {
				defaultTableModel.removeRow(0);
			}
		}
		
	}

	/**
	 * Retorna a agência selecionado
	 * @author Joaquim Neto
	 * @return Objeto Agencia
	 */
	private Agencia getAgenciaSelecionado() {
		Agencia agencia = listaAgencia.get(table.getSelectedRow());
		
		return agencia;
	}
	
	/**
	 * Verifica se exisite linha selecionada
	 * @author Joaquim Neto
	 * @return <b>true</b> Se existir agência selecionada
	 */
	private boolean isAgenciaSelecionada() {
		if (table.getSelectedRow() == -1) {
			return false;
		}
		
		return true;
	}
}
