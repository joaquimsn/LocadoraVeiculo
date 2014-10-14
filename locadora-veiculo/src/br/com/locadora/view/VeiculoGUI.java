package br.com.locadora.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.locadora.controller.EnderecoControl;
import br.com.locadora.controller.VeiculoControl;
import br.com.locadora.model.entity.Veiculo;
import br.com.locadora.model.enums.AcessorioVeiculoEnum;
import br.com.locadora.model.enums.GrupoVeiculoEnum;
import br.com.locadora.utils.Constants;
import br.com.locadora.utils.SystemUtils;
import br.com.locadora.utils.locale.LocaleUtils;
import br.com.locadora.view.componentes.BotoesCrudComponente;
import br.com.locadora.view.componentes.ImageFilter;
import br.com.locadora.view.componentes.InputSoNumeros;
import br.com.locadora.view.componentes.InputSoTexto;
import br.com.locadora.view.componentes.InputSoTextoNumeros;

import com.toedter.calendar.JYearChooser;

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
	private JLabel previewImagemVeiculo;
	
	// Panel para exibição da imagem do veículo
	private JPanel panelImagemVeiculo;
	
	// Inputs
	private JComboBox cbxUf;
	private JComboBox cbxCidade;
	private JComboBox cbxGrupo;
	private JComboBox cbxAcessorios;
	private JFormattedTextField txtPlaca;
	private JTextField txtModelo;
	private JYearChooser anoFabricacao;
	private JTextField txtChassi;
	private JTextField txtKmRodado;
	private JTextField txtFabricante;
	private JTextField txtTarifaKmLivre;
	private JTextField txtDiretorioImagem;
	private JTextField txtTarifaKmControlado;
	
	private JFileChooser escolhaImagemVeiculo;
	private JButton btnEscolhaImagem;
	
	private String tituloPanel;
	
	private String[] cidades;

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
		// Instacia o array de cidades
		cidades = new String[10];
		
		// Configura o FileChooser para escolha da imagem do veiculo
		fileChooserConfig();
		
		// InputVerifier para validações genéricas dos campos
		InputSoNumeros soNumeros = new InputSoNumeros();
		InputSoTextoNumeros soTextoNumeros = new InputSoTextoNumeros();
		InputSoTexto soTexto = new InputSoTexto();
		
		setLayout(null);
		setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1, true), tituloPanel, TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		
		lblModelo = new JLabel(LocaleUtils.getLocaleView().getString("lbl_modelo"));
		lblModelo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblModelo.setBounds(346, 37, 125, 20);
		add(lblModelo);
		
		txtModelo = new JTextField(10);
		txtModelo.setInputVerifier(soTextoNumeros);
		txtModelo.setBounds(346, 59, 306, 30);
		add(txtModelo);
		
		// Panel para preview da imagem do veiculo
		panelImagemVeiculo = new JPanel();
		panelImagemVeiculo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelImagemVeiculo.setBounds(27, 45, 300, 200);
		add(panelImagemVeiculo);
		
		lblFabricante = new JLabel(LocaleUtils.getLocaleView().getString("lbl_fabricante"));
		lblFabricante.setBounds(674, 39, 125, 20);
		add(lblFabricante);
		
		txtFabricante = new JTextField(10);
		txtFabricante.setInputVerifier(soTexto);
		txtFabricante.setBounds(664, 59, 179, 30);
		add(txtFabricante);
		
		lblGrupo = new JLabel(LocaleUtils.getLocaleView().getString("lbl_grupo"));
		lblGrupo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblGrupo.setBounds(352, 88, 125, 20);
		add(lblGrupo);
		
		cbxGrupo = new JComboBox(GrupoVeiculoEnum.getDisplayList().toArray(new String[0]));
		cbxGrupo.setBounds(346, 109, 204, 30);
		add(cbxGrupo);
		
		lblAcessrios = new JLabel(LocaleUtils.getLocaleView().getString("lbl_acessorios"));
		lblAcessrios.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAcessrios.setBounds(565, 88, 125, 20);
		add(lblAcessrios);
		
		cbxAcessorios = new JComboBox(AcessorioVeiculoEnum.getDisplayList().toArray(new String[0]));
		cbxAcessorios.setBounds(562, 111, 140, 30);
		add(cbxAcessorios);
		
		lblDataFab = new JLabel(LocaleUtils.getLocaleView().getString("lbl_data_fab"));
		lblDataFab.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDataFab.setBounds(714, 88, 125, 20);
		add(lblDataFab);
		
		anoFabricacao = new JYearChooser();
		anoFabricacao.setBounds(714, 109, 129, 30);
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
		txtChassi.setInputVerifier(soTextoNumeros);
		txtChassi.setBounds(27, 288, 306, 30);
		add(txtChassi);
		
		lblPlca = new JLabel(LocaleUtils.getLocaleView().getString("lbl_chassi"));
		lblPlca.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPlca.setBounds(352, 267, 125, 20);
		add(lblPlca);
		
		txtPlaca = new JFormattedTextField(Mask.maskPlaca());
		txtPlaca.setBounds(346, 288, 140, 30);
		add(txtPlaca);
		
		lblUf = new JLabel(LocaleUtils.getLocaleView().getString("lbl_uf"));
		lblUf.setVerticalAlignment(SwingConstants.BOTTOM);
		lblUf.setBounds(502, 267, 88, 20);
		add(lblUf);
		
		cbxUf = new JComboBox(Constants.UF.toArray(new String[0]));
		cbxUf.setBounds(498, 288, 92, 30);
		add(cbxUf);
		
		lblCidade = new JLabel(LocaleUtils.getLocaleView().getString("lbl_cidade"));
		lblCidade.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCidade.setBounds(610, 267, 125, 20);
		add(lblCidade);
		
		cbxCidade = new JComboBox(cidades);
		cbxCidade.setBounds(602, 287, 231, 30);
		add(cbxCidade);
		
		lblKmRodado = new JLabel(LocaleUtils.getLocaleView().getString("lbl_km_rodado"));
		lblKmRodado.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKmRodado.setBounds(27, 319, 125, 20);
		add(lblKmRodado);
		
		txtKmRodado = new JTextField(10);
		txtKmRodado.setInputVerifier(soNumeros);
		txtKmRodado.setBounds(27, 342, 140, 30);
		add(txtKmRodado);
		
		lblTarefaKmLivre = new JLabel(LocaleUtils.getLocaleView().getString("lbl_tarifa_km_livre"));
		lblTarefaKmLivre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTarefaKmLivre.setBounds(182, 319, 145, 20);
		add(lblTarefaKmLivre);
		
		txtTarifaKmLivre = new JTextField(10);
		txtTarifaKmLivre.setInputVerifier(soNumeros);
		txtTarifaKmLivre.setBounds(179, 342, 140, 30);
		add(txtTarifaKmLivre);
		
		lblTarefaKmControlado = new JLabel(LocaleUtils.getLocaleView().getString("lbl_tarifa_km_controlado"));
		lblTarefaKmControlado.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTarefaKmControlado.setBounds(335, 319, 165, 20);
		add(lblTarefaKmControlado);
		
		txtTarifaKmControlado = new JTextField(10);
		txtTarifaKmControlado.setInputVerifier(soNumeros);
		txtTarifaKmControlado.setBounds(331, 343, 146, 30);
		add(txtTarifaKmControlado);
		
		BotoesCrudComponente botoesCrudComponente = new BotoesCrudComponente();
		botoesCrudComponente.setBounds(610, 421, 198, 45);
		add(botoesCrudComponente);
		
		// Bloqueia os botões de salvar e alterar para funcionários com nível Atendente
		botoesCrudComponente.btnSalvar.setEnabled(SystemUtils.isSupervisor());
		botoesCrudComponente.btnCancelar.setEnabled(SystemUtils.isSupervisor());
		
		this.setBounds(15, 10, 860, 500);
		this.setVisible(true);
		
		/*
		 * EVENTOS DOS BOTÕES
		 */
		botoesCrudComponente.btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Veiculo veiculo = new Veiculo();
				
				// Preenche o objeto agência com as informações infromada pelo usuário
				veiculo.setAcessorio(AcessorioVeiculoEnum.getValueByDisplay((String) cbxAcessorios.getSelectedItem()));
				veiculo.setAno(anoFabricacao.getYear());
				veiculo.setChassi(txtChassi.getText());
				veiculo.setPlaca(txtPlaca.getText());
				veiculo.setModelo(txtModelo.getText());
				veiculo.setUf((String) cbxUf.getSelectedItem());
				veiculo.setCidade((String) cbxCidade.getSelectedItem());
				veiculo.setGrupo(GrupoVeiculoEnum.getValueByDisplay((String) cbxGrupo.getSelectedItem()));
				veiculo.setImagem(txtDiretorioImagem.getText());
				veiculo.setFabricante(txtFabricante.getText());
				veiculo.setKmRodado(Integer.parseInt(txtKmRodado.getText()));
				veiculo.setPrecoKmControlado(Double.parseDouble(txtTarifaKmControlado.getText()));
				veiculo.setPrecoKmLivre(Double.parseDouble(txtTarifaKmLivre.getText()));
				veiculo.setAtivo(true);
				
				// Valida os dados preenchido pelo usuário
				if (!validar(veiculo)) {
					return;
				}
				
				// Persiste o objeto agência
				VeiculoControl veiculoControl = new VeiculoControl();
				
				// Verifica se foi cadastrado com sucesso
				if (veiculoControl.salvarOuAlterar(veiculo)) {
					// Limpa os campos preenchidos
					limparCampos();
				} else {
					JOptionPane.showMessageDialog(lblGrupo, LocaleUtils.getLocaleMessages().getString("falha_errofatal"));
				}
			}
		});
		
		// Preenche o combo de cidade ao selecionar uma UF
		cbxUf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				preencherComboCidadePorUf((String) cbxUf.getSelectedItem());
			}
		});
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
				
				panelImagemVeiculo.removeAll();
				previewImagemVeiculo = new JLabel();
				ImageIcon imageVeiculo = new ImageIcon(escolhaImagemVeiculo.getSelectedFile().getAbsolutePath());
				previewImagemVeiculo = new JLabel(imageVeiculo);
				previewImagemVeiculo.setBounds(5, 5, 290, 190);
				panelImagemVeiculo.add(previewImagemVeiculo);
				panelImagemVeiculo.repaint();
			}
		}
		
	}
	
	private void preencherComboCidadePorUf(String uf) {
		cbxCidade.removeAllItems();
		EnderecoControl enderecoControl = new EnderecoControl();
		cidades = enderecoControl.buscarCidadePorUf(uf).toArray(new String[0]);
		for (String cidade : cidades) {
			cbxCidade.addItem(cidade);
		}
	}
	
	/**
	 * Valida os campos preenchido pelo usuário
	 * @author Joaquim Neto
	 * @param veiculo Objeto Veiculo
	 * @return <b>true</b> Se for valido
	 */
	private boolean validar(Veiculo veiculo) {
		
		// Verifica se os campos obrigatorios referente a veiculo foram preenchido
		if (!SystemUtils.isCamposObrigatoriosPreenchidos(veiculo)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Limpa todos os campos preenchidos pelo usuário
	 * @author Joaquim Neto
	 */
	private void limparCampos() {
		// Limpa os valores fields veiculo
		txtChassi.setText("");
		txtDiretorioImagem.setText("");
		txtFabricante.setText("");
		txtKmRodado.setText("");
		txtModelo.setText("");
		txtPlaca.setText("");
		txtTarifaKmControlado.setText("");
		txtTarifaKmLivre.setText("");
	}
	
	/**
	 * Preenche os campos da tela agência com os valores obtidos do 
	 * objeto Agência passado por parâmentro
	 * @author Joaquim Neto
	 * @param veiculo Objeto agência
	 */
	public void preencherCampos(Veiculo veiculo) {
		if (!SystemUtils.isNuloOuVazio(veiculo)) {
			cbxAcessorios.setSelectedItem(AcessorioVeiculoEnum.getDisplayByValue(veiculo.getAcessorio()));
			anoFabricacao.setYear(veiculo.getAno());
			txtChassi.setText(veiculo.getChassi());
			txtModelo.setText(veiculo.getModelo());
			cbxUf.setSelectedItem(veiculo.getUf());
			preencherComboCidadePorUf(veiculo.getUf()); // Preenche o combo cidade
			cbxCidade.setSelectedItem(veiculo.getCidade());
			cbxGrupo.setSelectedItem(GrupoVeiculoEnum.getDisplayByValue(veiculo.getGrupo()));
			txtDiretorioImagem.setText(veiculo.getImagem());
			txtFabricante.setText(veiculo.getFabricante());
			txtKmRodado.setText(String.valueOf(veiculo.getKmRodado()));
			txtPlaca.setText(veiculo.getPlaca());
			txtTarifaKmControlado.setText(String.valueOf(veiculo.getPrecoKmControlado()));
			txtTarifaKmLivre.setText(String.valueOf(veiculo.getPrecoKmLivre()));
		}
	}
}
