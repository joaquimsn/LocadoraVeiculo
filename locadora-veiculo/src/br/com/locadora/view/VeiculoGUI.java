package br.com.locadora.view;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.componentes.BotoesCrudComponente;

public class VeiculoGUI extends JPanel implements Serializable {
	private static final long serialVersionUID = -1390603165047810065L;
	
	// Labels
	private JLabel lblUf;
	private JLabel lblPlca;
	private JLabel lblGrupo;
	private JLabel lblCidade;
	private JLabel lblChassi;
	private JLabel lblModelo;
	private JLabel lblDataFab;
	private JLabel lblKmRodado;
	private JLabel lblAcessrios;
	private JLabel lblFabricante;
	private JLabel lblImagemVeiculo;
	private JLabel lblTarefaKmLivre;
	private JLabel lblTarefaKmControlado;
	
	// Panel para exibição da imagem do veículo
	private JPanel panelImagemVeiculo;
	
	// Inputs
	private JComboBox cbxUf;
	private JComboBox cbxCidade;
	private JComboBox cbxGrupo;
	private JTextField txtPlaca;
	private JTextField txtModelo;
	private JTextField txtDataFab;
	private JTextField txtChassi;
	private JTextField txtKmRodado;
	private JTextField txtFabricante;
	private JTextField txtAcessorios;
	private JTextField txtTarifaKmLivre;
	private JTextField txtDiretorioImagem;
	private JTextField txtTarifaKmControlado;
	
	private String tituloPanel;

	public VeiculoGUI() {
		// cria a tela de login
		inicializar();
	}
	
	/**
	 * Cria o panel veículo com um titulo
	 * @param tituloPanel Titulo do panel 
	 * @author Joaquim Neto
	 */
	public VeiculoGUI(String tituloPanel) {
		this.tituloPanel = tituloPanel;
		// cria a tela de login
		inicializar();
	}
	
	/**Inicializa todos os componetes da tela veículo
	 * @author Joaquim Neto
	 */
	private void inicializar() {
		
		setLayout(null);
		setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1, true), tituloPanel, TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		
		lblModelo = new JLabel(LocaleUtils.getLocaleView().getString("lbl_modelo"));
		lblModelo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblModelo.setBounds(346, 37, 125, 20);
		add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(346, 59, 306, 30);
		add(txtModelo);
		txtModelo.setColumns(10);
		
		panelImagemVeiculo = new JPanel();
		panelImagemVeiculo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelImagemVeiculo.setBounds(27, 45, 300, 200);
		add(panelImagemVeiculo);
		
		lblFabricante = new JLabel(LocaleUtils.getLocaleView().getString("lbl_fabricante"));
		lblFabricante.setBounds(674, 39, 125, 20);
		add(lblFabricante);
		
		txtFabricante = new JTextField();
		txtFabricante.setBounds(664, 59, 179, 30);
		add(txtFabricante);
		txtFabricante.setColumns(10);
		
		lblGrupo = new JLabel(LocaleUtils.getLocaleView().getString("lbl_grupo"));
		lblGrupo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblGrupo.setBounds(352, 88, 125, 20);
		add(lblGrupo);
		
		cbxGrupo = new JComboBox();
		cbxGrupo.setBounds(346, 109, 154, 30);
		add(cbxGrupo);
		
		lblAcessrios = new JLabel(LocaleUtils.getLocaleView().getString("lbl_acessorios"));
		lblAcessrios.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAcessrios.setBounds(515, 88, 125, 20);
		add(lblAcessrios);
		
		txtAcessorios = new JTextField();
		txtAcessorios.setBounds(512, 111, 140, 30);
		add(txtAcessorios);
		txtAcessorios.setColumns(10);
		
		lblDataFab = new JLabel(LocaleUtils.getLocaleView().getString("lbl_data_fab"));
		lblDataFab.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDataFab.setBounds(664, 88, 125, 20);
		add(lblDataFab);
		
