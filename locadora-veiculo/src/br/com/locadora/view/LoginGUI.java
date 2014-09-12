package br.com.locadora.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

import br.com.locadora.controller.Autenticacao;
import br.com.locadora.utils.locale.LocaleUtils;

public class LoginGUI extends JDialog {
	private static final long serialVersionUID = 622477161185997978L;
	
	// labels para os inputs
	private JLabel lblIdioma;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JLabel lblCodigoAgencia;
	
	// combobox customizado para selecionar o idioma que o sistema será apresentado
	private CustomComboBox cbxSelecaoIdioma;
	
	// inputs
	private JTextField txtUsuario;
	private JTextField txtCodigoAgencia;
	private JPasswordField passwordField;
	
	// panels
	private JPanel panelCabecalho;
	private JPanel panelLogin;
	private JPanel panelBotoesLogin;
	
	// buttons 
	private JButton btnCancelar;
	private JButton btnAcessar;
	
	// Frame principal que controla todas as telas do sistema
	private final JFrame framePrincipal;

	/**
	 * Tela responsável para controlar o acesso ao sistema
	 * bloqueando as funcionalidades até que o login seja efetuado com sucesso
	 * @author Joaquim Neto
	 * @param frame Objeto JFrame
	 */
	public LoginGUI(JFrame frame) {
		this.setTitle(LocaleUtils.getLocaleView().getString("titulo_tela_login"));
		
		// recebe o frame principal do systema
		framePrincipal = frame;
		
		bloquearAcoesSistema();
		
		// cria a tela de login
		inicializar();
	}
	
	/**Inicializa todos os componetes da tela de login
	 * @author Joaquim Neto
	 */
	public void inicializar() {
		/*======================================
		 *  Instância as label da tela de login
		 * =====================================
		 */		
		lblIdioma = new JLabel(LocaleUtils.getLocaleView().getString("lbl_escolha_idioma"));
		lblIdioma.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		lblIdioma.setHorizontalAlignment(SwingConstants.RIGHT);

		lblUsuario = new JLabel(LocaleUtils.getLocaleView().getString("lbl_usuario"));
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);

		lblSenha = new JLabel(LocaleUtils.getLocaleView().getString("lbl_senha"));
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblCodigoAgencia = new JLabel(LocaleUtils.getLocaleView().getString("lbl_codigo_agencia"));
		lblCodigoAgencia.setHorizontalAlignment(SwingConstants.RIGHT);

		// Cria o cabecalho
		panelCabecalho = new JPanel(null);
		panelCabecalho.setBounds(0, 5, 400, 160);
		// logo para exibição no login
		ImageIcon iconLogoSistema = new ImageIcon("./src/br/com/locadora/resoureces/images/Nintendo_Logo.png");
		JLabel logoSistema = new JLabel(iconLogoSistema);
		logoSistema.setBounds(100, 60, 180, 90);
		
		lblIdioma.setBounds(100, 15, 100, 34);
		panelCabecalho.add(lblIdioma);
		
		//ComboBox customizado para escolha do idioma
		cbxSelecaoIdioma = new CustomComboBox();
		cbxSelecaoIdioma.setBounds(200, -5, 200, 55);
		panelCabecalho.add(cbxSelecaoIdioma);
		panelCabecalho.add(lblIdioma);
		
		// Adiciona a logo ao panel
		panelCabecalho.add(logoSistema);
		
		// Cria o panel com as informações do login
		panelLogin = new JPanel(null);
		panelLogin.setBounds(25, 160, 350, 110);
		
		// Input campo usuário
		txtUsuario = new JTextField(20);
		lblUsuario.setBounds(30, 5, 80, 30);
		txtUsuario.setBounds(115, 5, 180, 30);
		panelLogin.add(lblUsuario);
		panelLogin.add(txtUsuario);
		
		// Input campo senha
		passwordField = new JPasswordField();
		lblSenha.setBounds(30, 40, 80, 30);
		passwordField.setBounds(115, 40, 180, 30);
		panelLogin.add(lblSenha);
		panelLogin.add(passwordField);
		
		// Input campo códifo agência
		txtCodigoAgencia = new JTextField(10);
		lblCodigoAgencia.setBounds(10, 80, 100, 30);
		txtCodigoAgencia.setBounds(115, 80, 75, 30);
		panelLogin.add(lblCodigoAgencia);
		panelLogin.add(txtCodigoAgencia);
		
		// Cria o panel dos botões da tela de login
		panelBotoesLogin = new JPanel(null);
		panelBotoesLogin.setBounds(200, 270, 200, 50);
		
		btnAcessar = new JButton(LocaleUtils.getLocaleView().getString("btn_acessar"));
		btnAcessar.setBounds(5, 10, 90, 30);
		panelBotoesLogin.add(btnAcessar);
		
