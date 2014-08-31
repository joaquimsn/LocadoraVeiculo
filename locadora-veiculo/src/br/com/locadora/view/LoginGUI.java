package br.com.locadora.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.locadora.utils.locale.LocaleUtils;

public class LoginGUI extends JDialog {
	private JLabel lblIdioma;
	private JComboBox cbxSelecaoIdioma;
	private JPanel panelLogin;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblSenha;
	private JPasswordField passwordField;
	private JPanel panelBotoesLogin;
	private JButton btnCancelar;
	private JButton btnAcessar;
	private JLabel lblAgencia;

	public LoginGUI(JFrame frame) {
		
		final JFrame f = frame;
		
		lblIdioma = new JLabel("Idioma");
		lblIdioma.setFont(new Font("Lucida Sans", Font.PLAIN, 13));

		cbxSelecaoIdioma = new JComboBox();

		panelLogin = new JPanel();

		panelBotoesLogin = new JPanel(new FlowLayout());

		// Teste Internacionalização
		JButton buttonPt = new JButton("Portugues");
		JButton buttonEn = new JButton("Ingles");
		JButton buttonEs = new JButton("Espanhol");

		buttonEn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LocaleUtils.setLocaleId("en_US", false);
				f.setEnabled(true);
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				txtUsuario.setText(LocaleUtils.getLocaleView().getString("titulo_sys"));
				f.repaint();
				repaint();
			}
		});

		buttonPt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LocaleUtils.setLocaleId("pt_BR", false);
				txtUsuario.setText(LocaleUtils.getLocaleView().getString("titulo_sys"));
				repaint();
			}
		});

		buttonEs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LocaleUtils.setLocaleId("es_ES", false);
				txtUsuario.setText(LocaleUtils.getLocaleView().getString("titulo_sys"));
				repaint();
			}
		});

		panelBotoesLogin.add(buttonPt);
		panelBotoesLogin.add(buttonEn);
		panelBotoesLogin.add(buttonEs);

		btnCancelar = new JButton("Cancelar");
		panelBotoesLogin.add(btnCancelar);

		btnAcessar = new JButton("Acessar");
		panelBotoesLogin.add(btnAcessar);
		
		panelLogin.setLayout(null);

		lblUsuario = new JLabel("Usuário");
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setBounds(2, 8, 48, 15);
		panelLogin.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(62, 2, 167, 27);
		panelLogin.add(txtUsuario);
		txtUsuario.setColumns(10);

		lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha.setBounds(2, 47, 40, 15);
		panelLogin.add(lblSenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(62, 41, 167, 27);
		panelLogin.add(passwordField);

		lblAgencia = new JLabel("Agência");
		lblAgencia.setHorizontalAlignment(SwingConstants.LEFT);
		lblAgencia.setBounds(2, 85, 60, 15);
		panelLogin.add(lblAgencia);

		add(panelLogin);
		add(panelBotoesLogin);
		// comboBox = new JComboBox();
		// comboBox.setBounds(62, 80, 102, 25);
		// panelLogin.add(comboBox);

		panelLogin.setSize(400, 200);

		setLayout(new BorderLayout());
		this.add(panelLogin, BorderLayout.CENTER);
		this.add(panelBotoesLogin, BorderLayout.SOUTH);

		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				// System.exit(DISPOSE_ON_CLOSE);
			}
		});

	}
}
