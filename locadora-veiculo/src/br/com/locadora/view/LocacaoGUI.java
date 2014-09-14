package br.com.locadora.view;

import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.locadora.utils.locale.LocaleUtils;

import com.toedter.calendar.JDateChooser;

public class LocacaoGUI extends JDialog implements Serializable, ActionListener{
	private JPanel panelLocacao;
	private JPanel panelDetalheLocao;
	private JPanel panelPagamento;
	private TextArea textArea;
	private JLabel lblSelecioneVeiculo;
	private JComboBox cbxSelecaoVeiculo;
	private JTextField txtParametroPesquisaVeiculo;
	private JButton btnPesquisarVeiculo;
	private JLabel lblSelecioneOCliente;
	private JComboBox cbcSelecaoCliente;
	private JTextField txtParametroPesquisaCliente;
	private JButton btnPesquisarCliente;
	private JLabel lblDataLocacao;
	private JLabel lblDataDaDevoluo;
	private JDateChooser dataLocacao;
	private JDateChooser dataDevolucao;
	private JLabel lblPesquisarVeculo;
	private JLabel lblPesquisarCliente;
	private JButton btnCadastrar;
	private JLabel lblNomeDoTitular;
	private JTextField txtNomeTitular;
	private JLabel lblCpf;
	private JTextField txtCpfTitular;
	private JLabel lblNumeroDoCarto;
	private JTextField txtNumeroCartao;
	private JLabel lblCdgioSegurana;
	private JTextField txtCodigoSeguranca;
	private JLabel lblValidade;
	private JDateChooser dataValidadeChooser;
	private JButton btnFazerPagamento;
	private JButton btnConcluir;

	public LocacaoGUI() {

		inicializar();
	}
	private void inicializar() {
		getContentPane().setLayout(null);
		
		panelLocacao = new JPanel();
		panelLocacao.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Dados da loca\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panelLocacao.setBounds(10, 10, 480, 300);
		getContentPane().add(panelLocacao);
		panelLocacao.setLayout(null);
		
		lblSelecioneVeiculo = new JLabel("Selecione o Veículo");
		lblSelecioneVeiculo.setBounds(10, 75, 150, 20);
		panelLocacao.add(lblSelecioneVeiculo);
		
		cbxSelecaoVeiculo = new JComboBox();
		cbxSelecaoVeiculo.setBounds(5, 95, 465, 30);
		panelLocacao.add(cbxSelecaoVeiculo);
		
		txtParametroPesquisaVeiculo = new JTextField();
		txtParametroPesquisaVeiculo.setBounds(5, 40, 350, 30);
		panelLocacao.add(txtParametroPesquisaVeiculo);
		txtParametroPesquisaVeiculo.setColumns(10);
		
		btnPesquisarVeiculo = new JButton("Pesquisar");
		btnPesquisarVeiculo.setBounds(360, 40, 110, 30);
		panelLocacao.add(btnPesquisarVeiculo);
		
		lblSelecioneOCliente = new JLabel("Selecione o Cliente");
		lblSelecioneOCliente.setBounds(15, 175, 150, 20);
		panelLocacao.add(lblSelecioneOCliente);
		
		cbcSelecaoCliente = new JComboBox();
		cbcSelecaoCliente.setBounds(5, 195, 465, 30);
		panelLocacao.add(cbcSelecaoCliente);
		
		txtParametroPesquisaCliente = new JTextField();
		txtParametroPesquisaCliente.setColumns(10);
		txtParametroPesquisaCliente.setBounds(5, 145, 245, 30);
		panelLocacao.add(txtParametroPesquisaCliente);
		
		btnPesquisarCliente = new JButton("Pesquisar");
		btnPesquisarCliente.setBounds(250, 145, 110, 30);
		panelLocacao.add(btnPesquisarCliente);
		
		lblDataLocacao = new JLabel("Data da Locação");
		lblDataLocacao.setBounds(10, 230, 150, 20);
		panelLocacao.add(lblDataLocacao);
		
		lblDataDaDevoluo = new JLabel("Data da Devolução");
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
		
		lblPesquisarVeculo = new JLabel("Pesquisar Veículo");
		lblPesquisarVeculo.setBounds(10, 20, 150, 20);
		panelLocacao.add(lblPesquisarVeculo);
		
		lblPesquisarCliente = new JLabel("Pesquisar Cliente");
		lblPesquisarCliente.setBounds(10, 125, 150, 20);
		panelLocacao.add(lblPesquisarCliente);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(360, 145, 110, 30);
		panelLocacao.add(btnCadastrar);
		
		panelDetalheLocao = new JPanel();
		panelDetalheLocao.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Detalhamento da Loca\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(25, 25, 112)));
		panelDetalheLocao.setBounds(500, 10, 280, 300);
		getContentPane().add(panelDetalheLocao);
		panelDetalheLocao.setLayout(null);
		
		textArea = new TextArea("Teste");
		textArea.setEditable(false);
		textArea.setBounds(22, 21, 248, 251);
		panelDetalheLocao.add(textArea);
		
		panelPagamento = new JPanel();
		panelPagamento.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Pagamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panelPagamento.setBounds(10, 322, 611, 233);
		getContentPane().add(panelPagamento);
		panelPagamento.setLayout(null);
		
		lblNomeDoTitular = new JLabel("Nome do Titular");
		lblNomeDoTitular.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNomeDoTitular.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDoTitular.setBounds(10, 20, 150, 20);
		panelPagamento.add(lblNomeDoTitular);
		
		txtNomeTitular = new JTextField();
		txtNomeTitular.setColumns(10);
		txtNomeTitular.setBounds(165, 20, 440, 30);
		panelPagamento.add(txtNomeTitular);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(10, 55, 150, 20);
		panelPagamento.add(lblCpf);
		
		txtCpfTitular = new JTextField();
		txtCpfTitular.setColumns(10);
		txtCpfTitular.setBounds(165, 50, 200, 30);
		panelPagamento.add(txtCpfTitular);
		
		lblNumeroDoCarto = new JLabel("Numero do Cartão");
		lblNumeroDoCarto.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNumeroDoCarto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDoCarto.setBounds(10, 80, 150, 20);
		panelPagamento.add(lblNumeroDoCarto);
		
		txtNumeroCartao = new JTextField();
		txtNumeroCartao.setColumns(10);
		txtNumeroCartao.setBounds(165, 80, 346, 30);
		panelPagamento.add(txtNumeroCartao);
		
		lblCdgioSegurana = new JLabel("Códgio Segurança");
		lblCdgioSegurana.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCdgioSegurana.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdgioSegurana.setBounds(10, 110, 150, 20);
		panelPagamento.add(lblCdgioSegurana);
		
		txtCodigoSeguranca = new JTextField();
		txtCodigoSeguranca.setColumns(10);
		txtCodigoSeguranca.setBounds(165, 110, 90, 30);
		panelPagamento.add(txtCodigoSeguranca);
		
		lblValidade = new JLabel("Validade");
		lblValidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValidade.setBounds(267, 110, 73, 20);
		panelPagamento.add(lblValidade);
		
		dataValidadeChooser = new JDateChooser();
		dataValidadeChooser.setBounds(352, 109, 159, 30);
		panelPagamento.add(dataValidadeChooser);
		
		btnFazerPagamento = new JButton("Fazer Pagamento");
		btnFazerPagamento.setBounds(350, 165, 230, 30);
		panelPagamento.add(btnFazerPagamento);
		
		btnConcluir = new JButton("Concluir");
		btnConcluir.setBounds(646, 402, 100, 78);
		getContentPane().add(btnConcluir);
		
		setSize(800, 600);
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
