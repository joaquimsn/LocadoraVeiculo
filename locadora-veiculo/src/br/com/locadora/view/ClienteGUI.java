package br.com.locadora.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.locadora.controller.AgenciaControl;
import br.com.locadora.controller.ClienteControl;
import br.com.locadora.model.entity.Agencia;
import br.com.locadora.model.entity.Cliente;
import br.com.locadora.utils.SystemUtils;
import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.componentes.BotoesCrudComponente;
import br.com.locadora.view.componentes.FormularioEnderecoComponente;

import com.toedter.calendar.JDateChooser;

public class ClienteGUI extends JPanel {
	private static final long serialVersionUID = 9025986133093083364L;
	
	// Labels
	private JLabel lblNome;
	private JLabel lblGenero;
	private JLabel lblDataNascimento;
	private JLabel lblCpf;
	private JLabel lblRg;
	private JLabel lblEstadoEmissor;
	private JLabel lblCnh;
	private JLabel lblVencimentoCnh;
	
	// Inputs
	private JTextField txtNome;
	private JComboBox cbxGenero;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JDateChooser dataNascimentoChooser;
	private JTextField txtEstadoEmissor;
	private JTextField txtCnh;
	private JDateChooser dataVencimentoCnh;
	
	private FormularioEnderecoComponente formularioEndereco;
	
	private String tituloTela;
	private int idCliente;
	
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
		
		txtNome = new JTextField(10);
		txtNome.setBounds(30, 60, 400, 30);
		add(txtNome);
		
		lblGenero = new JLabel(LocaleUtils.getLocaleView().getString("lbl_genero"));
		lblGenero.setBounds(440, 40, 125, 20);
		add(lblGenero);
		
		cbxGenero = new JComboBox();
		cbxGenero.setBounds(435, 60, 190, 30);
		add(cbxGenero);
		
		lblDataNascimento = new JLabel(LocaleUtils.getLocaleView().getString("lbl_data_nasc"));
		lblDataNascimento.setBounds(635, 40, 125, 20);
		add(lblDataNascimento);
		
		dataNascimentoChooser = new JDateChooser(new Date());
		dataNascimentoChooser.setLocale(LocaleUtils.getLocaleView().getLocale());
		dataNascimentoChooser.setBounds(635, 60, 200, 30);
		add(dataNascimentoChooser);
		
		lblCpf = new JLabel(LocaleUtils.getLocaleView().getString("lbl_cpf"));
		lblCpf.setBounds(35, 90, 125, 20);
		add(lblCpf);
		
		txtCpf = new JTextField(10);
		txtCpf.setBounds(30, 110, 200, 30);
		add(txtCpf);
		
		lblRg = new JLabel(LocaleUtils.getLocaleView().getString("lbl_rg"));
		lblRg.setBounds(240, 90, 125, 20);
		add(lblRg);
		
		lblCnh = new JLabel(LocaleUtils.getLocaleView().getString("lbl_cnh"));
		lblCnh.setBounds(440, 90, 125, 20);
		add(lblCnh);
		
		txtCnh = new JTextField(10);
		txtCnh.setBounds(435, 111, 195, 30);
		add(txtCnh);
		
		txtRg = new JTextField(10);
		txtRg.setBounds(235, 110, 195, 30);
		add(txtRg);
		
		lblEstadoEmissor = new JLabel(LocaleUtils.getLocaleView().getString("lbl_estado_emissor"));
		lblEstadoEmissor.setBounds(35, 145, 125, 20);
		add(lblEstadoEmissor);
		
		txtEstadoEmissor = new JTextField(10);
		txtEstadoEmissor.setBounds(30, 165, 150, 30);
		add(txtEstadoEmissor);
		
		lblVencimentoCnh = new JLabel(LocaleUtils.getLocaleView().getString("lbl_data_vencimento"));
		lblVencimentoCnh.setBounds(640, 90, 190, 20);
		add(lblVencimentoCnh);
		
		dataVencimentoCnh = new JDateChooser();
		dataVencimentoCnh.setLocale(LocaleUtils.getLocaleView().getLocale());
		dataVencimentoCnh.setMinSelectableDate(new Date());
		dataVencimentoCnh.setBounds(635, 110, 200, 30);
		add(dataVencimentoCnh);
		
