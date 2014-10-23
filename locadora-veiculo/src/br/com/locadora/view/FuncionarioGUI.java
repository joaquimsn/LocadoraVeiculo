package br.com.locadora.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.locadora.controller.AgenciaControl;
import br.com.locadora.controller.FuncionarioControl;
import br.com.locadora.model.entity.Agencia;
import br.com.locadora.model.entity.Funcionario;
import br.com.locadora.model.enums.GeneroEnum;
import br.com.locadora.model.enums.NivelUsuarioEnum;
import br.com.locadora.utils.SystemUtils;
import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.componentes.BotoesCrudComponente;
import br.com.locadora.view.componentes.FormularioEnderecoComponente;
import br.com.locadora.view.componentes.InputSoNumeros;
import br.com.locadora.view.componentes.InputSoTexto;
import br.com.locadora.view.componentes.InputSoTextoNumeros;

import com.toedter.calendar.JDateChooser;

public class FuncionarioGUI extends JPanel implements Serializable {
	private static final long serialVersionUID = -49360159640708649L;
	
	// Labels
	private JLabel lblNome;
	private JLabel lblGenero;
	private JLabel lblDataNascimento;
	private JLabel lblCpf;
	private JLabel lblRg;
	private JLabel lblCodigoAgencia;
	private JLabel lblNvel;
	private JLabel lblResponsavel;
	private JLabel lblNomeUsuario;
	
	// Inputs
	private JTextField txtNome;
	private JComboBox cbxGenero;
	private JFormattedTextField txtCpf;
	private JTextField txtRg;
	private JDateChooser dataNascimentoChooser;
	private JComboBox cbxNivel;
	private JComboBox cbxAgencia;
	private JComboBox cbxSupervisor;
	private JTextField txtNomeUsuario;
	
	private FormularioEnderecoComponente formularioEndereco;
	
	private String tituloTela;
	private int idFuncionario;
	
	private List<Funcionario> listaFuncionarioSupervisor;
	private List<Agencia> listaAgencia;
	
	private FuncionarioControl funcionarioControl;
	
	public FuncionarioGUI() {
		inicializar();
	}
	
	/**
	 * Cria o panel funcionário com um titulo passado por parâmetro
	 * @param tituloPanel Titulo do panel 
	 * @author Joaquim Neto
	 */
	public FuncionarioGUI(String tituloTela) {
		this.tituloTela = tituloTela;
		inicializar();
	}
	
	/**Inicializa todos os componetes da tela
	 * @author Joaquim Neto
	 */
	private void inicializar() {
		
		// Inicializa os objetos auxiliares
		inicializarLista();
		
		// InputVerifier para validações genéricas dos campos
		InputSoNumeros soNumeros = new InputSoNumeros();
		InputSoTextoNumeros soTextoNumeros = new InputSoTextoNumeros();
		InputSoTexto soTexto = new InputSoTexto();
				
		setLayout(null);
		setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1, true), tituloTela, TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		
		lblNome = new JLabel(LocaleUtils.getLocaleView().getString("lbl_nome"));
		lblNome.setBounds(35, 40, 125, 20);
		add(lblNome);
		
		txtNome = new JTextField(10);
		txtNome.setBounds(30, 60, 400, 30);
		txtNome.setInputVerifier(soTexto);
		add(txtNome);
		
		lblGenero = new JLabel(LocaleUtils.getLocaleView().getString("lbl_genero"));
		lblGenero.setBounds(440, 40, 125, 20);
		add(lblGenero);
		
		cbxGenero = new JComboBox(GeneroEnum.getDisplayList().toArray(new String[0]));
		cbxGenero.setBounds(435, 60, 190, 30);
		add(cbxGenero);
		
		lblDataNascimento = new JLabel(LocaleUtils.getLocaleView().getString("lbl_data_nasc"));
		lblDataNascimento.setBounds(635, 40, 125, 20);
		add(lblDataNascimento);
		
		dataNascimentoChooser = new JDateChooser();
		dataNascimentoChooser.setLocale(LocaleUtils.getLocaleView().getLocale());
		dataNascimentoChooser.setBounds(630, 60, 200, 30);
		add(dataNascimentoChooser);
		
