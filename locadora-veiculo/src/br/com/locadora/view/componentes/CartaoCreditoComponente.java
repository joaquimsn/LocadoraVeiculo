package br.com.locadora.view.componentes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.locadora.controller.PagamentoControl;
import br.com.locadora.model.entity.CartaoCredito;
import br.com.locadora.utils.SystemUtils;
import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.Mask;

import com.toedter.calendar.JDateChooser;

public class CartaoCreditoComponente extends JPanel {
	private static final long serialVersionUID = -3056594278812705256L;
	
	// Labels
	private JLabel lblNomeDoTitular;
	private JLabel lblCpf;
	private JLabel lblNumeroDoCarto;
	private JLabel lblCdgioSegurana;
	private JLabel lblValidade;
	
	// Inputs
	private JTextField txtNomeTitular;
	private JFormattedTextField txtCpfTitular;
	private JTextField txtNumeroCartao;
	private JTextField txtCodigoSeguranca;
	private JDateChooser dataValidadeChooser;
	
	// Buttons
	private JRadioButton rdbVisa;
	private JRadioButton rdbMastercard;
	private JRadioButton rdbElo;
	private JButton btnFazerPagamento;
	
	private boolean pagamentoAprovato;
	
	private JPanel panelPagamento;
	
	/**
	 * Componente cartão de debito contém todos os campos
	 * necessários fazer um pagamento por cartão
	 * @author Joaquim Neto
	 */
	public CartaoCreditoComponente() {
		inicializar();
	}
	