		// Componete formulário para endereço
		formularioEndereco = new FormularioEnderecoComponente();
		formularioEndereco.setBounds(30, 200, 800, 170);
		add(formularioEndereco);
		
		// Componente botões
		BotoesCrudComponente botoesCrudComponente = new BotoesCrudComponente();
		botoesCrudComponente.setBounds(623, 408, 200, 45);
		add(botoesCrudComponente);
		
		this.setBounds(15, 10, 859, 500);
		this.setVisible(true);
		
		/*
		 * EVENTOS DOS BOTÕES
		 */
		botoesCrudComponente.btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				
				// Preenche o objeto agência com as informações infromada pelo usuário
				cliente.setId(idCliente);
				cliente.setNome(txtNome.getText());
				cliente.setCpf(txtCpf.getText());
				cliente.setRg(txtRg.getText());
				cliente.setDataNascimento((java.sql.Date) dataNascimentoChooser.getDate());
				cliente.setCnh(txtCnh.getText());
				cliente.setValidadeCnh((java.sql.Date) dataVencimentoCnh.getDate());
				cliente.setEstadoEmissor(txtEstadoEmissor.getText());
				//TODO cliente.setGenero(cbxGenero.getSelectedItem());
				cliente.setLogradouro(formularioEndereco.getEndereco().getLogradouro());
				cliente.setNumero(formularioEndereco.getEndereco().getNumero());
				cliente.setBairro(formularioEndereco.getEndereco().getBairro());
				cliente.setCep(formularioEndereco.getEndereco().getCep());
				cliente.setUf(formularioEndereco.getEndereco().getUf());
				cliente.setCidade(formularioEndereco.getEndereco().getCidade());
				cliente.setTelefone(formularioEndereco.getEndereco().getTelefone());
				cliente.setEmail(formularioEndereco.getEndereco().getEmail());
				cliente.setAtivo(true);
				
				// Valida os dados preenchido pelo usuário
				if (!validar(cliente)) {
					return;
				}
				
				// Persiste o objeto agência
				ClienteControl clienteControl = new ClienteControl();
				
				// Verifica se foi cadastrado com sucesso
				if (clienteControl.salvarOuAlterar(cliente)) {
					// Limpa os campos preenchidos
					limparCampos();
					formularioEndereco.limparCampos();
				} else {
					JOptionPane.showMessageDialog(lblNome, LocaleUtils.getLocaleMessages().getString("falha_errofatal"));
				}
			}
		});
		
		botoesCrudComponente.btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
	}
	
	/**
	 * Valida os campos preenchido pelo usuário
	 * @author Joaquim Neto
	 * @param cliente Objeto Cliente
	 * @return <b>true</b> Se for valido
	 */
	private boolean validar(Cliente cliente) {
		
		// Verifica se os campos obrigatorios referente a cliente foram preenchido
		if (!SystemUtils.isCamposObrigatoriosPreenchidos(cliente)) {
			return false;
		}
		
		// Verifica se os campos obrigatorios referente ao endereço foram preenchido
		if (!SystemUtils.isCamposObrigatoriosPreenchidos(formularioEndereco.getEndereco())) {
			return false;
		}
		
		// Valida o cnpj
		if (!SystemUtils.isCpfValido(cliente.getCpf())) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Limpa todos os campos preenchidos pelo usuário
	 * @author Joaquim Neto
	 */
	private void limparCampos() {
		// Limpa os valores fields cliente
		txtCnh.setText("");
		txtCpf.setText("");
		txtEstadoEmissor.setText("");
		txtNome.setText("");
		txtRg.setText("");
	}
	
	/**
	 * Preenche os campos da tela agência com os valores obtidos do 
	 * objeto Agência passado por parâmentro
	 * @author Joaquim Neto
	 * @param cliente Objeto agência
	 */
	public void preencherCampos(Cliente cliente) {
		if (!SystemUtils.isNuloOuVazio(cliente)) {
			idCliente = cliente.getId();
			txtCnh.setText(cliente.getCnh());
			txtCpf.setText(cliente.getCpf());
			txtEstadoEmissor.setText(cliente.getEstadoEmissor());
			txtNome.setText(cliente.getNome());
			txtRg.setText(cliente.getRg());			
			// Preenche o endereço
			formularioEndereco.preencherEndereco(cliente.getEndereco());
		}
	}
}
