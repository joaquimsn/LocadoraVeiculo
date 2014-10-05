package br.com.locadora.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.locadora.controller.Autenticacao;
import br.com.locadora.model.enums.LocaleEnum;
import br.com.locadora.utils.SystemUtils;
import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.componentes.CustomComboBox;
import br.com.locadora.view.componentes.InputSoTexto;

public class LoginGUI extends JFrame implements ItemListener{
	private static final long serialVersionUID = -3763913627489904669L;
	
	// labels para os inputs
	private JLabel lblIdioma;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JLabel lblCodigoAgencia;
	
	// combobox customizado para selecionar o idioma que o sistema será apresentado
	private CustomComboBox cbxSelecaoIdioma;
	
	// inputs
	private JTextField txtUsuario;
	private JTextField txtCodigoAgencia;
	private JPasswordField passwordField;
	
	// panels
	private JPanel panelCabecalho;
	private JPanel panelLogin;
	private JPanel panelBotoesLogin;
	
	// buttons 
	private JButton btnCancelar;
	private JButton btnAcessar;
	
	/**
	 * Tela responsável para controlar o acesso ao sistema
	 * bloqueando as funcionalidades até que o login seja efetuado com sucesso
	 * @author Joaquim Neto
	 * @param frame Objeto JFrame
	 */
	public LoginGUI() {
		this.setTitle(LocaleUtils.getLocaleView().getString("titulo_tela_login"));
		
		// cria a tela de login
		inicializar();
	}
	
	/**Inicializa todos os componetes da tela de login
	 * @author Joaquim Neto
	 */
	public void inicializar() {
		/*======================================
		 *  Instância as label da tela de login
		 * =====================================
		 */		
		lblIdioma = new JLabel(LocaleUtils.getLocaleView().getString("lbl_escolha_idioma"));
		lblIdioma.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		lblIdioma.setHorizontalAlignment(SwingConstants.RIGHT);

		lblUsuario = new JLabel(LocaleUtils.getLocaleView().getString("lbl_usuario"));
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);

		lblSenha = new JLabel(LocaleUtils.getLocaleView().getString("lbl_senha"));
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblCodigoAgencia = new JLabel(LocaleUtils.getLocaleView().getString("lbl_codigo_agencia"));
		lblCodigoAgencia.setHorizontalAlignment(SwingConstants.RIGHT);

		// Cria o cabecalho
		panelCabecalho = new JPanel(null);
		panelCabecalho.setBounds(0, 5, 400, 160);
		// logo para exibição no login
		ImageIcon iconLogoSistema = new ImageIcon(ClassLoader.getSystemResource("br/com/locadora/resoureces/images/logo-default.png"));
		JLabel logoSistema = new JLabel(iconLogoSistema);
		logoSistema.setBounds(100, 60, 180, 90);
		
		lblIdioma.setBounds(100, 15, 100, 34);
		panelCabecalho.add(lblIdioma);
		
		//ComboBox customizado para escolha do idioma
		cbxSelecaoIdioma = new CustomComboBox();
		
		// Obtém o index do idioma default selecionado 
		int index = LocaleEnum.getValueByDisplay(LocaleUtils.getDisplayLocale());
		// Deixa selecionado o idioma default no combobox
		cbxSelecaoIdioma.bandeiraList.setSelectedIndex(index);
		cbxSelecaoIdioma.bandeiraList.addItemListener(this);
		cbxSelecaoIdioma.setBounds(200, -5, 200, 55);
		panelCabecalho.add(cbxSelecaoIdioma);
		panelCabecalho.add(lblIdioma);
		
		// Adiciona a logo ao panel
		panelCabecalho.add(logoSistema);
		
		// Cria o panel com as informações do login
		panelLogin = new JPanel(null);
		panelLogin.setBounds(25, 160, 350, 110);
		
		// Input campo usuário
		InputSoTexto inputSoTexto = new InputSoTexto();
		txtUsuario = new JTextField(20);
		txtUsuario.setInputVerifier(inputSoTexto);
		lblUsuario.setBounds(10, 5, 100, 30);
		txtUsuario.setBounds(115, 5, 180, 30);
		panelLogin.add(lblUsuario);
		panelLogin.add(txtUsuario);
		
