package br.com.locadora.view;

import javax.swing.JPanel;

public class InformacaoInicialGUI extends JPanel {
	private JPanel panel;

	public InformacaoInicialGUI() {
		
		inicializar();
	}
	private void inicializar() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(78, 80, 394, 193);
		add(panel);
	}

}
