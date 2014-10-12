package br.com.locadora.view.componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.locadora.controller.EnderecoControl;
import br.com.locadora.model.vo.Endereco;
import br.com.locadora.utils.Constants;
import br.com.locadora.utils.SystemUtils;
import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.Mask;

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
	private JTextField txtNumero;
	private JFormattedTextField txtCep;
	private JComboBox cbxUf;
	private JComboBox cbxCidade;
	private JTextField txtEmail;
	private JTextField txtSite;
	private JTextField txtBairro;
	private JFormattedTextField txtTelefone;
	
	private String[] cidades;

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
		cidades = new String[10];
		inicializar();
	}
	
	/**Inicializa todos os componetes da formularioEndereco
	 * @author Joaquim Neto
	 */
	private void inicializar() {
		setLayout(null);
		
		// InputVerifier para validações genéricas dos campos
		InputSoNumeros soNumeros = new InputSoNumeros();
		InputSoTextoNumeros soTextoNumeros = new InputSoTextoNumeros();
		InputSoTexto soTexto = new InputSoTexto();
		
		lblCep = new JLabel(LocaleUtils.getLocaleView().getString("lbl_cep"));
		lblCep.setBounds(5, 5, 150, 20);
		add(lblCep);
		
		txtCep = new JFormattedTextField(Mask.maskCep()); // Adiciona a mascara de CEP
		txtCep.setBounds(0, 25, 450, 30);
		add(txtCep);
		
		lblUf = new JLabel(LocaleUtils.getLocaleView().getString("lbl_uf"));
		lblUf.setBounds(460, 5, 88, 20);
		add(lblUf);
		
		cbxUf = new JComboBox(Constants.UF.toArray(new String[0]));
		cbxUf.setBounds(455, 25, 125, 30);
		add(cbxUf);

		lblCidade = new JLabel(LocaleUtils.getLocaleView().getString("lbl_cidade"));
		lblCidade.setBounds(590, 5, 125, 20);
		add(lblCidade);
		
		cbxCidade = new JComboBox(cidades);
		cbxCidade.setBounds(585, 25, 210, 30);
		add(cbxCidade);
		preencherComboCidadePorUf((String) cbxUf.getSelectedItem()); // Preenche o combo de cidades
		
		lblLogradouro = new JLabel(LocaleUtils.getLocaleView().getString("lbl_logradouro"));
		lblLogradouro.setBounds(5, 60, 141, 20);
		add(lblLogradouro);
		
		txtLogradouro = new JTextField(10);
		txtLogradouro.setInputVerifier(soTextoNumeros); // Adiciona a validação soTextoNumeros
		txtLogradouro.setBounds(0, 80, 200, 30);
		add(txtLogradouro);
		
		lblNumero = new JLabel(LocaleUtils.getLocaleView().getString("lbl_numero"));
		lblNumero.setBounds(210, 60, 50, 20);
		add(lblNumero);
		
		txtNumero = new JTextField(10);
		txtNumero.setInputVerifier(soNumeros);// Adiciona a validação soNumeros
		txtNumero.setBounds(205, 80, 80, 30);
		add(txtNumero);
		
		lblBairro = new JLabel(LocaleUtils.getLocaleView().getString("lbl_bairro"));
		lblBairro.setBounds(295, 60, 150, 20);
		add(lblBairro);
		
		txtBairro = new JTextField(10);
		txtBairro.setInputVerifier(soTexto);// Adiciona a validação soTexto
		txtBairro.setBounds(290, 80, 250, 30);
		add(txtBairro);
		
		lblTelefone = new JLabel(LocaleUtils.getLocaleView().getString("lbl_telefone"));
		lblTelefone.setBounds(545, 60, 150, 20);
		add(lblTelefone);
		
		txtTelefone = new JFormattedTextField(Mask.maskTelefone());
		txtTelefone.setBounds(545, 80, 250, 30);
		add(txtTelefone);
		
		lblEmail = new JLabel(LocaleUtils.getLocaleView().getString("lbl_email"));
		lblEmail.setBounds(5, 115, 125, 20);
		add(lblEmail);

		txtEmail = new JTextField(10);
		txtEmail.setBounds(0, 135, 300, 30);
		add(txtEmail);

		lblSite = new JLabel(LocaleUtils.getLocaleView().getString("lbl_site"));
		lblSite.setBounds(310, 115, 125, 20);
		add(lblSite);

		txtSite = new JTextField(10);
		txtSite.setBounds(305, 135, 305, 30);
		add(txtSite);
		
		setSize(800, 170);
		setVisible(true);
		
		/*
		 * EVENTOS
		 */
		// Preenche o endereço automaticamente pelo cep informado, se disponível
		txtCep.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent focus) {
				if (focus.getID() == FocusEvent.FOCUS_LOST && SystemUtils.isNuloOuVazio(txtLogradouro.getText())
						&& !SystemUtils.isNuloOuVazio(txtCep) && !txtCep.getText().contains(" ")) {
					EnderecoControl enderecoControl = new EnderecoControl();
					preencherEndereco(enderecoControl.buscarEnderecoPorCep(txtCep.getText()));
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stubobjeto
				
			}
		});
		
		// Preenche o combo de cidade ao selecionar uma UF
		cbxUf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				preencherComboCidadePorUf((String) cbxUf.getSelectedItem());
			}
		});
	}
	
	/**
	 * Retornar um objeto endereço
	 * @author Joaquim Neto
	 * @return Objeto Endereço
	 */
	public Endereco getEndereco() {
		Endereco endereco = new Endereco();
		
		// Atribui os dados preenchido pelo usuário ao objeto endereço
		endereco.setBairro(txtBairro.getText());
		endereco.setCep(txtCep.getText());
		endereco.setCidade((String) cbxCidade.getSelectedItem());
		endereco.setEmail(txtEmail.getText());
		endereco.setLogradouro(txtLogradouro.getText());

		try {
			int numero = Integer.parseInt(txtNumero.getText());
			endereco.setNumero(numero);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		endereco.setSite(txtSite.getText());
		endereco.setTelefone(txtTelefone.getText());
		endereco.setUf((String) cbxUf.getSelectedItem());
		
		return endereco;
	}
	
	/**
	 * Preenche os campos do formularioEndereco com os dados do
	 * objeto Endereço passado por parâmetro
	 * @author Joaquim Neto
	 * @param endereco Objeto Endereço
	 */
	public void preencherEndereco(Endereco endereco) {
		if (!SystemUtils.isNuloOuVazio(endereco)) {
			txtLogradouro.setText(endereco.getLogradouro());
			txtNumero.setText(String.valueOf(endereco.getNumero()));
			txtBairro.setText(endereco.getBairro());
			txtCep.setText(endereco.getCep());
			txtTelefone.setText(endereco.getTelefone());
			
			cbxCidade.setSelectedItem(endereco.getUf());
			// Preenche o combo de cidade
			preencherComboCidadePorUf(endereco.getUf());
			cbxCidade.setSelectedItem(endereco.getCidade());
		}
	}
	
	/**
	 * Limpa os campos do componente endereço
	 * @author Joaquim Neto
	 */
	public void limparCampos() {
		txtBairro.setText("");
		txtCep.setText("");
		txtEmail.setText("");
		txtLogradouro.setText("");
		txtNumero.setText("");
		txtSite.setText("");
		txtTelefone.setText("");
	}
	
	private void preencherComboCidadePorUf(String uf) {
		cbxCidade.removeAllItems();
		EnderecoControl enderecoControl = new EnderecoControl();
		cidades = enderecoControl.buscarCidadePorUf(uf).toArray(new String[0]);
		for (String cidade : cidades) {
			cbxCidade.addItem(cidade);
		}
	}
}
