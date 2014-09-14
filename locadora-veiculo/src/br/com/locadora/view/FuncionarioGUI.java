package br.com.locadora.view;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.componentes.BotoesCrudComponente;
import br.com.locadora.view.componentes.FormularioEnderecoComponente;

public class FuncionarioGUI extends JPanel implements Serializable {
	private static final long serialVersionUID = -49360159640708649L;
	
	// Labels
	private JLabel lblNome;
	private JLabel lblGenero;
	private JLabel lblDataNascimento;
	private JLabel lblCpf;
	private JLabel lblRg;
	private JLabel lblCodigoAgencia;
	private JLabel lblNvel;
	private JLabel lblResponsavel;
	
	// Inputs
	private JTextField txtNome;
	private JComboBox cbxGenero;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JDateChooser dataNascimentoChooser;
	private JComboBox cbxNivel;
	private JTextField txtCodigoAgencia;
	private JComboBox cbxSupervisor;
	
	private String tituloTela;
	
	public FuncionarioGUI() {
		inicializar();
	}
	
	/**
	 * Cria o panel funcionário com um titulo passado por parâmetro
	 * @param tituloPanel Titulo do panel 
	 * @author Joaquim Neto
	 */
	public FuncionarioGUI(String tituloTela) {
		this.tituloTela = tituloTela;
		inicializar();
	}
	
	/**Inicializa todos os componetes da tela
	 * @author Joaquim Neto
	 */
	private void inicializar() {
		setLayout(null);
		setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1, true), tituloTela, TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		
		lblNome = new JLabel(LocaleUtils.getLocaleView().getString("lbl_nome"));
		lblNome.setBounds(35, 40, 125, 20);
		add(lblNome);
		
		txtNome = new JTextField(10);
		txtNome.setBounds(30, 60, 400, 30);
		add(txtNome);
		
		lblGenero = new JLabel(LocaleUtils.getLocaleView().getString("lbl_genero"));
		lblGenero.setBounds(440, 40, 125, 20);
		add(lblGenero);
		
		cbxGenero = new JComboBox();
		cbxGenero.setBounds(435, 60, 190, 30);
		add(cbxGenero);
		
		lblDataNascimento = new JLabel(LocaleUtils.getLocaleView().getString("lbl_data_nasc"));
		lblDataNascimento.setBounds(635, 40, 125, 20);
		add(lblDataNascimento);
		
		dataNascimentoChooser = new JDateChooser();
		dataNascimentoChooser.setLocale(LocaleUtils.getLocaleView().getLocale());
		dataNascimentoChooser.setBounds(630, 60, 200, 30);
		add(dataNascimentoChooser);
		
		lblCpf = new JLabel(LocaleUtils.getLocaleView().getString("lbl_cpf"));
		lblCpf.setBounds(35, 90, 125, 20);
		add(lblCpf);
		
		txtCpf = new JTextField(10);
		txtCpf.setBounds(30, 110, 200, 30);
		add(txtCpf);
		
		lblRg = new JLabel(LocaleUtils.getLocaleView().getString("lbl_rg"));
		lblRg.setBounds(240, 90, 125, 20);
		add(lblRg);
		
		lblNvel = new JLabel(LocaleUtils.getLocaleView().getString("lbl_nivel_acesso"));
		lblNvel.setBounds(445, 90, 125, 20);
		add(lblNvel);
		
		cbxNivel = new JComboBox();
		cbxNivel.setBounds(435, 110, 395, 30);
		add(cbxNivel);
		
		txtRg = new JTextField(10);
		txtRg.setBounds(235, 110, 195, 30);
		add(txtRg);
		
		lblCodigoAgencia = new JLabel(LocaleUtils.getLocaleView().getString("lbl_codigo_agencia"));
		lblCodigoAgencia.setBounds(35, 145, 125, 20);
		add(lblCodigoAgencia);
		
		txtCodigoAgencia = new JTextField(10);
		txtCodigoAgencia.setBounds(30, 165, 150, 30);
		add(txtCodigoAgencia);
		
		lblResponsavel = new JLabel(LocaleUtils.getLocaleView().getString("lbl_supervisor"));
		lblResponsavel.setBounds(195, 145, 125, 20);
		add(lblResponsavel);
		
		cbxSupervisor = new JComboBox();
		cbxSupervisor.setBounds(185, 165, 500, 30);
		add(cbxSupervisor);
		
		
		// Componete formulário para endereço
		FormularioEnderecoComponente formularioEndereco = new FormularioEnderecoComponente();
		formularioEndereco.setBounds(30, 200, 800, 170);
		add(formularioEndereco);
		
		// Componente botões
		BotoesCrudComponente botoesCrudComponente = new BotoesCrudComponente();
		botoesCrudComponente.setBounds(623, 408, 200, 45);
		add(botoesCrudComponente);
		
		this.setBounds(15, 10, 859, 500);
		this.setVisible(true);
	}
}
