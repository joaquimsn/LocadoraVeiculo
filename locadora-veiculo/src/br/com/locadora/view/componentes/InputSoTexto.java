package br.com.locadora.view.componentes;

import java.awt.Color;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * Validação para campos que aceita apenas texto
 * forma de usar: <b>InputSoTexto soTexto = new InputSoTexto();</br>
 * textField.setInputVerifier(soTexto);</b>
 * @author Joaquim Neto
 */
public class InputSoTexto extends InputVerifier{
	
	private boolean upperCase;
	
	public InputSoTexto() {
		upperCase = true;
	}
	
	/**
	 * Transforma o texto digitado pelo usuário para Maiusculo se passar <b>true</b> por parâmetro
	 * @author Joaquim Neto
	 * @param upperCase boolean
	 */
	public InputSoTexto(boolean upperCase) {
		this.upperCase = upperCase;
	}

	@Override
	public boolean verify(JComponent input) {
		
		if (input.getClass() == JTextField.class) {
			JTextField textField = (JTextField) input;
			
			// Obtém apenas o texto do campo
			String[] campo = textField.getText().split("[^a-z A-ZÁáÃãÂâÉéÊêÍíÓóÕõÔôÚúÑñÇç]");
			
			// Se o campo não for vazio, faz a validação
			if (campo.length > 0) {
				
				// Define a cor branca para o background
				input.setBackground( UIManager.getColor( "TextField.background" ));
				
				StringBuilder texto = new StringBuilder();
				// Concatena o texto
				for (int i = 0; i < campo.length; i++) {
					texto.append(campo[i]);
				}
				
				// Atualiza o conteúdo do textField
				if (upperCase) {
					textField.setText(texto.toString().toUpperCase());
				} else {
					textField.setText(texto.toString());
				}
				
				return true;
			} else {
				JOptionPane.showMessageDialog(input, "Esse campo só aceita texto");
				
				// Define a cor vermelha para o background
				input.setBackground( Color.red );
				return false;
			}
		}
		
		return false;
	}

}
