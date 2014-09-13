package br.com.locadora.view;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class CadastroVeiculoGUI extends JPanel {
	
	private JLabel lblModelo;
	private JTextField textModelo;
	private JPanel panel;
	private JLabel lblFabricante;
	private JTextField txtFabricante;
	private JLabel lblGrupo;
	private JComboBox cbxGrupo;
	private JLabel lblAcessrios;
	private JTextField txtAcessorios;
	private JLabel lblDataFab;
	private JTextField txtDataFab;
	private JLabel lblImagemVeiculo;
	private JTextField txtDiretorioImagem;
	private JLabel lblChassi;
	private JTextField txtChassi;

	/**
	 * Create the panel.
	 */
	public CadastroVeiculoGUI() {

		inicializar();
	}
	private void inicializar() {
		setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Cadastro Ve\u00EDculo", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblModelo.setBounds(346, 37, 125, 20);
		add(lblModelo);
		
		textModelo = new JTextField();
		textModelo.setBounds(346, 59, 306, 30);
		add(textModelo);
		textModelo.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(27, 45, 300, 200);
		add(panel);
		
		lblFabricante = new JLabel("Fabricante");
		lblFabricante.setBounds(674, 39, 125, 20);
		add(lblFabricante);
		
		txtFabricante = new JTextField();
		txtFabricante.setBounds(664, 59, 179, 30);
		add(txtFabricante);
		txtFabricante.setColumns(10);
		
		lblGrupo = new JLabel("Grupo");
		lblGrupo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblGrupo.setBounds(352, 88, 125, 20);
		add(lblGrupo);
		
		cbxGrupo = new JComboBox();
		cbxGrupo.setBounds(346, 109, 154, 30);
		add(cbxGrupo);
		
		lblAcessrios = new JLabel("Acessórios");
		lblAcessrios.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAcessrios.setBounds(515, 88, 125, 20);
		add(lblAcessrios);
		
		txtAcessorios = new JTextField();
		txtAcessorios.setBounds(512, 111, 140, 30);
		add(txtAcessorios);
		txtAcessorios.setColumns(10);
		
		lblDataFab = new JLabel("Data Fabricação");
		lblDataFab.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDataFab.setBounds(664, 88, 125, 20);
		add(lblDataFab);
		
		txtDataFab = new JTextField();
		txtDataFab.setColumns(10);
		txtDataFab.setBounds(664, 109, 179, 30);
		add(txtDataFab);
		
		lblImagemVeiculo = new JLabel("Imagem do Veículo");
		lblImagemVeiculo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblImagemVeiculo.setBounds(346, 151, 204, 20);
		add(lblImagemVeiculo);
		
		txtDiretorioImagem = new JTextField();
		txtDiretorioImagem.setEditable(false);
		txtDiretorioImagem.setColumns(10);
		txtDiretorioImagem.setBounds(346, 175, 342, 30);
		add(txtDiretorioImagem);
		
		lblChassi = new JLabel("Chassi");
		lblChassi.setVerticalAlignment(SwingConstants.BOTTOM);
		lblChassi.setBounds(27, 267, 125, 20);
		add(lblChassi);
		
		txtChassi = new JTextField();
		txtChassi.setEditable(false);
		txtChassi.setColumns(10);
		txtChassi.setBounds(27, 286, 342, 30);
		add(txtChassi);
	}
}
