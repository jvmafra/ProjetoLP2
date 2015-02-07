package gui.hospede;

import gui.Sistema;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsutaHospede extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public ConsutaHospede() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(322, 79, 447, 30);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblDigiteONome = new JLabel("Digite o Nome ou o CPF do H\u00F3spede:");
		lblDigiteONome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDigiteONome.setBounds(39, 72, 280, 41);
		add(lblDigiteONome);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDoHospede());
			}
		});
		btnVoltar.setBounds(73, 242, 89, 23);
		add(btnVoltar);

	}
}
