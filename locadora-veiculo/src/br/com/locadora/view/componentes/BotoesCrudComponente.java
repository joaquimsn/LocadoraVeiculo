package br.com.locadora.view.componentes;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class BotoesCrudComponente extends JPanel {
	private JButton btnSalvar;
	private JButton btnCancelar;

	public BotoesCrudComponente() {
		inicializar();
	}
	private void inicializar() {
		setLayout(new GridLayout(1, 2, 10, 10));
		
		btnCancelar = new JButton("Cancelar");
		add(btnCancelar);
		
		btnSalvar = new JButton("Salvar");
		add(btnSalvar);
	}

}