		lblCpf = new JLabel(LocaleUtils.getLocaleView().getString("lbl_cpf"));
		lblCpf.setBounds(35, 90, 125, 20);
		add(lblCpf);
		
		txtCpf = new JFormattedTextField(Mask.maskCpf());
		txtCpf.setBounds(30, 110, 200, 30);
		add(txtCpf);
		
		lblRg = new JLabel(LocaleUtils.getLocaleView().getString("lbl_rg"));
		lblRg.setBounds(240, 90, 125, 20);
		add(lblRg);
		
		lblNvel = new JLabel(LocaleUtils.getLocaleView().getString("lbl_nivel_acesso"));
		lblNvel.setBounds(445, 90, 125, 20);
		add(lblNvel);
		
		cbxNivel = new JComboBox(NivelUsuarioEnum.getDisplayList().toArray(new String[0]));
		cbxNivel.setBounds(435, 110, 395, 30);
		add(cbxNivel);
		
		txtRg = new JTextField(10);
		txtRg.setInputVerifier(soTextoNumeros);
		txtRg.setBounds(235, 110, 195, 30);
		add(txtRg);
		
		lblCodigoAgencia = new JLabel(LocaleUtils.getLocaleView().getString("lbl_codigo_agencia"));
		lblCodigoAgencia.setBounds(35, 145, 125, 20);
		add(lblCodigoAgencia);
		
		cbxAgencia = new JComboBox(getAgencias());
		cbxAgencia.setBounds(30, 165, 235, 30);
		add(cbxAgencia);
		
		lblResponsavel = new JLabel(LocaleUtils.getLocaleView().getString("lbl_supervisor"));
		lblResponsavel.setBounds(280, 145, 125, 20);
		add(lblResponsavel);
		
		cbxSupervisor = new JComboBox(getSupervisores());
		cbxSupervisor.setBounds(270, 165, 350, 30);
		add(cbxSupervisor);
		
		lblNomeUsuario = new JLabel(LocaleUtils.getLocaleView().getString("lbl_usuario")	);
		lblNomeUsuario.setBounds(635, 145, 125, 20);
		add(lblNomeUsuario);
		
		txtNomeUsuario = new JTextField(10);
		txtNomeUsuario.setInputVerifier(soTexto);
		txtNomeUsuario.setBounds(625, 165, 200, 30);
		add(txtNomeUsuario);
		
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
				Funcionario funcionario = new Funcionario();
				
				// Preenche o objeto Funcionário com as informações infromada pelo usuário
				funcionario.setId(idFuncionario);
				funcionario.setNome(txtNome.getText());
				funcionario.setCpf(txtCpf.getText());
				funcionario.setRg(txtRg.getText());
				funcionario.setDataNascimento(dataNascimentoChooser.getDate());
				funcionario.setFuncionarioSupervisor(listaFuncionarioSupervisor.get(cbxSupervisor.getSelectedIndex()).getId());
				funcionario.setNivel(NivelUsuarioEnum.getValueByDisplay((String) cbxNivel.getSelectedItem()));
				funcionario.setUsuario(txtNomeUsuario.getText());
				funcionario.setGenero(GeneroEnum.getValueByDisplay((String) cbxNivel.getSelectedItem()));
				funcionario.setCodigoAgencia(listaAgencia.get(cbxAgencia.getSelectedIndex()).getIdAgencia());
				funcionario.setLogradouro(formularioEndereco.getEndereco().getLogradouro());
				funcionario.setNumero(formularioEndereco.getEndereco().getNumero());
				funcionario.setBairro(formularioEndereco.getEndereco().getBairro());
				funcionario.setCep(formularioEndereco.getEndereco().getCep());
				funcionario.setUf(formularioEndereco.getEndereco().getUf());
				funcionario.setCidade(formularioEndereco.getEndereco().getCidade());
				funcionario.setTelefone(formularioEndereco.getEndereco().getTelefone());
				funcionario.setEmail(formularioEndereco.getEndereco().getEmail());
				funcionario.setAtivo(true);
				
				// Valida os dados preenchido pelo usuário
				if (!validar(funcionario)) {
					return;
				}
				
