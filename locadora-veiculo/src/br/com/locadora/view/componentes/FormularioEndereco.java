package br.com.locadora.view.componentes;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

public class FormularioEndereco extends JPanel {
	private JLabel lblLogradouro;
	private JTextField txtLogradouro;
	private JLabel lblNumero;
	private JTextField textNumero;
	private JLabel lblBairro;
	private JTextField txtBairro;
	private JLabel lblCep;
	private JTextField txtCep;
	private JLabel lblUf;

	public FormularioEndereco() {
		lblLogradouro = new JLabel("Logradouro");
		txtLogradouro = new JTextField();
		txtLogradouro.setColumns(10);
		lblNumero = new JLabel("Numero");
		textNumero = new JTextField();
		textNumero.setColumns(10);
		lblBairro = new JLabel("Bairro");
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		lblCep = new JLabel("CEP");
		txtCep = new JTextField();
		txtCep.setColumns(10);
		lblUf = new JLabel("UF");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtLogradouro, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLogradouro)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCep)
							.addGap(252)
							.addComponent(lblUf)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(textNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(lblNumero)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBairro))
					.addGap(20))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogradouro)
						.addComponent(lblNumero)
						.addComponent(lblBairro))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtLogradouro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCep)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblUf))
					.addContainerGap(102, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
