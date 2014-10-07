package br.com.locadora.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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

import br.com.locadora.model.enums.ParametroPesquisaAgenciaEnum;
import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.componentes.InputSoTextoNumeros;

public class ConsultaAgenciaGUI extends JPanel implements ActionListener{
	private static final long serialVersionUID = 65619500338126805L;
	
	// Lables
	private JLabel lblParametroPesquisa;
	
	// Inputs
	private JComboBox cbxParametroPesquisa;
	private JTextField txtPesquisa;
	
	// Buttons
	private JButton btnPesquisar;
	
	// Panles
	private JPanel panelTableResultado;
	private JPanel panelParametroPesquisa;
	private DefaultTableModel defaultTableModel;
	private JTable table;

	public ConsultaAgenciaGUI() {
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
		cbxParametroPesquisa.setBounds(5, 25, 200, 30);
		panelParametroPesquisa.add(cbxParametroPesquisa);
		
		// Validação para campo soTextoNumero
		InputSoTextoNumeros soTextoNumeros = new InputSoTextoNumeros();
		txtPesquisa = new JTextField(10);
		txtPesquisa.setInputVerifier(soTextoNumeros);
		txtPesquisa.setBounds(215, 25, 300, 30);
		panelParametroPesquisa.add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		btnPesquisar = new JButton(LocaleUtils.getLocaleView().getString("btn_pesquisar"));
		btnPesquisar.setBounds(525, 25, 100, 30);
		panelParametroPesquisa.add(btnPesquisar);
		
		panelTableResultado = new JPanel();
		panelTableResultado.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelTableResultado.setBounds(20, 90, 820, 490);
		add(panelTableResultado);
		panelTableResultado.setLayout(new BorderLayout(0, 0));
		
		// Adiciona a JTable ao panelJTableResultado
		panelTableResultado.add(getScrollPane(), BorderLayout.CENTER);
		
		this.setBounds(15, 10, 860, 600);
		setVisible(true);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
