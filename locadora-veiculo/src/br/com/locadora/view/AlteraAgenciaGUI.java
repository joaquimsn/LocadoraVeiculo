package br.com.locadora.view;

import javax.swing.JDialog;

public class AlteraAgenciaGUI extends JDialog{
	private static final long serialVersionUID = 4409640219728827933L;

	public AlteraAgenciaGUI() {
		AgenciaGUI agenciaGUI = new AgenciaGUI();
		
		setLayout(null);
		add(agenciaGUI);
		agenciaGUI.setBounds(10, 10, 859, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
