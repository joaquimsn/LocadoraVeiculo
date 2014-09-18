package br.com.locadora.view;

import java.awt.Color;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.locadora.utils.locale.LocaleUtils;

import com.toedter.calendar.JDateChooser;

public class RelatorioGUI extends JPanel {
	private static final long serialVersionUID = 7554024208585275488L;
	
	// Lables
	private JLabel lblTipoRelatorio;
	private JLabel lblPerodo;
	private JLabel lblA;
	
	// Inputs
	private JDateChooser dataInicialChooser;
	private JDateChooser dataFinalChooser;
	private JComboBox comboBox;
	
	// Button
	private JButton btnGerar;
	
	private JPanel panelResultado;
	
	public RelatorioGUI() {
		inicializar();
	}
	
	/**
	 * Inicializa todos os componentes da tela
	 * @author Joaquim Neto
	 */
	private void inicializar() {
		setLayout(null);
		TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.GRAY, 1, true), LocaleUtils.getLocaleView().getString("titulo_tela_relatorio"), 
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE);
		setBorder(titledBorder);
		
		lblTipoRelatorio = new JLabel(LocaleUtils.getLocaleView().getString("lbl_tipo_relatorio"));
		lblTipoRelatorio.setBounds(35, 30, 175, 20);
		add(lblTipoRelatorio);
		
		comboBox = new JComboBox();
		comboBox.setBounds(30, 50, 300, 30);
		add(comboBox);
		
		lblPerodo = new JLabel(LocaleUtils.getLocaleView().getString("lbl_periodo"));
		lblPerodo.setBounds(395, 30, 175, 20);
		add(lblPerodo);
		
		dataInicialChooser = new JDateChooser();
		dataInicialChooser.setBounds(390, 50, 150, 30);
		add(dataInicialChooser);
		
		lblA = new JLabel(LocaleUtils.getLocaleView().getString("lbl_a_conector_data"));
		lblA.setBounds(550, 55, 25, 20);
		add(lblA);
		
		dataFinalChooser = new JDateChooser();
		dataFinalChooser.setMaxSelectableDate(new Date());
		dataFinalChooser.setBounds(567, 50, 150, 30);
		add(dataFinalChooser);
		
		btnGerar = new JButton(LocaleUtils.getLocaleView().getString("btn_gerar"));
		btnGerar.setBounds(725, 50, 100, 30);
		add(btnGerar);
		
		panelResultado = new JPanel();
		panelResultado.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelResultado.setBounds(20, 90, 820, 400);
		add(panelResultado);
		
		this.setBounds(15, 10, 859, 500);
		setVisible(true);
	}
}
