package br.com.locadora.view.componentes;

import java.awt.Color;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

/**
 * Validação para campos que aceita apenas numeros
 * forma de usar: <b>InputSoTextoNumeros soTextoNumeros = new InputSoTextoNumeros();</br>
 * textField.setInputVerifier(soTextoNumeros);</b>
 * @author Joaquim Neto
 */
public class inputSenha extends InputVerifier {

	@Override
	public boolean verify(JComponent input) {
		if (input.getClass() == JPasswordField.class) {
			JPasswordField password = (JPasswordField) input;
			
			// Obtém apenas o texto do campo
			String[] campo = password.getText().split("[^a-zA-Z0-9ÁáÃãÂâÉéÊêÍíÓóÕõÔôÚúÑñÇç]");
			
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
				password.setText(texto.toString());
				
				return true;
			} else {
				JOptionPane.showMessageDialog(input, "Esse campo só aceita texto e números");
				
				// Define a cor vermelha para o background
				input.setBackground( Color.red );
				return false;
			}
		}
		
		return false;
	}

}
