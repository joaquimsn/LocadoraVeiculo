package br.com.locadora.view.componentes;

import java.io.Serializable;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FormularioEnderecoComponente extends JPanel implements Serializable{
	private static final long serialVersionUID = 2863741403200090086L;
	
	private JLabel lblLogradouro;
	private JTextField txtLogradouro;
	private JLabel lblNumero;
	private JTextField textNumero;
	private JLabel lblBairro;
	private JTextField txtBairro;
	private JLabel lblCep;
	private JTextField txtCep;
	private JLabel lblUf;
	private JComboBox cbxUf;
	private JLabel lblCidade;
	private JComboBox cbxCidade;
	private JLabel lblTelefone;
	private JTextField txtTelefone;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblSite;
	private JTextField txtSite;

	public FormularioEnderecoComponente() {

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
		
		cbxUf = new JComboBox();
		
		lblCidade = new JLabel("Cidade");
		
		cbxCidade = new JComboBox();
		
		lblTelefone = new JLabel("Telefone");
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		
		lblEmail = new JLabel("E-mail");
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		lblSite = new JLabel("Site");
		
		txtSite = new JTextField();
		txtSite.setColumns(10);
			
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtLogradouro, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblLogradouro)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblCep)
											.addGap(245)
											.addComponent(lblUf)
											.addGap(76)
											.addComponent(lblCidade)))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(18)
											.addComponent(textNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(26)
											.addComponent(lblNumero))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtEmail, Alignment.LEADING)
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
											.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(cbxUf, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtSite, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSite, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
										.addComponent(cbxCidade, 0, 272, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtBairro, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
								.addComponent(lblBairro)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(lblTelefone))
								.addComponent(txtTelefone))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblEmail)
							.addContainerGap(807, Short.MAX_VALUE))))
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
							.addComponent(lblTelefone)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCep)
										.addComponent(lblUf))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(2)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(cbxUf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(cbxCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
								.addComponent(lblCidade))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblEmail))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
									.addComponent(lblSite)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(138))
		);
		setLayout(groupLayout);

	}
}
