package br.com.locadora.view.componentes;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class InputSoTexto extends InputVerifier{

	@Override
	public boolean verify(JComponent input) {
		if (input.getClass() == JTextField.class) {
			JTextField textField = (JTextField) input;
			
			textField.setText(textField.getText().split("[a-zA-Z]")[0]);
		}
		return false;
	}

}
