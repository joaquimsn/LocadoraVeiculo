package br.com.locadora.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.locadora.controller.ConfiguracaoBancoDadosControl;
import br.com.locadora.model.vo.ParametrosConexao;
import br.com.locadora.utils.SystemUtils;
import br.com.locadora.utils.locale.LocaleUtils;

public class ConfiguracaoConexaoGUI extends JDialog {
	private static final long serialVersionUID = -3210390027755116287L;
	
	private JButton btnSalvar;
	private JTextArea txtInfoConexao;
	private JLabel lblDadosAtualDa;
	private JLabel lblNomeDB;
	private JTextField txtNomeDb;
	private JLabel lblUsurio;
	private JTextField txtUsuario;
	private JLabel lblSenha;
	private JPasswordField jPasswordSenha;
	private JLabel lblPorta;
	private JTextField txtPorta;

	public ConfiguracaoConexaoGUI() {
		inicializar();
	}
	
	/**Inicializa todos os componetes da tela
	 * @author Joaquim Neto
	 */
	private void inicializar() {
		setTitle(LocaleUtils.getLocaleView().getString("titulo_tela_principal_configuracao_banco"));
		getContentPane().setLayout(null);
		
		// Cria o JTextArea e adicionar ao Panel para exibição
	    String info = LocaleUtils.getLocaleView().getString("lbl_info_bancodados");
		//LocaleUtils.getLocaleView().getString("")
		btnSalvar = new JButton(LocaleUtils.getLocaleView().getString("btn_salvar"));
		btnSalvar.setBounds(280, 360, 100, 30);
		getContentPane().add(btnSalvar);
		
		txtInfoConexao = new JTextArea(info);
		txtInfoConexao.setEditable(false);
		txtInfoConexao.setBounds(20, 30, 360, 100);
		getContentPane().add(txtInfoConexao);
		
		lblDadosAtualDa = new JLabel(LocaleUtils.getLocaleView().getString("lbl_dados_atuais"));
		lblDadosAtualDa.setBounds(27, 5, 200, 20);
		getContentPane().add(lblDadosAtualDa);
		
		lblNomeDB = new JLabel(LocaleUtils.getLocaleView().getString("lbl_nome_banco"));
		lblNomeDB.setBounds(25, 140, 150, 20);
		getContentPane().add(lblNomeDB);
		
		txtNomeDb = new JTextField();
		txtNomeDb.setBounds(20, 160, 355, 30);
		getContentPane().add(txtNomeDb);
		txtNomeDb.setColumns(10);
		
		lblUsurio = new JLabel(LocaleUtils.getLocaleView().getString("lbl_usuario"));
		lblUsurio.setBounds(25, 195, 150, 20);
		getContentPane().add(lblUsurio);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(20, 215, 150, 30);
		getContentPane().add(txtUsuario);
		
		lblSenha = new JLabel(LocaleUtils.getLocaleView().getString("lbl_senha"));
		lblSenha.setBounds(25, 245, 150, 20);
		getContentPane().add(lblSenha);
		
		jPasswordSenha = new JPasswordField();
		jPasswordSenha.setColumns(10);
		jPasswordSenha.setBounds(20, 265, 150, 30);
		getContentPane().add(jPasswordSenha);
		
		lblPorta = new JLabel(LocaleUtils.getLocaleView().getString("lbl_porta"));
		lblPorta.setBounds(25, 295, 150, 20);
		getContentPane().add(lblPorta);
		
		txtPorta = new JTextField();
		txtPorta.setColumns(10);
		txtPorta.setBounds(20, 315, 100, 30);
		getContentPane().add(txtPorta);
		
		setBounds(0, 0, 400, 425);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		// Altera os parâmetros de conexão com o banco de dados
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Cria uma instancia do Objeto ParamtrosConexao
				ParametrosConexao parametrosConexao = new ParametrosConexao();
				
				// Preenche os atributos do objetos com as informações fornecida pelo usuário
				parametrosConexao.setNomeDb(txtNomeDb.getText());
				parametrosConexao.setUsuario(txtUsuario.getText());
				parametrosConexao.setSenha(String.valueOf(jPasswordSenha.getPassword()));
				parametrosConexao.setPorta(txtPorta.getText());
				
				if (!SystemUtils.isCamposObrigatoriosPreenchidos(parametrosConexao)) {
					return;
				}
				
				ConfiguracaoBancoDadosControl control = new ConfiguracaoBancoDadosControl();
				control.salvar(parametrosConexao);
				
				JOptionPane.showMessageDialog(txtInfoConexao, LocaleUtils.getLocaleMessages().getString("sucesso_conexao_parametrosalt"));
				
				// Limpar o valor dos campos
				txtNomeDb.setText("");
				txtPorta.setText("");
				jPasswordSenha.setText("");
				txtUsuario.setText("");
			}
		});
	}
}
