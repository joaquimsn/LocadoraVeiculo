package br.com.locadora.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.locadora.controller.AgenciaControl;
import br.com.locadora.controller.ClienteControl;
import br.com.locadora.controller.LocacaoControl;
import br.com.locadora.controller.VeiculoControl;
import br.com.locadora.model.entity.Agencia;
import br.com.locadora.model.entity.Cliente;
import br.com.locadora.model.entity.Locacao;
import br.com.locadora.model.entity.Veiculo;
import br.com.locadora.model.enums.ParametroPesquisaClienteEnum;
import br.com.locadora.model.enums.ParametroPesquisaVeiculoEnum;
import br.com.locadora.model.enums.TipoTarifaEnum;
import br.com.locadora.utils.SystemUtils;
import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.componentes.CartaoCreditoComponente;
import br.com.locadora.view.componentes.CartaoDebitoComponente;
import br.com.locadora.view.componentes.InputSoNumeros;
import br.com.locadora.view.componentes.InputSoTexto;
import br.com.locadora.view.componentes.InputSoTextoNumeros;

import com.toedter.calendar.JDateChooser;

public class LocacaoGUI extends JDialog implements Serializable, ActionListener{
	private static final long serialVersionUID = -448346052180078969L;
	
	// Panels 
	private JPanel panelLocacao;
	private JPanel panelDetalheLocao;
	private static JPanel panelContainerPagamento;
	
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
	private JLabel lblTipoTarifa;
	private JLabel lblKm;

	// Inputs
	private JComboBox cbxSelecaoVeiculo;
	private JTextField txtParametroPesquisaVeiculo;
	private JComboBox cbxSelecaoCliente;
	private JTextField txtParametroPesquisaCliente;
	private JTextField txtQuantidadeKm;
	private JDateChooser dataLocacao;
	private JDateChooser dataDevolucao;
	
	
	// Buttons
	private JButton btnPesquisarCliente;
	private JButton btnCadastrarCliente;
	private JButton btnPesquisarVeiculo;
	private JButton btnConcluir;
	private JButton btnCancelar;
	private JRadioButton rdbtnCartoCredito;
	private JRadioButton rdbtnCartoDebito;
	private JComboBox cbxAgenciaRetirada;
	private JComboBox cbxAgenciaDevolucao;
	private JComboBox cbxTipoTarifa;
	
	// Componentes
	private CartaoDebitoComponente cartaoDebitoComponente;
	private CartaoCreditoComponente cartaoCreditoComponente;
	
	private List<Cliente> listaCliente;
	private List<Veiculo> listaVeiculo;
	private List<Agencia> listaAgencia;

	private boolean liberaCampoKm;
	
	public LocacaoGUI() {
		liberaCampoKm = true;
		
		setTitle(LocaleUtils.getLocaleView().getString("titulo_tela_locacao"));
		inicializar();
	}
	