		txtDataFab = new JTextField();
		txtDataFab.setColumns(10);
		txtDataFab.setBounds(664, 109, 179, 30);
		add(txtDataFab);
		
		lblImagemVeiculo = new JLabel(LocaleUtils.getLocaleView().getString("lbl_imagem_veiculo"));
		lblImagemVeiculo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblImagemVeiculo.setBounds(346, 151, 204, 20);
		add(lblImagemVeiculo);
		
		txtDiretorioImagem = new JTextField();
		txtDiretorioImagem.setEditable(false);
		txtDiretorioImagem.setColumns(10);
		txtDiretorioImagem.setBounds(346, 175, 342, 30);
		add(txtDiretorioImagem);
		
		lblChassi = new JLabel(LocaleUtils.getLocaleView().getString("lbl_chassi"));
		lblChassi.setVerticalAlignment(SwingConstants.BOTTOM);
		lblChassi.setBounds(27, 267, 125, 20);
		add(lblChassi);
		
		txtChassi = new JTextField();
		txtChassi.setEditable(false);
		txtChassi.setColumns(10);
		txtChassi.setBounds(27, 288, 306, 30);
		add(txtChassi);
		
		lblPlca = new JLabel(LocaleUtils.getLocaleView().getString("lbl_chassi"));
		lblPlca.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPlca.setBounds(352, 267, 125, 20);
		add(lblPlca);
		
		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		txtPlaca.setBounds(346, 288, 140, 30);
		add(txtPlaca);
		
		lblUf = new JLabel(LocaleUtils.getLocaleView().getString("lbl_uf"));
		lblUf.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUf.setBounds(502, 267, 88, 20);
		add(lblUf);
		
		cbxUf = new JComboBox();
		cbxUf.setBounds(498, 288, 92, 30);
		add(cbxUf);
		
		lblCidade = new JLabel(LocaleUtils.getLocaleView().getString("lbl_cidade"));
		lblCidade.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCidade.setBounds(610, 267, 125, 20);
		add(lblCidade);
		
		cbxCidade = new JComboBox();
		cbxCidade.setBounds(602, 287, 231, 30);
		add(cbxCidade);
		
		lblKmRodado = new JLabel(LocaleUtils.getLocaleView().getString("lbl_km_rodado"));
		lblKmRodado.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKmRodado.setBounds(27, 319, 125, 20);
		add(lblKmRodado);
		
		txtKmRodado = new JTextField();
		txtKmRodado.setColumns(10);
		txtKmRodado.setBounds(27, 342, 140, 30);
		add(txtKmRodado);
		
		lblTarefaKmLivre = new JLabel(LocaleUtils.getLocaleView().getString("lbl_tarifa_km_livre"));
		lblTarefaKmLivre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTarefaKmLivre.setBounds(182, 319, 145, 20);
		add(lblTarefaKmLivre);
		
		txtTarifaKmLivre = new JTextField();
		txtTarifaKmLivre.setColumns(10);
		txtTarifaKmLivre.setBounds(179, 342, 140, 30);
		add(txtTarifaKmLivre);
		
		lblTarefaKmControlado = new JLabel(LocaleUtils.getLocaleView().getString("lbl_tarifa_km_controlado"));
		lblTarefaKmControlado.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTarefaKmControlado.setBounds(335, 319, 165, 20);
		add(lblTarefaKmControlado);
		
		txtTarifaKmControlado = new JTextField();
		txtTarifaKmControlado.setColumns(10);
		txtTarifaKmControlado.setBounds(331, 343, 146, 30);
		add(txtTarifaKmControlado);
		
		BotoesCrudComponente botoesCrudComponente = new BotoesCrudComponente();
		botoesCrudComponente.setBounds(633, 478, 200, 50);
		add(botoesCrudComponente);
		
		this.setBounds(15, 10, 850, 550);
		this.setVisible(true);
	}
}