				// Persiste o objeto Funcionário
				FuncionarioControl funcionarioControl = new FuncionarioControl();
				
				// Verifica se foi cadastrado com sucesso
				if (funcionarioControl.salvarOuAlterar(funcionario)) {
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
				int escolha = JOptionPane.showConfirmDialog(cbxSupervisor, LocaleUtils.getLocaleMessages().getString("aviso_perdadados"), 
						LocaleUtils.getLocaleMessages().getString("aviso_atencao"), JOptionPane.YES_NO_OPTION, 1);
				
				if (escolha == JOptionPane.YES_OPTION) {
					limparCampos();
				}
			}
		});
	}
	
	/**
	 * Array contendo os nomes dos funcionários supervisores
	 * @author Joaquim Neto
	 * @return Array de nomes
	 */
	private String[] getSupervisores() {
		String[] supervisores = new String[listaFuncionarioSupervisor.size()];
		for (int i = 0; i < listaFuncionarioSupervisor.size(); i++) {
			supervisores[i] = listaFuncionarioSupervisor.get(i).getNome();
		}
		
		return supervisores;
	}
	
	/**
	 * @author Joaquim Neto
	 * @return Array de Razão social
	 */
	private String[] getAgencias() {
		String[] agencias = new String[listaAgencia.size()];
		for (int i = 0; i < listaAgencia.size(); i++) {
			agencias[i] = listaAgencia.get(i).getRazaoSocial();
		}
		
		return agencias;
	}

	/**
	 * Inicializa as listas utilizadas pela tela
	 * @author Joaquim Neto
	 */
	private void inicializarLista() {
		funcionarioControl = new FuncionarioControl();
		AgenciaControl agenciaControl = new AgenciaControl();
		
		listaFuncionarioSupervisor = funcionarioControl.buscarTodosSupervisor();
		listaAgencia = agenciaControl.buscarTodos();
	}
	
	/**
	 * Valida os campos preenchido pelo usuário
	 * @author Joaquim Neto
	 * @param funcionario Objeto Funcionario
	 * @return <b>true</b> Se for valido
	 */
	private boolean validar(Funcionario funcionario) {
		
		// Verifica se os campos obrigatorios referente a funcionario foram preenchido
		if (!SystemUtils.isCamposObrigatoriosPreenchidos(funcionario)) {
			return false;
		}
		
		// Verifica se os campos obrigatorios referente ao endereço foram preenchido
		if (!SystemUtils.isCamposObrigatoriosPreenchidos(formularioEndereco.getEndereco())) {
			return false;
		}
		
		// Valida o cnpj
		if (!SystemUtils.isCpfValido(funcionario.getCpf())) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Limpa todos os campos preenchidos pelo usuário
	 * @author Joaquim Neto
	 */
	private void limparCampos() {
		// Limpa os valores fields funcionari
		txtNome.setText("");
		txtNomeUsuario.setText("");
		txtCpf.setText("");
		txtRg.setText("");
		
		formularioEndereco.limparCampos();
	}
	
	/**
	 * Preenche os campos da tela Funcionário com os valores obtidos do 
	 * objeto Agência passado por parâmentro
	 * @author Joaquim Neto
	 * @param funcionario Objeto Funcionário
	 */
	public void preencherCampos(Funcionario funcionario) {
		if (!SystemUtils.isNuloOuVazio(funcionario)) {
			idFuncionario = funcionario.getId();
			txtNome.setText(funcionario.getNome());
			txtCpf.setText(funcionario.getCpf());
			txtRg.setText(funcionario.getRg());
			txtNomeUsuario.setText(funcionario.getUsuario());
			cbxAgencia.setSelectedItem(funcionario.getAgencia().getRazaoSocial());
			cbxSupervisor.setSelectedItem(funcionario.getSupervisor().getNome());
			cbxGenero.setSelectedItem(GeneroEnum.getDisplayByValue(funcionario.getGenero()));
			cbxNivel.setSelectedItem(NivelUsuarioEnum.getDisplayByValue(funcionario.getNivel()));
			
			dataNascimentoChooser.setDate(funcionario.getDataNascimento());
			
			// Preenche o endereço
			formularioEndereco.preencherEndereco(funcionario.getEndereco());
		}
	}
}