		// Input campo senha
		passwordField = new JPasswordField();
		lblSenha.setBounds(10, 40, 100, 30);
		passwordField.setBounds(115, 40, 180, 30);
		panelLogin.add(lblSenha);
		panelLogin.add(passwordField);
		
		// Input campo códifo agência
		txtCodigoAgencia = new JTextField(10);
		lblCodigoAgencia.setBounds(10, 80, 100, 30);
		txtCodigoAgencia.setBounds(115, 80, 75, 30);
		panelLogin.add(lblCodigoAgencia);
		panelLogin.add(txtCodigoAgencia);
		
		// Cria o panel dos botões da tela de login
		panelBotoesLogin = new JPanel(null);
		panelBotoesLogin.setBounds(180, 270, 220, 50);
		
		btnAcessar = new JButton(LocaleUtils.getLocaleView().getString("btn_acessar"));
		btnAcessar.setBounds(5, 10, 100, 30);
		panelBotoesLogin.add(btnAcessar);
		
		btnCancelar = new JButton(LocaleUtils.getLocaleView().getString("btn_cancelar"));
		btnCancelar.setBounds(110, 10, 100, 30);
		panelBotoesLogin.add(btnCancelar);
		
		
		JPanel panelcontainer = new JPanel(null);
		panelcontainer.setSize(new Dimension(400, 350));
		panelcontainer.add(panelCabecalho);
		panelcontainer.add(panelLogin);
		panelcontainer.add(panelBotoesLogin);
		
		Container container = getContentPane();
		container.add(panelcontainer);
		
		this.setLayout(null);
		this.add(panelcontainer);
		this.setSize(400, 350);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		
		/*==========================================================
		 * Eventos dos botões
		 *===========================================================*/
		
		// Encerra a execução do sistema
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(EXIT_ON_CLOSE);
			}
		});
		
		// Faz a validação do login
		btnAcessar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Armazena a mensagem de erro do login
				StringBuilder mensagemErro = new StringBuilder();
				String usuario = txtUsuario.getText(); // Obtém a String que representa o usuário
				String senha = String.valueOf(passwordField.getPassword()); // Obtém a String que representa a senha
				String codigoAgencia = txtCodigoAgencia.getText();
				
				// Verifica se usuário foi preenchido
				if (SystemUtils.isNuloOuVazio(usuario) || usuario.length() == 0 ) {
					mensagemErro.append("O usuário não foi informado");
				
				// Verifica se a senha foi preenchida
				} 
				
				if (SystemUtils.isNuloOuVazio(senha) || senha.length() == 0) {
					mensagemErro.append("\n A senha não foi informada");
				
				// Verifica se foi gerada uma mesagem de erro
				} 
				
				if (SystemUtils.isNuloOuVazio(codigoAgencia) || codigoAgencia.length() == 0){
					mensagemErro.append("\nA agência é obrigatória");
				}
				
				if (mensagemErro.length() > 0) {
					JOptionPane.showMessageDialog(panelCabecalho, mensagemErro);
					return;
				}
				
				// Valida o usuário, senha e código da agência
				if (Autenticacao.autenticar(usuario, senha, codigoAgencia)) {
					dispose();
					new TelaPrincipalGUI();
				} else {
					// Limpa o campo senha
					passwordField.setText("");
					JOptionPane.showMessageDialog(panelCabecalho, LocaleUtils.getLocaleMessages().getString("falha_login"));
				}
				
			}
		});
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// Faz a troca do idioma
		if (e.getSource() == cbxSelecaoIdioma.bandeiraList && cbxSelecaoIdioma.bandeiraList.getSelectedIndex() 
				!= LocaleEnum.getValueByDisplay(LocaleUtils.getDisplayLocale())) {
			
			// Obtém a localeID
			String localeId = LocaleEnum.getDisplayByValue((Integer) cbxSelecaoIdioma.bandeiraList.getSelectedItem());
			LocaleUtils.setLocaleId(localeId, true);
			
			// Fecha a janela atual
			dispose();
			
			// Abre uma nova tela de login no idioma selecionado
			new LoginGUI();
		}
		
	}
}