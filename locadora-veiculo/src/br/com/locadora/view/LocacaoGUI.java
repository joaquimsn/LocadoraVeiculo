package br.com.locadora.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.locadora.utils.locale.LocaleUtils;

import com.toedter.calendar.JDateChooser;

public class LocacaoGUI extends JDialog implements Serializable, ActionListener{
	
	// Panels 
	private JPanel panelLocacao;
	private JPanel panelDetalheLocao;
	private JPanel panelPagamento;
	
	// Labels
	private JLabel lblSelecioneVeiculo;
	private JLabel lblSelecioneOCliente;
	private JLabel lblDataLocacao;
	private JLabel lblDataDaDevoluo;
	private JLabel lblPesquisarVeculo;
	private JLabel lblPesquisarCliente;
	private JLabel lblNomeDoTitular;
	private JLabel lblCpf;
	private JLabel lblNumeroDoCarto;
	private JLabel lblCdgioSegurana;
	private JLabel lblValidade;

	// Inputs
	private JComboBox cbxSelecaoVeiculo;
	private JTextField txtParametroPesquisaVeiculo;
	private JComboBox cbcSelecaoCliente;
	private JTextField txtParametroPesquisaCliente;
	private JDateChooser dataLocacao;
	private JDateChooser dataDevolucao;
	private JTextArea textArea;
	private JTextField txtNomeTitular;
	private JTextField txtCpfTitular;
	private JTextField txtNumeroCartao;
	private JTextField txtCodigoSeguranca;
	private JDateChooser dataValidadeChooser;
	
	// Buttons
	private JButton btnPesquisarCliente;
	private JButton btnCadastrar;
	private JButton btnPesquisarVeiculo;
	private JButton btnFazerPagamento;
	private JButton btnConcluir;
	private JButton btnCancelar;

	public LocacaoGUI() {
		inicializar();
	}
	
