package br.com.locadora.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import br.com.locadora.controller.LocacaoControl;
import br.com.locadora.controller.RelatorioControl;
import br.com.locadora.model.enums.ParametroRelatoriosEnum;
import br.com.locadora.model.vo.RelatorioLocacao;
import br.com.locadora.utils.SystemUtils;
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
	private  static Container container;
	
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
		
		comboBox = new JComboBox(ParametroRelatoriosEnum.getDisplayList().toArray(new String[0]));
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
		
		panelResultado = new JPanel(null);
		panelResultado.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelResultado.setBounds(20, 90, 820, 400);
		add(panelResultado);
		
		JasperViewer visualizaRelatorio = new JasperViewer(null);
		visualizaRelatorio.setVisible(false);
		container = visualizaRelatorio.getContentPane();
		container.setBounds(5, 5, 815, 395);
		
		panelResultado.add(container);
		
		btnGerar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (dataInicialChooser.getDate() != null && dataFinalChooser.getDate() != null) {
					LocacaoControl locacaoControl = new LocacaoControl();
					RelatorioLocacao relatorioLocacao = new RelatorioLocacao();
					RelatorioControl relatorioControl = new RelatorioControl();
					
					relatorioLocacao.setListaLocacao(locacaoControl.buscarPorPeriodo(dataInicialChooser.getDate(), dataFinalChooser.getDate(),
						comboBox.getSelectedIndex()));
					
					relatorioLocacao.setFuncionario(SystemUtils.getFuncionarioLogado());
					relatorioLocacao.setAgencia(SystemUtils.getAgenciaSelecionado());
					
					try {
						trocarRelatorio(relatorioControl.gerarLocacoes(relatorioLocacao));
					} catch (Exception e1) {
						// TODO Auto-generated catch block 
						e1.printStackTrace();
					}
					
				} else {
					JOptionPane.showMessageDialog(panelResultado, "Informe o periodo");
				}
			}
		});
		
		this.setBounds(15, 10, 859, 500);
		setVisible(true);
	}
	
	private void trocarRelatorio(JasperPrint jasPrint) {
		JasperViewer jasperViewer = new JasperViewer(jasPrint);
		jasperViewer.setVisible(true);
		jasperViewer.setBounds(5, 5, 815, 395);
		
		container.removeAll();
		container.add(jasperViewer.getContentPane());
		container.repaint();
		
		panelResultado.repaint();
		repaint();
	}
}
