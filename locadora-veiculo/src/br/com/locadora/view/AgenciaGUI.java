package br.com.locadora.view;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.locadora.view.componentes.BotoesCrudComponente;
import br.com.locadora.view.componentes.FormularioEnderecoComponente;

public class AgenciaGUI extends JPanel implements Serializable{
	private static final long serialVersionUID = 48295538249135551L;
	
	private JLabel lblRazoSocial;
	private JTextField txtRazaoSocial;
	private JLabel lblFantasia;
	private JTextField txtFantasia;
	private JLabel lblCnpj;
	private JTextField txtCnpj;
	private JLabel lblInscEstadual;
	private JTextField txtIncEstadual;
	private JLabel lblResponsavel;
	private JTextField textField;
	
	private String tituloTela;
	
	public AgenciaGUI() {
		inicializar();
	}
	
	/**
	 * Cria o panel agência com um titulo
	 * @param tituloPanel Titulo do panel 
	 * @author Joaquim Neto
	 */
	public AgenciaGUI(String tituloTela) {
		this.tituloTela = tituloTela;
	}
	
	/**Inicializa todos os componetes da tela veículo
	 * @author Joaquim Neto
	 */
	private void inicializar() {
		setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), tituloTela, TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		setLayout(null);
		
		lblRazoSocial = new JLabel("Razão Social");
		lblRazoSocial.setBounds(35, 40, 125, 20);
		add(lblRazoSocial);
		
		txtRazaoSocial = new JTextField();
		txtRazaoSocial.setBounds(30, 60, 800, 30);
		add(txtRazaoSocial);
		txtRazaoSocial.setColumns(10);
		
		lblFantasia = new JLabel("Fantasia");
		lblFantasia.setBounds(35, 90, 125, 20);
		add(lblFantasia);
		
		txtFantasia = new JTextField();
		txtFantasia.setColumns(10);
		txtFantasia.setBounds(30, 110, 370, 30);
		add(txtFantasia);
		
		lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(410, 90, 125, 20);
		add(lblCnpj);
		
		txtCnpj = new JTextField();
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(405, 110, 220, 30);
		add(txtCnpj);
		
		lblInscEstadual = new JLabel("Insc. Estadual");
		lblInscEstadual.setBounds(638, 90, 125, 20);
		add(lblInscEstadual);
		
		txtIncEstadual = new JTextField();
		txtIncEstadual.setColumns(10);
		txtIncEstadual.setBounds(630, 110, 200, 30);
		add(txtIncEstadual);
		
		lblResponsavel = new JLabel("Responsavel");
		lblResponsavel.setBounds(35, 145, 125, 20);
		add(lblResponsavel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(30, 165, 600, 30);
		add(textField);
		
		// Componete formulário para endereço
		FormularioEnderecoComponente formularioEndereco = new FormularioEnderecoComponente();
		formularioEndereco.setBounds(30, 200, 800, 170);
		add(formularioEndereco);
		
		// Componente botões
		BotoesCrudComponente botoesCrudComponente = new BotoesCrudComponente();
		botoesCrudComponente.setBounds(648, 408, 176, 46);
		add(botoesCrudComponente);
		
		this.setBounds(15, 10, 859, 500);
		this.setVisible(true);
	}
}