		btnCancelar = new JButton(LocaleUtils.getLocaleView().getString("btn_cancelar"));
		btnCancelar.setBounds(100, 10, 90, 30);
		panelBotoesLogin.add(btnCancelar);
		
		
		JPanel panelcontainer = new JPanel(null);
		panelcontainer.setSize(new Dimension(400, 350));
		panelcontainer.add(panelCabecalho);
		panelcontainer.add(panelLogin);
		panelcontainer.add(panelBotoesLogin);
		
		Container container = getContentPane();
		container.add(panelcontainer);
		
		this.setLayout(null);
		this.add(panelcontainer);
		this.setModal(false);
		this.setSize(400, 350);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setLocationRelativeTo(framePrincipal);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		
		/*==========================================================
		 * Eventos dos botões
		 *===========================================================*/
		
		// Encerra a execução do sistema
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				framePrincipal.dispose();
				System.exit(EXIT_ON_CLOSE);
			}
		});
		
		btnAcessar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Autenticacao.autenticar(txtUsuario.getText(), passwordField.getText())) {
					dispose();
					liberarAcoesSistema();
				} else {
					// Limpa o campo senha
					passwordField.setText("");
					JOptionPane.showMessageDialog(panelCabecalho, LocaleUtils.getLocaleMessages().getString("falha_login"));
				}
				
			}
		});
		
	}
	
	/**
	 * Bloquea todas as funcionalidades do sitema até que um 
	 * usuário faça o login
	 * @author Joaquim Neto
	 */
	public void bloquearAcoesSistema() {
		framePrincipal.setEnabled(false);
	}
	
	
	/**
	 * Libera todos as funcionalidades do sistema
	 * @author Joaquim Neto
	 */
	public void liberarAcoesSistema() {
		framePrincipal.setEnabled(true);
	}
}

/*
 * 	CustomComboBox uses the following files:
 *   /resoureces/images/icons/bandeira_brasil.png
 *   /resoureces/images/icons/bandeira_espanha.png
 *   /resoureces/images/icons/bandeira_us.png
 */
class CustomComboBox extends JPanel {
	ImageIcon[] images;
    String[] bandeiraStrings = {"Brasil", "Espanha", "US"};

    /*
     * Despite its use of EmptyBorder, this panel makes a fine content
     * pane because the empty border just increases the panel's size
     * and is "painted" on top of the panel's normal background.  In
     * other words, the JPanel fills its entire background if it's
     * opaque (which it is by default); adding a border doesn't change
     * that.
     */
    public CustomComboBox() {
        super(new BorderLayout());

        //Load the pet images and create an array of indexes.
        images = new ImageIcon[bandeiraStrings.length];
        Integer[] intArray = new Integer[bandeiraStrings.length];
        for (int i = 0; i < bandeiraStrings.length; i++) {
            intArray[i] = new Integer(i);
            images[i] = createImageIcon("./src/br/com/locadora/resoureces/images/icons/bandeira_" + 
            		bandeiraStrings[i].toLowerCase() + ".png");
            if (images[i] != null) {
                images[i].setDescription(bandeiraStrings[i]);
            }
        }

        //Create the combo box.
        JComboBox bandeiraList = new JComboBox(intArray);
        ComboBoxRenderer renderer= new ComboBoxRenderer();
        bandeiraList.setRenderer(renderer);
        bandeiraList.setMaximumRowCount(3);

        //Lay out the demo.
        add(bandeiraList, BorderLayout.PAGE_START);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
            return new ImageIcon(path);
    }
    
    @SuppressWarnings("rawtypes")
	class ComboBoxRenderer extends JLabel
                           implements ListCellRenderer {
        private Font font;

        public ComboBoxRenderer() {
            setOpaque(true);
            setHorizontalAlignment(LEFT);
            setVerticalAlignment(CENTER);
        }

        /*
		 * This method finds the image and text corresponding to the selected value and
		 * returns the label, set up to display the text and image.
		 */
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
            //Get the selected index. (The index param isn't
            //always valid, so just use the value.)
            int selectedIndex = ((Integer)value).intValue();

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            //Set the icon and text.  If icon was null, say so.
            ImageIcon icon = images[selectedIndex];
            String bandeira = bandeiraStrings[selectedIndex];
            setIcon(icon);
            if (icon != null) {
                setText(bandeira);
                setFont(list.getFont());
            } else {
                setUhOhText(bandeira + " (no image available)",
                            list.getFont());
            }

            return this;
        }

        //Set the font and text when no image was found.
        protected void setUhOhText(String uhOhText, Font normalFont) {
            if (font == null) { //lazily create this font
                font = normalFont.deriveFont(Font.ITALIC);
            }
            setFont(font);
            setText(uhOhText);
        }
    }
}
