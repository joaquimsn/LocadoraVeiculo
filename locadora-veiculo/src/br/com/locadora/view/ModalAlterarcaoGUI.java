package br.com.locadora.view;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class ModalAlterarcaoGUI extends JDialog{
	private static final long serialVersionUID = 4409640219728827933L;
	
	private static JPanel panel;
	
	public ModalAlterarcaoGUI(JPanel panel, String tituloTela) {
		setTitle(tituloTela);
		this.panel = panel;
		
		setLayout(null);
		add(panel);
		panel.setBounds(10, 10, 859, 500);
		setLocationRelativeTo(null);
		setSize(880, 550);
		setVisible(true);
	}
}
