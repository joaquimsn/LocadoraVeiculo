package br.com.locadora.view.componentes;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBandeiras extends JPanel {

	private JButton btnBrasil;
	private JButton btnEspanha;
	private JButton btnUs;

	public PanelBandeiras() {
		// Cria os icons para os botões
		ImageIcon iconBrasil = new ImageIcon("./src/br/com/locadora/resoureces/images/icons/bandeira_brasil.png");
		ImageIcon iconEspanha = new ImageIcon("./src/br/com/locadora/resoureces/images/icons/bandeira_espanha.png");
		ImageIcon iconUs = new ImageIcon("./src/br/com/locadora/resoureces/images/icons/bandeira_us.png");
		
		btnBrasil = new JButton(iconBrasil);
		btnBrasil.setLocation(22, 5);
		btnBrasil.setSize(60, 30);
		btnEspanha = new JButton(iconEspanha);
		btnEspanha.setBounds(94, 5, 60, 30);
		btnUs = new JButton(iconUs);
		btnUs.setBounds(159, 5, 60, 30);
		setLayout(null);
		
		add(btnBrasil);
		add(btnEspanha);
		add(btnUs);
		
		setVisible(true);
		setSize(254, 37);
	}

}
