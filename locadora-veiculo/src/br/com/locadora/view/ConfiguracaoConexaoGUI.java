package br.com.locadora.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConfiguracaoConexaoGUI extends JDialog {
	private JButton btnSalvar;
	private JTextArea txtInfoConexao;
	private JLabel lblDadosAtualDa;
	private JLabel lblNomeDB;
	private JTextField txtNomeDb;
	private JLabel lblUsurio;
	private JTextField txtUsuario;
	private JLabel lblSenha;
	private JTextField txtSenha;
	private JLabel lblPorta;
	private JTextField txtPorta;

	public ConfiguracaoConexaoGUI() {
		inicializar();
	}
	
	/**Inicializa todos os componetes da tela
	 * @author Joaquim Neto
	 */
	private void inicializar() {
		getContentPane().setLayout(null);
		
		// Cria o JTextArea e adicionar ao Panel para exibição
	    String info = "\n\tNome do BD: locadora \n\tPorta: 3306 \n\tUsuario: root \n\tSenha: ******\n";
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(280, 360, 100, 30);
		getContentPane().add(btnSalvar);
		
		txtInfoConexao = new JTextArea(info);
		txtInfoConexao.setEditable(false);
		txtInfoConexao.setBounds(20, 30, 360, 100);
		getContentPane().add(txtInfoConexao);
		
		lblDadosAtualDa = new JLabel("Dados atual da conexão");
		lblDadosAtualDa.setBounds(27, 5, 200, 20);
		getContentPane().add(lblDadosAtualDa);
		
		lblNomeDB = new JLabel("Nome do Banco");
		lblNomeDB.setBounds(25, 140, 150, 20);
		getContentPane().add(lblNomeDB);
		
		txtNomeDb = new JTextField();
		txtNomeDb.setBounds(20, 160, 355, 30);
		getContentPane().add(txtNomeDb);
		txtNomeDb.setColumns(10);
		
		lblUsurio = new JLabel("Usuário");
		lblUsurio.setBounds(25, 195, 150, 20);
		getContentPane().add(lblUsurio);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(20, 215, 150, 30);
		getContentPane().add(txtUsuario);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(25, 245, 150, 20);
		getContentPane().add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(20, 265, 150, 30);
		getContentPane().add(txtSenha);
		
		lblPorta = new JLabel("Porta");
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
	}
}