	/**Inicializa todos os componetes
	 * @author Joaquim Neto
	 */
	private void inicializar() {
		setLayout(null);
		
		// InputVerifier para validações genéricas dos campos
		InputSoNumeros soNumeros = new InputSoNumeros();
		InputSoTextoNumeros soTextoNumeros = new InputSoTextoNumeros();
		InputSoTexto soTexto = new InputSoTexto();
		
		TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.GRAY, 1, true), LocaleUtils.getLocaleView().getString("titulo_pagamento_credito"), 
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128));
		panelPagamento = new JPanel();
		panelPagamento.setBorder(titledBorder);
		panelPagamento.setLayout(null);
		panelPagamento.setBounds(0, 5, 617, 238);
		add(panelPagamento);
		
		lblNomeDoTitular = new JLabel(LocaleUtils.getLocaleView().getString("lbl_nome_titular"));
		lblNomeDoTitular.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNomeDoTitular.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDoTitular.setBounds(10, 20, 150, 20);
		panelPagamento.add(lblNomeDoTitular);
		
		txtNomeTitular = new JTextField(10);
		txtNomeTitular.setInputVerifier(soTexto);
		txtNomeTitular.setBounds(165, 20, 440, 30);
		panelPagamento.add(txtNomeTitular);
		
		lblCpf = new JLabel(LocaleUtils.getLocaleView().getString("lbl_cpf"));
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(10, 60, 150, 20);
		panelPagamento.add(lblCpf);
		
		txtCpfTitular = new JFormattedTextField(Mask.maskCpf());
		txtCpfTitular.setBounds(165, 55, 200, 30);
		panelPagamento.add(txtCpfTitular);
		
		lblNumeroDoCarto = new JLabel(LocaleUtils.getLocaleView().getString("lbl_numero_cartao"));
		lblNumeroDoCarto.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNumeroDoCarto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDoCarto.setBounds(10, 90, 150, 20);
		panelPagamento.add(lblNumeroDoCarto);
		
		txtNumeroCartao = new JTextField(10);
		txtNumeroCartao.setInputVerifier(soNumeros);
		txtNumeroCartao.setBounds(165, 90, 346, 30);
		panelPagamento.add(txtNumeroCartao);
		
		lblCdgioSegurana = new JLabel(LocaleUtils.getLocaleView().getString("lbl_codigo_seguranca"));
		lblCdgioSegurana.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCdgioSegurana.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdgioSegurana.setBounds(10, 130, 150, 20);
		panelPagamento.add(lblCdgioSegurana);
		
		txtCodigoSeguranca = new JTextField(10);
		txtCodigoSeguranca.setInputVerifier(soNumeros);
		txtCodigoSeguranca.setBounds(165, 125, 90, 30);
		panelPagamento.add(txtCodigoSeguranca);
		
		lblValidade = new JLabel(LocaleUtils.getLocaleView().getString("lbl_validade"));
		lblValidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValidade.setBounds(267, 130, 73, 20);
		panelPagamento.add(lblValidade);
		
		dataValidadeChooser = new JDateChooser();
		dataValidadeChooser.setBounds(352, 125, 159, 30);
		panelPagamento.add(dataValidadeChooser);
		
		btnFazerPagamento = new JButton(LocaleUtils.getLocaleView().getString("btn_processar_pagamento"));
		btnFazerPagamento.setBounds(356, 180, 230, 30);
		panelPagamento.add(btnFazerPagamento);
		
		// Cria os icons das bandeiras dos cartos de credito
		ImageIcon iconVisa = new ImageIcon("./src/br/com/locadora/resoureces/images/icons/visa.jpg");
		ImageIcon iconMastercard = new ImageIcon("./src/br/com/locadora/resoureces/images/icons/mastercard.jpg");
		ImageIcon iconElo = new ImageIcon("./src/br/com/locadora/resoureces/images/icons/elo.jpg");
		
		rdbVisa = new JRadioButton(iconVisa);
		rdbVisa.setBounds(20, 177, 60, 35);
		panelPagamento.add(rdbVisa);
		
		rdbMastercard = new JRadioButton(iconMastercard);
		rdbMastercard.setBounds(87, 177, 60, 35);
		panelPagamento.add(rdbMastercard);
		
		rdbElo = new JRadioButton(iconElo);
		rdbElo.setBounds(162, 177, 60, 35);
		panelPagamento.add(rdbElo);
		
		setSize(617, 250);
		setVisible(true);
		
		btnFazerPagamento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (!SystemUtils.isCamposObrigatoriosPreenchidos(getDadoDoCartao())) {
					return;
				}
				
				PagamentoControl pagamentoControl = new PagamentoControl();
				
				// Salva o status do pagamento
				pagamentoAprovato = pagamentoControl.processarPagamento(getDadoDoCartao());
				
				if (pagamentoAprovato) {
					JOptionPane.showMessageDialog(dataValidadeChooser, "Pagamento efetuado com sucesso");
				} else {
					JOptionPane.showMessageDialog(dataValidadeChooser, "Pagamento não autorizado");
				}
				
			}
		});
	}
	
	/**
	 * Retorna os dados do pagamento informado pelo usuário
	 * @author Joaquim Neto
	 * @return Objeto CartaoCredito
	 */
	public CartaoCredito getDadoDoCartao() {
		CartaoCredito cartaoCredito = new CartaoCredito();
		
		int codigo = Integer.parseInt(txtCodigoSeguranca.getText());
		cartaoCredito.setCodigoSeguranca(codigo);
		cartaoCredito.setCpf(txtCpfTitular.getText());
		cartaoCredito.setNumeroCartao(txtNumeroCartao.getText());
		cartaoCredito.setTitular(txtNomeTitular.getText());
		cartaoCredito.setValidade(dataValidadeChooser.getDate());
		
		return cartaoCredito;
	}
	
	/**
	 * Limpa os campos da tela
	 * @author Joaquim Neto
	 */
	public void limparCampos() {
		txtCodigoSeguranca.setText("");
		txtCpfTitular.setText("");
		txtNomeTitular.setText("");
		txtNumeroCartao.setText("");
	}

	/**
	 * @param pagamentoAprovato the pagamentoAprovato to set
	 */
	public void setPagamentoAprovato(boolean pagamentoAprovato) {
		this.pagamentoAprovato = pagamentoAprovato;
	}
	
}
