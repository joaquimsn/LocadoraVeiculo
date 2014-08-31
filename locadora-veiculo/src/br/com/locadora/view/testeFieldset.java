package br.com.locadora.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class testeFieldset extends JFrame{
	
	public testeFieldset() {
		super("Teste Field");
		Container container = getContentPane();
		
		
		//Panel que receberá os fields
		JPanel panel = new JPanel(new FlowLayout());
		panel.setSize(200, 80);
		
		// Field pequeno
		JLabel pequenoLbl = new JLabel("Field Pequeno");
		JTextField pequenoTxt = new JTextField(5);// Aqui estou definido o tamanho do textField é apeas uma forma de fazer
		
		// Field médio
		JLabel medioLbl = new JLabel("Field Médio");
		JTextField medioTxt = new JTextField(15);// Aqui estou definido o tamanho do textField é apeas uma forma de fazer
		
		// Field grande
		JLabel grandeLbl = new JLabel("Field Grande");
		JTextField grandeTxt = new JTextField(30);// Aqui estou definido o tamanho do textField é apeas uma forma de fazer
		
		// Aqui adiciono os campos criados ao panel 1
		JPanel panelContenerField = new JPanel(new GridLayout(1, 2, 5, 5));
		panelContenerField.add(pequenoLbl);
		panelContenerField.add(pequenoTxt);
		
		// Aqui adiciono os campos criados ao panel 2
		JPanel panelContenerField2 = new JPanel(new GridLayout(1, 2, 5, 5));
		panelContenerField2.add(medioLbl);
		panelContenerField2.add(medioTxt);
		
		// Aqui adiciono os campos criados ao panel 3
		JPanel panelContenerField3 = new JPanel(new GridLayout(1, 2, 5, 5));
		panelContenerField3.add(grandeLbl);
		panelContenerField3.add(grandeTxt);
		
		
		panel.add(panelContenerField);
		panel.add(panelContenerField2);
		panel.add(panelContenerField3);
		
		// Aqui é criada a borda com o titulo, 
		// O método TitleBorder aceita sobrecarga para definir a posição e alinhamento
		Border border = new TitledBorder(new LineBorder(Color.red), "Teste");
		
		// Adiciona a borda criada a propriedade borda do panel
		panel.setBorder(border);
		
		
		container.setLayout(new BorderLayout());
		container.add(panel, BorderLayout.CENTER);
		
		this.setVisible(true);
		this.setSize(800, 600);
	}
	
	public static void main(String[] agrs) {
		new testeFieldset();
	}
}
