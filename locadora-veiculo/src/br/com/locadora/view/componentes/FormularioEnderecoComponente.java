package br.com.locadora.view.componentes;

import java.io.Serializable;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.locadora.utils.locale.LocaleUtils;

public class FormularioEnderecoComponente extends JPanel implements Serializable {
	private static final long serialVersionUID = 2863741403200090086L;

	// Labels
	private JLabel lblLogradouro;
	private JLabel lblNumero;
	private JLabel lblBairro;
	private JLabel lblCep;
	private JLabel lblUf;
	private JLabel lblCidade;
	private JLabel lblTelefone;
	private JLabel lblEmail;
	private JLabel lblSite;

	// Inputs
	private JTextField txtLogradouro;
	private JTextField textNumero;
	private JTextField txtCep;
	private JComboBox cbxUf;
	private JComboBox cbxCidade;
	private JTextField txtEmail;
	private JTextField txtSite;
	private JTextField txtBairro;
	private JTextField txtTelefone;

	/**
	 * Componente formulário enederço contém todos os campos
	 * necessários para representação de um endereço
	 * </br> Os campos presente no formulário são:</br>
	 * <b>
	 * Logradouro</br>
	 * Numero</br>
	 * Bairro</br>
	 * CEP<br>
	 * UF e Cidade<br>
	 * Telefone</br>
	 * E-mail e site
	 * </b>
	 * @author Joaquim Neto
	 */
	public FormularioEnderecoComponente() {
		inicializar();
	}
	
	/**Inicializa todos os componetes da formularioEndereco
	 * @author Joaquim Neto
	 */
	private void inicializar() {
		setLayout(null);
		setSize(800, 170);

		lblLogradouro = new JLabel(LocaleUtils.getLocaleView().getString("lbl_logradouro"));
		lblLogradouro.setBounds(5, 5, 150, 20);
		add(lblLogradouro);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(0, 25, 450, 30);
		txtLogradouro.setColumns(10);
		add(txtLogradouro);
		
		lblNumero = new JLabel(LocaleUtils.getLocaleView().getString("lbl_numero"));
		lblNumero.setBounds(460, 5, 88, 20);
		add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setBounds(455, 25, 125, 30);
		textNumero.setColumns(10);
		add(textNumero);
		
		lblBairro = new JLabel(LocaleUtils.getLocaleView().getString("lbl_bairro"));
		lblBairro.setBounds(590, 5, 125, 20);
		add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(585, 25, 210, 30);
		txtBairro.setColumns(10);
		add(txtBairro);
		
		lblCep = new JLabel(LocaleUtils.getLocaleView().getString("lbl_cep"));
		lblCep.setBounds(5, 60, 141, 20);
		add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setBounds(0, 80, 200, 30);
		txtCep.setColumns(10);
		add(txtCep);
		
		lblUf = new JLabel(LocaleUtils.getLocaleView().getString("lbl_uf"));
		lblUf.setBounds(210, 60, 50, 20);
		add(lblUf);

		cbxUf = new JComboBox();
		cbxUf.setBounds(205, 80, 80, 30);
		add(cbxUf);

		lblCidade = new JLabel(LocaleUtils.getLocaleView().getString("lbl_cidade"));
		lblCidade.setBounds(295, 60, 150, 20);
		add(lblCidade);

		cbxCidade = new JComboBox();
		cbxCidade.setBounds(290, 80, 250, 30);
		add(cbxCidade);

		lblTelefone = new JLabel(LocaleUtils.getLocaleView().getString("lbl_telefone"));
		lblTelefone.setBounds(545, 60, 150, 20);
		add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(545, 80, 250, 30);
		txtTelefone.setColumns(10);
		add(txtTelefone);
		
		lblEmail = new JLabel(LocaleUtils.getLocaleView().getString("lbl_email"));
		lblEmail.setBounds(5, 115, 125, 20);
		add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(0, 135, 300, 30);
		txtEmail.setColumns(10);
		add(txtEmail);

		lblSite = new JLabel(LocaleUtils.getLocaleView().getString("lbl_site"));
		lblSite.setBounds(310, 115, 125, 20);
		add(lblSite);

		txtSite = new JTextField();
		txtSite.setBounds(305, 135, 305, 30);
		txtSite.setColumns(10);
		add(txtSite);
		
		setVisible(true);
	}
}
