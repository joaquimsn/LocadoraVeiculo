package br.com.locadora.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.locadora.controller.AgenciaControl;
import br.com.locadora.model.entity.Agencia;
import br.com.locadora.utils.SystemUtils;
import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.componentes.BotoesCrudComponente;
import br.com.locadora.view.componentes.FormularioEnderecoComponente;
import br.com.locadora.view.componentes.InputSoNumeros;
import br.com.locadora.view.componentes.InputSoTexto;
import br.com.locadora.view.componentes.InputSoTextoNumeros;

public class AgenciaGUI extends JPanel implements Serializable{
	private static final long serialVersionUID = 48295538249135551L;
	
	private JLabel lblRazoSocial;
	private JTextField txtRazaoSocial;
	private JLabel lblFantasia;
	private JTextField txtFantasia;
	private JLabel lblCnpj;
	private JFormattedTextField txtCnpj;
	private JLabel lblInscEstadual;
	private JTextField txtIncEstadual;
	private JLabel lblResponsavel;
	private JTextField txtResponsavel;
	private FormularioEnderecoComponente formularioEndereco;
	
	private String tituloTela;
	
	public AgenciaGUI() {
		inicializar();
	}
	
	/**
	 * Cria o panel agência com um titulo
	 * @param tituloPanel Titulo do panel 
	 * @author Joaquim Neto
	 */
	public AgenciaGUI(String tituloTela) {
		this.tituloTela = tituloTela;
		inicializar();
	}
	
	/**Inicializa todos os componetes da tela veículo
	 * @author Joaquim Neto
	 */
	private void inicializar() {
		setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1, true), tituloTela, TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		setLayout(null);
		
		// InputVerifier para validações genéricas dos campos
		InputSoNumeros soNumeros = new InputSoNumeros();
		InputSoTextoNumeros soTextoNumeros = new InputSoTextoNumeros();
		InputSoTexto soTexto = new InputSoTexto();
		
		lblRazoSocial = new JLabel(LocaleUtils.getLocaleView().getString("lbl_razao_social"));
		lblRazoSocial.setBounds(35, 40, 125, 20);
		add(lblRazoSocial);
		
		txtRazaoSocial = new JTextField(10);
		txtRazaoSocial.setInputVerifier(soTextoNumeros); // Adiciona validação soTextoNumeros
		txtRazaoSocial.setBounds(30, 60, 800, 30);
		add(txtRazaoSocial);
		
		lblFantasia = new JLabel(LocaleUtils.getLocaleView().getString("lbl_nome_fantasia"));
		lblFantasia.setBounds(35, 90, 125, 20);
		add(lblFantasia);
		
		txtFantasia = new JTextField(10);
		txtFantasia.setInputVerifier(soTextoNumeros); // Adiciona validação soTextoNumeros
		txtFantasia.setBounds(30, 110, 370, 30);
		add(txtFantasia);
		
		lblCnpj = new JLabel(LocaleUtils.getLocaleView().getString("lbl_cnpj"));
		lblCnpj.setBounds(410, 90, 125, 20);
		add(lblCnpj);
		
		txtCnpj = new JFormattedTextField(Mask.maskCnpj());
		txtCnpj.setBounds(405, 110, 220, 30);
		add(txtCnpj);
		
		lblInscEstadual = new JLabel(LocaleUtils.getLocaleView().getString("lbl_insc_estadual"));
		lblInscEstadual.setBounds(638, 90, 125, 20);
		add(lblInscEstadual);
		
		txtIncEstadual = new JTextField(10);
		txtIncEstadual.setInputVerifier(soNumeros); // Adiciona validação soNumeros
		txtIncEstadual.setBounds(630, 110, 200, 30);
		add(txtIncEstadual);
		
		lblResponsavel = new JLabel(LocaleUtils.getLocaleView().getString("lbl_responsavel"));
		lblResponsavel.setBounds(35, 145, 125, 20);
		add(lblResponsavel);
		
		txtResponsavel = new JTextField(10);
		txtResponsavel.setInputVerifier(soTexto); // Adiciona validação soTexto
		txtResponsavel.setBounds(30, 165, 600, 30);
		add(txtResponsavel);
		
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
		
		botoesCrudComponente.btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Agencia agencia = new Agencia();
				
				// Preenche o objeto agência com as informações infromada pelo usuário
				agencia.setRazaoSocial(txtRazaoSocial.getText());
				agencia.setNomeFantasia(txtFantasia.getText());
				agencia.setCnpj(txtCnpj.getText());
				agencia.setInscricaoEstadual(txtIncEstadual.getText());
				agencia.setResponsavel(txtResponsavel.getText());
				agencia.setLogradouro(formularioEndereco.getEndereco().getLogradouro());
				agencia.setNumero(formularioEndereco.getEndereco().getNumero());
				agencia.setBairro(formularioEndereco.getEndereco().getBairro());
				agencia.setCep(formularioEndereco.getEndereco().getCep());
				agencia.setUf(formularioEndereco.getEndereco().getUf());
				agencia.setCidade(formularioEndereco.getEndereco().getCidade());
				agencia.setTelefone(formularioEndereco.getEndereco().getTelefone());
				agencia.setEmail(formularioEndereco.getEndereco().getEmail());
				agencia.setSite(formularioEndereco.getEndereco().getSite());
				
				// Valida os dados preenchido pelo usuário
				if (!validar(agencia)) {
					return;
				}
				
				// Persiste o objeto agência
				AgenciaControl agenciaControl = new AgenciaControl();
				agenciaControl.salvarOuAlterar(agencia);
				
				// Limpa os campos preenchidos
				limparCampos();
				formularioEndereco.limparCampos();
				
			}
		});
	}
	
	/**
	 * Valida os campos preenchido pelo usuário
	 * @author Joaquim Neto
	 * @param agencia Objeto Agencia
	 * @return <b>true</b> Se for valido
	 */
	private boolean validar(Agencia agencia) {
		
		// Verifica se os campos obrigatorios referente a agencia foram preenchido
		if (!SystemUtils.isCamposObrigatoriosPreenchidos(agencia)) {
			return false;
		}
		
		// Verifica se os campos obrigatorios referente ao endereço foram preenchido
		if (!SystemUtils.isCamposObrigatoriosPreenchidos(formularioEndereco.getEndereco())) {
			return false;
		}
		
		// Valida o cnpj
		if (!SystemUtils.isCnpjValido(agencia.getCnpj())) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Limpa todos os campos preenchidos pelo usuário
	 * @author Joaquim Neto
	 */
	private void limparCampos() {
		// Limpa os valores fields agência
		txtCnpj.setText("");
		txtFantasia.setText("");
		txtIncEstadual.setText("");
		txtRazaoSocial.setText("");
		txtResponsavel.setText("");
	}
}
