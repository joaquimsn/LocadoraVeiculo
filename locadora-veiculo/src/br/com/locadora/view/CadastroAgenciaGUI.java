package br.com.locadora.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

public class CadastroAgenciaGUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNome;
	private JLabel lblOi;

	/**
	 * Create the panel.
	 */
	public CadastroAgenciaGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 100, 50, 200};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		add(lblNome, gbc_lblNome);
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);
		lblOi = new JLabel("OI");
		GridBagConstraints gbc_lblOi = new GridBagConstraints();
		gbc_lblOi.insets = new Insets(0, 0, 5, 5);
		gbc_lblOi.gridx = 2;
		gbc_lblOi.gridy = 0;
		add(lblOi, gbc_lblOi);
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 0;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

	}
}
