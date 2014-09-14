package br.com.locadora.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JYearChooser;

import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.componentes.BotoesCrudComponente;
import br.com.locadora.view.componentes.ImageFilter;

public class VeiculoGUI extends JPanel implements Serializable, ActionListener {
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
	private JYearChooser anoFabricacao;
	private JTextField txtChassi;
	private JTextField txtKmRodado;
	private JTextField txtFabricante;
	private JTextField txtAcessorios;
	private JTextField txtTarifaKmLivre;
	private JTextField txtDiretorioImagem;
	private JTextField txtTarifaKmControlado;
	
	private JFileChooser escolhaImagemVeiculo;
	private JButton btnEscolhaImagem;
	
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
		
		// Configura o FileChooser para escolha da imagem do veiculo
		fileChooserConfig();
		
		setLayout(null);
		setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1, true), tituloPanel, TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		
		lblModelo = new JLabel(LocaleUtils.getLocaleView().getString("lbl_modelo"));
		lblModelo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblModelo.setBounds(346, 37, 125, 20);
		add(lblModelo);
		
		txtModelo = new JTextField(10);
		txtModelo.setBounds(346, 59, 306, 30);
		add(txtModelo);
		
		panelImagemVeiculo = new JPanel();
		panelImagemVeiculo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelImagemVeiculo.setBounds(27, 45, 300, 200);
		add(panelImagemVeiculo);
		
		lblFabricante = new JLabel(LocaleUtils.getLocaleView().getString("lbl_fabricante"));
		lblFabricante.setBounds(674, 39, 125, 20);
		add(lblFabricante);
		
		txtFabricante = new JTextField(10);
		txtFabricante.setBounds(664, 59, 179, 30);
		add(txtFabricante);
		
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
		
		txtAcessorios = new JTextField(10);
		txtAcessorios.setBounds(512, 111, 140, 30);
		add(txtAcessorios);
		
		lblDataFab = new JLabel(LocaleUtils.getLocaleView().getString("lbl_data_fab"));
		lblDataFab.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDataFab.setBounds(664, 88, 125, 20);
		add(lblDataFab);
		
		anoFabricacao = new JYearChooser();
		anoFabricacao.setBounds(664, 109, 179, 30);
		add(anoFabricacao);
		
		lblImagemVeiculo = new JLabel(LocaleUtils.getLocaleView().getString("lbl_imagem_veiculo"));
		lblImagemVeiculo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblImagemVeiculo.setBounds(346, 151, 204, 20);
		add(lblImagemVeiculo);
		
		txtDiretorioImagem = new JTextField(10);
		txtDiretorioImagem.setEditable(false);
		txtDiretorioImagem.setBounds(346, 175, 340, 30);
		add(txtDiretorioImagem);
		
		btnEscolhaImagem = new JButton(LocaleUtils.getLocaleView().getString("btn_escolha_imagem"));
		btnEscolhaImagem .setBounds(693, 174, 150, 30);
		btnEscolhaImagem.addActionListener(this);
		add(btnEscolhaImagem);
		
		lblChassi = new JLabel(LocaleUtils.getLocaleView().getString("lbl_chassi"));
		lblChassi.setVerticalAlignment(SwingConstants.BOTTOM);
		lblChassi.setBounds(27, 267, 125, 20);
		add(lblChassi);
		
		txtChassi = new JTextField(10);
		txtChassi.setEditable(false);
		txtChassi.setBounds(27, 288, 306, 30);
		add(txtChassi);
		
		lblPlca = new JLabel(LocaleUtils.getLocaleView().getString("lbl_chassi"));
		lblPlca.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPlca.setBounds(352, 267, 125, 20);
		add(lblPlca);
		
		txtPlaca = new JTextField(10);
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
		
		txtKmRodado = new JTextField(10);
		txtKmRodado.setBounds(27, 342, 140, 30);
		add(txtKmRodado);
		
		lblTarefaKmLivre = new JLabel(LocaleUtils.getLocaleView().getString("lbl_tarifa_km_livre"));
		lblTarefaKmLivre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTarefaKmLivre.setBounds(182, 319, 145, 20);
		add(lblTarefaKmLivre);
		
		txtTarifaKmLivre = new JTextField(10);
		txtTarifaKmLivre.setBounds(179, 342, 140, 30);
		add(txtTarifaKmLivre);
		
		lblTarefaKmControlado = new JLabel(LocaleUtils.getLocaleView().getString("lbl_tarifa_km_controlado"));
		lblTarefaKmControlado.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTarefaKmControlado.setBounds(335, 319, 165, 20);
		add(lblTarefaKmControlado);
		
		txtTarifaKmControlado = new JTextField(10);
		txtTarifaKmControlado.setBounds(331, 343, 146, 30);
		add(txtTarifaKmControlado);
		
		BotoesCrudComponente botoesCrudComponente = new BotoesCrudComponente();
		botoesCrudComponente.setBounds(610, 421, 198, 45);
		add(botoesCrudComponente);
		
		this.setBounds(15, 10, 850, 500);
		this.setVisible(true);
	}
	
	private void fileChooserConfig(){
		escolhaImagemVeiculo = new JFileChooser();
		escolhaImagemVeiculo.setLocale(LocaleUtils.getLocaleView().getLocale());
		escolhaImagemVeiculo.setDialogTitle(LocaleUtils.getLocaleView().getString("titulo_escolha_uma_imagem"));
		escolhaImagemVeiculo.setFileFilter(new ImageFilter());
		escolhaImagemVeiculo.setFileSelectionMode(JFileChooser.FILES_ONLY);
		escolhaImagemVeiculo.setApproveButtonText(LocaleUtils.getLocaleView().getString("btn_adicionar"));
		escolhaImagemVeiculo.addActionListener(this);
		escolhaImagemVeiculo.setSize(300, 300);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEscolhaImagem) {
			// pega o valor do retorna da escolha do usuário
			int valorRetornado =  escolhaImagemVeiculo.showOpenDialog(txtDiretorioImagem);
			
			// Verifica se o usuário selecionou uma imagem com sucesso
			if (valorRetornado == JFileChooser.APPROVE_OPTION) {
				txtDiretorioImagem.setText(escolhaImagemVeiculo.getSelectedFile().getName());
			}
		}
		
	}
}
