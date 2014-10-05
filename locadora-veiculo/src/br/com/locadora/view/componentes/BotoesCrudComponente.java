package br.com.locadora.view.componentes;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.locadora.utils.locale.LocaleUtils;

public class BotoesCrudComponente extends JPanel {
	private static final long serialVersionUID = -9047999478547788235L;
	
	public JButton btnSalvar;
	public JButton btnCancelar;

	public BotoesCrudComponente() {
		inicializar();
	}
	private void inicializar() {
		setLayout(new GridLayout(1, 2, 10, 10));
		
		btnCancelar = new JButton(LocaleUtils.getLocaleView().getString("btn_cancelar"));
		add(btnCancelar);
		
		btnSalvar = new JButton(LocaleUtils.getLocaleView().getString("btn_salvar"));
		add(btnSalvar);
	}

}
