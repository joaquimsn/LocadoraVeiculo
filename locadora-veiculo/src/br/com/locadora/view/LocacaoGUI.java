package br.com.locadora.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.componentes.CartaoCreditoComponente;
import br.com.locadora.view.componentes.CartaoDebitoComponente;

import com.toedter.calendar.JDateChooser;

public class LocacaoGUI extends JDialog implements Serializable, ActionListener{
	
	// Panels 
	private JPanel panelLocacao;
	private JPanel panelDetalheLocao;
	
	// Labels
	private JLabel lblSelecioneVeiculo;
	private JLabel lblSelecioneOCliente;
	private JLabel lblDataLocacao;
	private JLabel lblDataDaDevoluo;
	private JLabel lblPesquisarVeculo;
	private JLabel lblPesquisarCliente;
	private JLabel lblAgnciaDeDevoluo;
	private JLabel lblFormaPagamento;
	private JLabel lblAgnciaDeRetirada;

	// Inputs
	private JComboBox cbxSelecaoVeiculo;
	private JTextField txtParametroPesquisaVeiculo;
	private JComboBox cbcSelecaoCliente;
	private JTextField txtParametroPesquisaCliente;
	private JDateChooser dataLocacao;
	private JDateChooser dataDevolucao;
	
	
	// Buttons
	private JButton btnPesquisarCliente;
	private JButton btnCadastrar;
	private JButton btnPesquisarVeiculo;
	private JButton btnConcluir;
	private JButton btnCancelar;
	private JRadioButton rdbtnCartoCredito;
	private JRadioButton rdbtnCartoDebito;
	private JComboBox cbxAgenciaRetirada;
	private JComboBox cbxAgenciaDevolucao;
	
	// Componentes
	private CartaoDebitoComponente cartaoDebitoComponente;
	private CartaoCreditoComponente cartaoCreditoComponente;

	public LocacaoGUI() {
		inicializar();
	}
	
