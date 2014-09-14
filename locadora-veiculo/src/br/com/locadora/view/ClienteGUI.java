package br.com.locadora.view;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.componentes.BotoesCrudComponente;
import br.com.locadora.view.componentes.FormularioEnderecoComponente;

public class ClienteGUI extends JPanel {

	// Labels
	private JLabel lblNome;
	private JLabel lblGenero;
	private JLabel lblDataNascimento;
	private JLabel lblCpf;
	private JLabel lblRg;
	private JLabel lblEstadoEmissor;
	private JLabel lblCnh;
	private JTextField txtVencimentoCnh;
	
	// Inputs
	private JTextField txtNome;
	private JComboBox cbxGenero;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtDataNascimento;
	private JTextField txtEstadoEmissor;
	private JTextField txtCnh;
	private JLabel lblVencimentoCnh;
	
	private String tituloTela;
	
	public ClienteGUI() {
		inicializar();
	}
	
	/**
	 * Cria o panel cliente com um titulo passado por parâmetro
	 * @param tituloPanel Titulo do panel 
	 * @author Joaquim Neto
	 */
	public ClienteGUI(String tituloTela) {
		this.tituloTela = tituloTela;
		inicializar();
	}
	
	/**Inicializa todos os componetes da tela
	 * @author Joaquim Neto
	 */
	private void inicializar() {
		setLayout(null);
		setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1, true), tituloTela, TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		
		lblNome = new JLabel(LocaleUtils.getLocaleView().getString("lbl_nome"));
		lblNome.setBounds(35, 40, 125, 20);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(30, 60, 400, 30);
		add(txtNome);
		txtNome.setColumns(10);
		
		lblGenero = new JLabel(LocaleUtils.getLocaleView().getString("lbl_genero"));
		lblGenero.setBounds(440, 40, 125, 20);
		add(lblGenero);
		
		cbxGenero = new JComboBox();
		cbxGenero.setBounds(435, 60, 190, 30);
		add(cbxGenero);
		
		lblDataNascimento = new JLabel(LocaleUtils.getLocaleView().getString("lbl_data_nasc"));
		lblDataNascimento.setBounds(635, 40, 125, 20);
		add(lblDataNascimento);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(630, 60, 200, 30);
		add(txtDataNascimento);
		
		lblCpf = new JLabel(LocaleUtils.getLocaleView().getString("lbl_cpf"));
		lblCpf.setBounds(35, 90, 125, 20);
		add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(30, 110, 200, 30);
		add(txtCpf);
		
		lblRg = new JLabel(LocaleUtils.getLocaleView().getString("lbl_rg"));
		lblRg.setBounds(240, 90, 125, 20);
		add(lblRg);
		
		lblCnh = new JLabel(LocaleUtils.getLocaleView().getString("lbl_cnh"));
		lblCnh.setBounds(440, 90, 125, 20);
		add(lblCnh);
		
		txtCnh = new JTextField();
		txtCnh.setColumns(10);
		txtCnh.setBounds(435, 111, 195, 30);
		add(txtCnh);
		
		txtRg = new JTextField();
		txtRg.setColumns(10);
		txtRg.setBounds(235, 110, 195, 30);
		add(txtRg);
		
		lblEstadoEmissor = new JLabel(LocaleUtils.getLocaleView().getString("lbl_estado_emissor"));
		lblEstadoEmissor.setBounds(35, 145, 125, 20);
		add(lblEstadoEmissor);
		
		txtEstadoEmissor = new JTextField();
		txtEstadoEmissor.setColumns(10);
		txtEstadoEmissor.setBounds(30, 165, 150, 30);
		add(txtEstadoEmissor);
		
		lblVencimentoCnh = new JLabel(LocaleUtils.getLocaleView().getString("lbl_data_vencimento"));
		lblVencimentoCnh.setBounds(640, 90, 125, 20);
		add(lblVencimentoCnh);
		
		txtVencimentoCnh = new JTextField();
		txtVencimentoCnh.setColumns(10);
		txtVencimentoCnh.setBounds(635, 110, 200, 30);
		add(txtVencimentoCnh);
		
		// Componete formulário para endereço
		FormularioEnderecoComponente formularioEndereco = new FormularioEnderecoComponente();
		formularioEndereco.setBounds(30, 200, 800, 170);
		add(formularioEndereco);
		
		// Componente botões
		BotoesCrudComponente botoesCrudComponente = new BotoesCrudComponente();
		botoesCrudComponente.setBounds(623, 408, 200, 45);
		add(botoesCrudComponente);
		
		this.setBounds(15, 10, 859, 500);
		this.setVisible(true);
	}
}
