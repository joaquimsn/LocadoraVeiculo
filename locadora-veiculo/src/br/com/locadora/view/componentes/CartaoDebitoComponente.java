package br.com.locadora.view.componentes;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.locadora.utils.locale.LocaleUtils;

import com.toedter.calendar.JDateChooser;

public class CartaoDebitoComponente extends JPanel {
	
	// Labels
	private JLabel lblNomeDoTitular;
	private JLabel lblCpf;
	private JLabel lblTelefone;
	private JLabel lblBanco;
	private JLabel lblAgenciaBancaria;
	
	// Inputs
	private JTextField txtNomeTitular;
	private JTextField txtCpfTitular;
	private JTextField txtTelefone;
	private JTextField txtBanco;
	private JButton btnFazerPagamento;
	
	private JPanel panelPagamento;
	private JTextField txtAgenciaBancaria;
	private JLabel lblContaCorrente;
	private JTextField textField;
	
	/**
	 * Componente cartão de debito contém todos os campos
	 * necessários fazer um pagamento por cartão
	 * @author Joaquim Neto
	 */
	public CartaoDebitoComponente() {
		inicializar();
	}
	
	/**Inicializa todos os componetes
	 * @author Joaquim Neto
	 */
	private void inicializar() {
		setLayout(null);
		
		panelPagamento = new JPanel();
		panelPagamento.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1, true), LocaleUtils.getLocaleView().getString("titulo_pagamento"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panelPagamento.setLayout(null);
		panelPagamento.setBounds(0, 5, 617, 238);
		add(panelPagamento);
		
		lblNomeDoTitular = new JLabel(LocaleUtils.getLocaleView().getString("lbl_nome_titular"));
		lblNomeDoTitular.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNomeDoTitular.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDoTitular.setBounds(10, 20, 150, 20);
		panelPagamento.add(lblNomeDoTitular);
		
		txtNomeTitular = new JTextField(10);;
		txtNomeTitular.setBounds(165, 20, 440, 30);
		panelPagamento.add(txtNomeTitular);
		
		lblCpf = new JLabel(LocaleUtils.getLocaleView().getString("lbl_cpf"));
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(10, 60, 150, 20);
		panelPagamento.add(lblCpf);
		
		txtCpfTitular = new JTextField(10);;
		txtCpfTitular.setBounds(165, 55, 200, 30);
		panelPagamento.add(txtCpfTitular);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setBounds(10, 90, 150, 20);
		panelPagamento.add(lblTelefone);
		
		txtTelefone = new JTextField(10);;
		txtTelefone.setBounds(165, 90, 200, 30);
		panelPagamento.add(txtTelefone);
		
		lblBanco = new JLabel("Banco");
		lblBanco.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBanco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBanco.setBounds(10, 130, 61, 20);
		panelPagamento.add(lblBanco);
		
		txtBanco = new JTextField(10);;
		txtBanco.setBounds(79, 125, 174, 30);
		panelPagamento.add(txtBanco);
		
		lblAgenciaBancaria = new JLabel("Agência");
		lblAgenciaBancaria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAgenciaBancaria.setBounds(259, 130, 61, 20);
		panelPagamento.add(lblAgenciaBancaria);
		
		btnFazerPagamento = new JButton(LocaleUtils.getLocaleView().getString("btn_processar_pagamento"));
		btnFazerPagamento.setBounds(356, 180, 230, 30);
		panelPagamento.add(btnFazerPagamento);
		
		txtAgenciaBancaria = new JTextField(10);
		txtAgenciaBancaria.setBounds(325, 125, 75, 30);
		panelPagamento.add(txtAgenciaBancaria);
		
		lblContaCorrente = new JLabel("C/C");
		lblContaCorrente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContaCorrente.setBounds(405, 130, 61, 20);
		panelPagamento.add(lblContaCorrente);
		
		textField = new JTextField(10);
		textField.setBounds(473, 125, 132, 30);
		panelPagamento.add(textField);
		
		// Cria os icons das bandeiras dos cartos de credito
		ImageIcon iconVisa = new ImageIcon("./src/br/com/locadora/resoureces/images/icons/visa.jpg");
		ImageIcon iconMastercard = new ImageIcon("./src/br/com/locadora/resoureces/images/icons/mastercard.jpg");
		ImageIcon iconElo = new ImageIcon("./src/br/com/locadora/resoureces/images/icons/elo.jpg");
		
		setSize(617, 250);
		setVisible(true);
	}
}