	/**Inicializa todos os componetes da tela
	 * @author Joaquim Neto
	 */
	private void inicializar() {
		getContentPane().setLayout(null);
		Container container = getContentPane();
		
		panelLocacao = new JPanel();
		panelLocacao.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1, true), LocaleUtils.getLocaleView().getString("titulo_dado_locacao"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panelLocacao.setBounds(10, 10, 480, 300);
		getContentPane().add(panelLocacao);
		panelLocacao.setLayout(null);
		
		lblSelecioneVeiculo = new JLabel(LocaleUtils.getLocaleView().getString("lbl_selecione_veiculo"));
		lblSelecioneVeiculo.setBounds(15, 75, 150, 20);
		panelLocacao.add(lblSelecioneVeiculo);
		
		cbxSelecaoVeiculo = new JComboBox();
		cbxSelecaoVeiculo.setBounds(10, 95, 455, 30);
		panelLocacao.add(cbxSelecaoVeiculo);
		
		txtParametroPesquisaVeiculo = new JTextField(10);;
		txtParametroPesquisaVeiculo.setBounds(10, 40, 345, 30);
		panelLocacao.add(txtParametroPesquisaVeiculo);
		
		btnPesquisarVeiculo = new JButton(LocaleUtils.getLocaleView().getString("btn_pesquisar"));
		btnPesquisarVeiculo.setBounds(355, 40, 110, 30);
		panelLocacao.add(btnPesquisarVeiculo);
		
		lblSelecioneOCliente = new JLabel(LocaleUtils.getLocaleView().getString("lbl_selecione_cliente"));
		lblSelecioneOCliente.setBounds(15, 175, 150, 20);
		panelLocacao.add(lblSelecioneOCliente);
		
		cbcSelecaoCliente = new JComboBox();
		cbcSelecaoCliente.setBounds(10, 195, 455, 30);
		panelLocacao.add(cbcSelecaoCliente);
		
		txtParametroPesquisaCliente = new JTextField(10);;
		txtParametroPesquisaCliente.setBounds(10, 145, 240, 30);
		panelLocacao.add(txtParametroPesquisaCliente);
		
		btnPesquisarCliente = new JButton(LocaleUtils.getLocaleView().getString("btn_pesquisar"));
		btnPesquisarCliente.setBounds(250, 145, 105, 30);
		panelLocacao.add(btnPesquisarCliente);
		
		lblPesquisarVeculo = new JLabel(LocaleUtils.getLocaleView().getString("lbl_pesquisar_veiculo"));
		lblPesquisarVeculo.setBounds(15, 20, 150, 20);
		panelLocacao.add(lblPesquisarVeculo);
		
		lblPesquisarCliente = new JLabel(LocaleUtils.getLocaleView().getString("lbl_pesquisar_cliente"));
		lblPesquisarCliente.setBounds(15, 125, 150, 20);
		panelLocacao.add(lblPesquisarCliente);
		
		btnCadastrar = new JButton(LocaleUtils.getLocaleView().getString("btn_cadastrar"));
		btnCadastrar.setBounds(355, 145, 110, 30);
		panelLocacao.add(btnCadastrar);
		
		lblFormaPagamento = new JLabel(LocaleUtils.getLocaleView().getString("lbl_forma_pagamento"));
		lblFormaPagamento.setBounds(15, 235, 220, 20);
		panelLocacao.add(lblFormaPagamento);
		
		// Grupo radio button
		ButtonGroup grupRadio = new ButtonGroup();
		
		rdbtnCartoCredito = new JRadioButton(LocaleUtils.getLocaleView().getString("cartao_credito"));
		rdbtnCartoCredito.setBounds(15, 265, 150, 20);
		grupRadio.add(rdbtnCartoCredito);
		panelLocacao.add(rdbtnCartoCredito);
		
		rdbtnCartoDebito = new JRadioButton(LocaleUtils.getLocaleView().getString("cartao_debito"));
		rdbtnCartoDebito.setBounds(176, 265, 150, 18);
		grupRadio.add(rdbtnCartoDebito);
		panelLocacao.add(rdbtnCartoDebito);
		
		panelDetalheLocao = new JPanel();
		panelDetalheLocao.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1, true), LocaleUtils.getLocaleView().getString("titulo_detalhe_locacao"), 
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(25, 25, 112)));
		panelDetalheLocao.setBounds(500, 10, 280, 300);
		getContentPane().add(panelDetalheLocao);
		panelDetalheLocao.setLayout(null);
		
		lblDataLocacao = new JLabel(LocaleUtils.getLocaleView().getString("lbl_data_locacao"));
		lblDataLocacao.setBounds(15, 20, 150, 20);
		panelDetalheLocao.add(lblDataLocacao);
		
		dataLocacao = new JDateChooser();
		// Define a data minima para seleção
		dataLocacao.setMinSelectableDate(new Date());
		dataLocacao.setBounds(10, 40, 200, 30);
		panelDetalheLocao.add(dataLocacao);
		dataLocacao.setLocale(LocaleUtils.getLocaleView().getLocale());
		
		lblDataDaDevoluo = new JLabel(LocaleUtils.getLocaleView().getString("lbl_data_devolucao"));
		lblDataDaDevoluo.setBounds(15, 75, 150, 20);
		panelDetalheLocao.add(lblDataDaDevoluo);
		
		dataDevolucao = new JDateChooser();
		// Define a data minima para seleção
		dataDevolucao.setMinSelectableDate(new Date());
		dataDevolucao.setBounds(10, 95, 200, 30);
		panelDetalheLocao.add(dataDevolucao);
		dataDevolucao.setLocale(LocaleUtils.getLocaleView().getLocale());
		
		lblAgnciaDeRetirada = new JLabel(LocaleUtils.getLocaleView().getString("lbl_agencia_retirada"));
		lblAgnciaDeRetirada.setBounds(15, 130, 150, 20);
		panelDetalheLocao.add(lblAgnciaDeRetirada);
		
		cbxAgenciaRetirada = new JComboBox();
		cbxAgenciaRetirada.setBounds(10, 148, 250, 30);
		panelDetalheLocao.add(cbxAgenciaRetirada);
		
		lblAgnciaDeDevoluo = new JLabel(LocaleUtils.getLocaleView().getString("lbl_agencia_devolucao"));
		lblAgnciaDeDevoluo.setBounds(15, 185, 150, 20);
		panelDetalheLocao.add(lblAgnciaDeDevoluo);
		
		cbxAgenciaDevolucao = new JComboBox();
		cbxAgenciaDevolucao.setBounds(10, 205, 250, 30);
		panelDetalheLocao.add(cbxAgenciaDevolucao);
		
		btnConcluir = new JButton(LocaleUtils.getLocaleView().getString("btn_concluir"));
		btnConcluir.setBounds(660, 474, 100, 65);
		getContentPane().add(btnConcluir);
		
		btnCancelar = new JButton(LocaleUtils.getLocaleView().getString("btn_cancelar"));
		btnCancelar.setBounds(660, 398, 100, 65);
		getContentPane().add(btnCancelar);
		
//		cartaoDebitoComponente = new CartaoDebitoComponente();
//		cartaoDebitoComponente.setBounds(10, 322, 620, 250);
//		getContentPane().add(cartaoDebitoComponente);
		
		cartaoCreditoComponente = new CartaoCreditoComponente();
		cartaoCreditoComponente.setBounds(10, 322, 620, 250);
		getContentPane().add(cartaoCreditoComponente);
		
		setBounds(10, 0, 790, 600);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
