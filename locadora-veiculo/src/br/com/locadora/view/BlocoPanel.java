package br.com.locadora.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BlocoPanel extends JPanel {
	private JPanel panel;
	private JLabel lblUsurio;
	private JTextField textField;
	private JPanel panel_1;
	private JLabel lblTeste;
	private JButton btnOk;
	private JButton button;
	private JButton button_1;

	/**
	 * Create the panel.
	 */
	public BlocoPanel() {
		setLayout(null);
		panel = new JPanel();
		panel.setBounds(76, 24, 300, 100);
		add(panel);
		panel.setLayout(null);
		lblUsurio = new JLabel("Usuário");
		lblUsurio.setBounds(15, 10, 70, 15);
		panel.add(lblUsurio);
		textField = new JTextField();
		textField.setBounds(90, 10, 150, 20);
		panel.add(textField);
		textField.setColumns(10);
		button_1 = new JButton("OK");
		button_1.setBounds(158, 63, 75, 25);
		panel.add(button_1);
		panel_1 = new JPanel();
		panel_1.setBounds(75, 133, 200, 100);
		add(panel_1);
		panel_1.setLayout(null);
		lblTeste = new JLabel("Teste");
		lblTeste.setBounds(10, 5, 40, 15);
		panel_1.add(lblTeste);
		btnOk = new JButton("OK");
		btnOk.setBounds(12, 51, 75, 25);
		panel_1.add(btnOk);
		button = new JButton("OK");
		button.setBounds(101, 51, 75, 25);
		panel_1.add(button);
		
		this.setVisible(true);
		this.setSize(600, 500);
	}
}
