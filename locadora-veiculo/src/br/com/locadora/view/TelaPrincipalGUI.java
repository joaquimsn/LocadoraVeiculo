package br.com.locadora.view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import br.com.locadora.utils.locale.LocaleUtils;

public class TelaPrincipalGUI {

	private JFrame frame;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalGUI window = new TelaPrincipalGUI();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipalGUI() {
		initialize();
		JDialog d = new LoginGUI(this.frame);
		d.setAlwaysOnTop(true);
		d.setVisible(true);
		d.setModal(false);
		d.setSize(400, 300);
		d.setDefaultCloseOperation(JFrame.NORMAL);
		d.setLocationRelativeTo(frame);
		d.setTitle(LocaleUtils.getLocaleView().getString("titulo_sys"));
		
		frame.setEnabled(false);
		frame.setDefaultCloseOperation(JFrame.NORMAL);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1376, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JButton button = new JButton(LocaleUtils.getLocaleView().getString("titulo_sys"));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Hello");
				
			}
		});
		
		panel = new JPanel();
		panel.add(button);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
	}

}