	/**Inicializa todos os componetes da tela
	 * @author Joaquim Neto
	 */
	private void inicializar() {
		getContentPane().setLayout(null);
		
		panelLocacao = new JPanel();
		panelLocacao.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1, true), LocaleUtils.getLocaleView().getString("titulo_dado_locacao"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panelLocacao.setBounds(10, 10, 480, 300);
		getContentPane().add(panelLocacao);
		panelLocacao.setLayout(null);
		
		lblSelecioneVeiculo = new JLabel(LocaleUtils.getLocaleView().getString("lbl_selecione_veiculo"));
		lblSelecioneVeiculo.setBounds(10, 75, 150, 20);
		panelLocacao.add(lblSelecioneVeiculo);
		
		cbxSelecaoVeiculo = new JComboBox();
		cbxSelecaoVeiculo.setBounds(5, 95, 465, 30);
		panelLocacao.add(cbxSelecaoVeiculo);
		
		txtParametroPesquisaVeiculo = new JTextField(10);;
		txtParametroPesquisaVeiculo.setBounds(5, 40, 350, 30);
		panelLocacao.add(txtParametroPesquisaVeiculo);
		
		btnPesquisarVeiculo = new JButton(LocaleUtils.getLocaleView().getString("btn_pesquisar"));
		btnPesquisarVeiculo.setBounds(360, 40, 110, 30);
		panelLocacao.add(btnPesquisarVeiculo);
		
		lblSelecioneOCliente = new JLabel(LocaleUtils.getLocaleView().getString("lbl_selecione_cliente"));
		lblSelecioneOCliente.setBounds(15, 175, 150, 20);
		panelLocacao.add(lblSelecioneOCliente);
		
		cbcSelecaoCliente = new JComboBox();
		cbcSelecaoCliente.setBounds(5, 195, 465, 30);
		panelLocacao.add(cbcSelecaoCliente);
		
		txtParametroPesquisaCliente = new JTextField(10);;
		txtParametroPesquisaCliente.setBounds(5, 145, 245, 30);
		panelLocacao.add(txtParametroPesquisaCliente);
		
		btnPesquisarCliente = new JButton(LocaleUtils.getLocaleView().getString("btn_pesquisar"));
		btnPesquisarCliente.setBounds(250, 145, 110, 30);
		panelLocacao.add(btnPesquisarCliente);
		
		lblDataLocacao = new JLabel(LocaleUtils.getLocaleView().getString("lbl_data_locacao"));
		lblDataLocacao.setBounds(10, 230, 150, 20);
		panelLocacao.add(lblDataLocacao);
		
		lblDataDaDevoluo = new JLabel(LocaleUtils.getLocaleView().getString("lbl_data_devolucao"));
		lblDataDaDevoluo.setBounds(245, 230, 150, 20);
		panelLocacao.add(lblDataDaDevoluo);
		
		dataDevolucao = new JDateChooser();
		dataDevolucao.setLocale(LocaleUtils.getLocaleView().getLocale());
		dataDevolucao.setBounds(240, 250, 200, 30);
		panelLocacao.add(dataDevolucao);
		
		dataLocacao = new JDateChooser();
		dataLocacao.setLocale(LocaleUtils.getLocaleView().getLocale());
		dataLocacao.setBounds(5, 250, 200, 30);
		panelLocacao.add(dataLocacao);
		
		lblPesquisarVeculo = new JLabel(LocaleUtils.getLocaleView().getString("lbl_pesquisar_veiculo"));
		lblPesquisarVeculo.setBounds(10, 20, 150, 20);
		panelLocacao.add(lblPesquisarVeculo);
		
		lblPesquisarCliente = new JLabel(LocaleUtils.getLocaleView().getString("lbl_pesquisar_cliente"));
		lblPesquisarCliente.setBounds(10, 125, 150, 20);
		panelLocacao.add(lblPesquisarCliente);
		
		btnCadastrar = new JButton(LocaleUtils.getLocaleView().getString("btn_cadastrar"));
		btnCadastrar.setBounds(360, 145, 110, 30);
		panelLocacao.add(btnCadastrar);
		
		panelDetalheLocao = new JPanel();
		panelDetalheLocao.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1, true), LocaleUtils.getLocaleView().getString("titulo_detalhe_locacao"), 
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(25, 25, 112)));
		panelDetalheLocao.setBounds(500, 10, 280, 300);
		getContentPane().add(panelDetalheLocao);
		panelDetalheLocao.setLayout(null);
		
		textArea = new JTextArea("Teste");
		textArea.setEditable(false);
		textArea.setBounds(22, 21, 248, 251);
		panelDetalheLocao.add(textArea);
		
		panelPagamento = new JPanel();
		panelPagamento.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1, true), LocaleUtils.getLocaleView().getString("titulo_pagamento"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panelPagamento.setBounds(10, 322, 611, 233);
		getContentPane().add(panelPagamento);
		panelPagamento.setLayout(null);
		
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
		
		lblNumeroDoCarto = new JLabel(LocaleUtils.getLocaleView().getString("lbl_numero_cartao"));
		lblNumeroDoCarto.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNumeroDoCarto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDoCarto.setBounds(10, 90, 150, 20);
		panelPagamento.add(lblNumeroDoCarto);
		
		txtNumeroCartao = new JTextField(10);;
		txtNumeroCartao.setBounds(165, 90, 346, 30);
		panelPagamento.add(txtNumeroCartao);
		
		lblCdgioSegurana = new JLabel(LocaleUtils.getLocaleView().getString("lbl_codigo_seguranca"));
		lblCdgioSegurana.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCdgioSegurana.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdgioSegurana.setBounds(10, 130, 150, 20);
		panelPagamento.add(lblCdgioSegurana);
		
		txtCodigoSeguranca = new JTextField(10);;
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
		btnFazerPagamento.setBounds(350, 165, 230, 30);
		panelPagamento.add(btnFazerPagamento);
		
		btnConcluir = new JButton(LocaleUtils.getLocaleView().getString("btn_concluir"));
		btnConcluir.setBounds(660, 474, 100, 65);
		getContentPane().add(btnConcluir);
		
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		btnCancelar = new JButton(LocaleUtils.getLocaleView().getString("btn_cancelar"));
		btnCancelar.setBounds(660, 398, 100, 65);
		getContentPane().add(btnCancelar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