	/**Inicializa todos os componetes da tela
	 * @author Joaquim Neto
	 */
	private void inicializar() {
		
		// InputVerifier para validações genéricas dos campos
		InputSoNumeros soNumeros = new InputSoNumeros();
		InputSoTextoNumeros soTextoNumeros = new InputSoTextoNumeros();
		InputSoTexto soTexto = new InputSoTexto();
		
		preencherCampos();
		
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
		
		cbxSelecaoVeiculo = new JComboBox(getVeiculos());
		cbxSelecaoVeiculo.setBounds(10, 95, 455, 30);
		panelLocacao.add(cbxSelecaoVeiculo);
		
		txtParametroPesquisaVeiculo = new JTextField(10);
		txtParametroPesquisaVeiculo.setInputVerifier(soTextoNumeros);
		txtParametroPesquisaVeiculo.setBounds(10, 40, 345, 30);
		panelLocacao.add(txtParametroPesquisaVeiculo);
		
		btnPesquisarVeiculo = new JButton(LocaleUtils.getLocaleView().getString("btn_pesquisar"));
		btnPesquisarVeiculo.setBounds(355, 40, 110, 30);
		panelLocacao.add(btnPesquisarVeiculo);
		
		lblSelecioneOCliente = new JLabel(LocaleUtils.getLocaleView().getString("lbl_selecione_cliente"));
		lblSelecioneOCliente.setBounds(15, 175, 150, 20);
		panelLocacao.add(lblSelecioneOCliente);
		
		cbxSelecaoCliente = new JComboBox(getClientes());
		cbxSelecaoCliente.setBounds(10, 195, 455, 30);
		panelLocacao.add(cbxSelecaoCliente);
		
		txtParametroPesquisaCliente = new JTextField(10);
		txtParametroPesquisaCliente.setToolTipText("Pesquisa aceita apenas o numero da CNH");
		txtParametroPesquisaCliente.setInputVerifier(soNumeros);
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
		
		btnCadastrarCliente = new JButton(LocaleUtils.getLocaleView().getString("btn_cadastrar"));
		btnCadastrarCliente.setBounds(355, 145, 110, 30);
		panelLocacao.add(btnCadastrarCliente);
		
		lblFormaPagamento = new JLabel(LocaleUtils.getLocaleView().getString("lbl_forma_pagamento"));
		lblFormaPagamento.setBounds(15, 235, 220, 20);
		panelLocacao.add(lblFormaPagamento);
		
		// Grupo radio button
		ButtonGroup grupRadio = new ButtonGroup();
		
		rdbtnCartoCredito = new JRadioButton(LocaleUtils.getLocaleView().getString("cartao_credito"));
		rdbtnCartoCredito.setSelected(true);
		rdbtnCartoCredito.addActionListener(this);
		rdbtnCartoCredito.setBounds(15, 265, 150, 20);
		grupRadio.add(rdbtnCartoCredito);
		panelLocacao.add(rdbtnCartoCredito);
		
		rdbtnCartoDebito = new JRadioButton(LocaleUtils.getLocaleView().getString("cartao_debito"));
		rdbtnCartoDebito.addActionListener(this);
		rdbtnCartoDebito.setBounds(176, 265, 150, 18);
		grupRadio.add(rdbtnCartoDebito);
		panelLocacao.add(rdbtnCartoDebito);
		
		lblTipoTarifa = new JLabel(LocaleUtils.getLocaleView().getString("lbl_tipo_tarifa"));
		lblTipoTarifa.setBounds(325, 235, 220, 20);
		panelLocacao.add(lblTipoTarifa);
		
		cbxTipoTarifa = new JComboBox(TipoTarifaEnum.getDisplayList().toArray(new String[0]));
		cbxTipoTarifa.addActionListener(this);
		cbxTipoTarifa.setBounds(320, 255, 145, 30);
		panelLocacao.add(cbxTipoTarifa);
		
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
		
		cbxAgenciaRetirada = new JComboBox(new String[]{SystemUtils.getAgenciaSelecionado().getRazaoSocial()});
		cbxAgenciaRetirada.setBounds(10, 148, 250, 30);
		panelDetalheLocao.add(cbxAgenciaRetirada);
		
		lblAgnciaDeDevoluo = new JLabel(LocaleUtils.getLocaleView().getString("lbl_agencia_devolucao"));
		lblAgnciaDeDevoluo.setBounds(15, 185, 150, 20);
		panelDetalheLocao.add(lblAgnciaDeDevoluo);
		
		cbxAgenciaDevolucao = new JComboBox(getAgencias());
		cbxAgenciaDevolucao.setBounds(10, 205, 250, 30);
		panelDetalheLocao.add(cbxAgenciaDevolucao);
		
		lblKm = new JLabel(LocaleUtils.getLocaleView().getString("lbl_km"));
		lblKm.setBounds(15, 245, 150, 20);
		panelDetalheLocao.add(lblKm);
		
		txtQuantidadeKm = new JTextField(10);
		txtQuantidadeKm.setEditable(liberarCampoPreencherKM());
		txtQuantidadeKm.setBounds(10, 265, 150, 30);
		txtQuantidadeKm.setInputVerifier(soNumeros);
		panelDetalheLocao.add(txtQuantidadeKm);
		
		btnConcluir = new JButton(LocaleUtils.getLocaleView().getString("btn_concluir"));
		btnConcluir.addActionListener(this);
		btnConcluir.setBounds(660, 470, 100, 65);
		getContentPane().add(btnConcluir);
		
		btnCancelar = new JButton(LocaleUtils.getLocaleView().getString("btn_cancelar"));
		btnCancelar.setBounds(660, 370, 100, 65);
		getContentPane().add(btnCancelar);
		
//		cartaoDebitoComponente = new CartaoDebitoComponente();
//		cartaoDebitoComponente.setBounds(10, 322, 620, 250);
//		getContentPane().add(cartaoDebitoComponente);
		
		// Inicia o container do panel de pagamento
		panelContainerPagamento = new JPanel(null);
		panelContainerPagamento.setBounds(10, 322, 620, 250);
		getContentPane().add(panelContainerPagamento);
		
		cartaoCreditoComponente = new CartaoCreditoComponente();
		panelContainerPagamento.add(cartaoCreditoComponente);
		
		setBounds(10, 0, 790, 600);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		/*
		 * EVENTOS
		 */
		
		// Preenche o combobox de cliente com o resultado da pesquisa realizada
		btnPesquisarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClienteControl clienteControl = new ClienteControl();
				if (txtParametroPesquisaCliente.getText().length() > 0) {
					listaCliente = clienteControl.buscarPorCondicao(ParametroPesquisaClienteEnum.CNH.getValue(), 
							txtParametroPesquisaCliente.getText());
					
					preencherComboCliente();
				}
			}
		});
		
		// Preenche o combobox de veículo com o resultado da pesquisa realizada
		btnPesquisarVeiculo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VeiculoControl veiculoControl = new VeiculoControl();
				
				if (txtParametroPesquisaVeiculo.getText().length() > 0) {
					listaVeiculo = veiculoControl.buscarPorCondicao(ParametroPesquisaVeiculoEnum.PLACA.getValue(),
							txtParametroPesquisaVeiculo.getText());
					
					preencherComboVeiculo();
				}
			}
		});
		
		// Finaliza a locação
		btnConcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// Fecha a tela de locação
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		// Abre a tela para cadastrar um cliente
		btnCadastrarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ModalAlterarcaoGUI modalAlterarcaoGUI = new ModalAlterarcaoGUI(new ClienteGUI(), "Cadastro de Cliente");
				modalAlterarcaoGUI.setLocationRelativeTo(txtParametroPesquisaCliente);
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cbxTipoTarifa) {
			if (TipoTarifaEnum.getValueByDisplay((String) cbxTipoTarifa.getSelectedItem()) == TipoTarifaEnum.KM_LIVRE.getValue()) {
				liberaCampoKm = false;
				txtQuantidadeKm.setEnabled(liberarCampoPreencherKM());
				txtQuantidadeKm.repaint();
			}
		}
		
		if (e.getSource() == btnConcluir) {
			if (!cartaoCreditoComponente.isPagamentoAprovado()) {
				JOptionPane.showMessageDialog(cbxSelecaoVeiculo, "O pagamento não foi confirmado tente novamente para concluir");
				return;
			}
			
			LocacaoControl locacaoControl = new LocacaoControl();
			locacaoControl.fazerLocacao(getDadosLocacao());
			
			JOptionPane.showMessageDialog(null, "Locação efetuada com sucesso");
		}
			
	}
	
	private void preencherCampos() {
		AgenciaControl agenciaControl = new AgenciaControl();
		ClienteControl clienteControl = new ClienteControl();
		VeiculoControl veiculoControl = new VeiculoControl();
		
		listaAgencia = agenciaControl.buscarTodos();
		listaCliente = clienteControl.buscarTodos();
		listaVeiculo = veiculoControl.buscarTodos();
	}
	
	/**
	 * Array os modelos dos veículos cadastrados
	 * @author Joaquim Neto
	 * @return Array modelo veículo
	 */
	private String[] getVeiculos() {
		String[] veiculos = new String[listaVeiculo.size()];
		for (int i = 0; i < listaVeiculo.size(); i++) {
			veiculos[i] = listaVeiculo.get(i).getPlaca() + " - " + listaVeiculo.get(i).getModelo();
		}
		
		return veiculos;
	}
	
	/**
	 * @author Joaquim Neto
	 * @return Array com a razão social das agências
	 */
	private String[] getAgencias() {
		String[] agencias = new String[listaAgencia.size()];
		for (int i = 0; i < listaAgencia.size(); i++) {
			agencias[i] = listaAgencia.get(i).getRazaoSocial();
		}
		
		return agencias;
	}
	
	/**
	 * @author Joaquim Neto
	 * @return Array com os nomes dos clientes
	 */
	private String[] getClientes() {
		String[] clientes = new String[listaCliente.size()];
		for (int i = 0; i < listaCliente.size(); i++) {
			clientes[i] = listaCliente.get(i).getCnh() + " - " + listaCliente.get(i).getNome();
		}
		
		return clientes;
	}
	
	/**
	 * Preenche o combobox de cliente, com os valores da listaCliente
	 * @author Joaquim Neto
	 */
	private void preencherComboCliente() {
		// Remove os dados da pesquisa anterior
		cbxSelecaoCliente.removeAllItems();
		
		for (Cliente cliente : listaCliente) {
			cbxSelecaoCliente.addItem(cliente.getCnh() + " - " + cliente.getNome());
		}
		cbxSelecaoCliente.repaint();
	}
	
	/**
	 * Preenche o combobox de veículo, com os valores da listaVeiculo
	 * @author Joaquim Neto
	 */
	private void preencherComboVeiculo() {
		// Remove os dados da pesquisa anterior
		cbxSelecaoVeiculo.removeAllItems();
		
		for (Veiculo veiculo : listaVeiculo) {
			cbxSelecaoVeiculo.addItem(veiculo.getPlaca() + " - " + veiculo.getModelo());
		}
		cbxSelecaoVeiculo.repaint();
	}
	
	/**
	 * Troca a tela do container de pagamento
	 * @param tela do pagamento escolhido
	 * @author Joaquim Neto
	 */
	public void mudarTelaContainer(JPanel tela) {
		panelContainerPagamento.removeAll();
		panelContainerPagamento.add(tela);
		add(panelContainerPagamento, BorderLayout.CENTER);
		panelContainerPagamento.repaint();
	}
	
	/**
	 * Retorna true se o combo tipo tarifa estiver selecionado Tarifa controlada
	 * @author Joaquim Neto
	 * @return <b>true</b> Se for para liberar o campo de KM
	 */
	private boolean liberarCampoPreencherKM() {
		return liberaCampoKm;
	}
	
	private Locacao getDadosLocacao() {
		Locacao locacao = new Locacao();
		locacao.setAgenciaDevolucao(listaAgencia.get(cbxAgenciaDevolucao.getSelectedIndex()).getIdAgencia());
		locacao.setCliente(listaCliente.get(cbxSelecaoCliente.getSelectedIndex()));
		locacao.setDataHoraLocacao(dataLocacao.getDate());
		locacao.setDataHoraPrevistaDevolucao(dataDevolucao.getDate());
		locacao.setIdVeiculo(listaVeiculo.get(cbxSelecaoVeiculo.getSelectedIndex()));
		locacao.setKmLocacao(Double.parseDouble(txtQuantidadeKm.getText()));
		locacao.setTipoTarifa(TipoTarifaEnum.getValueByDisplay((String) cbxTipoTarifa.getSelectedItem()));
		
		if (rdbtnCartoCredito.isSelected()) {
			locacao.setPagamento(cartaoCreditoComponente.getDadoDoCartao());
		} else {
			locacao.setPagamento(cartaoDebitoComponente.getDadoDoCartao());
		}
		
		return locacao;
	}
}
