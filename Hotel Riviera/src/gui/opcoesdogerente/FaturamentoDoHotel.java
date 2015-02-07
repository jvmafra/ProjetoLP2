package gui.opcoesdogerente;

import gui.Sistema;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FaturamentoDoHotel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnVoltar;

	/**
	 * Create the panel.
	 */
	public FaturamentoDoHotel() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(172, 38, 111, 42);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblFaturamentoMensal = new JLabel("Faturamento Mensal");
		lblFaturamentoMensal.setBounds(38, 52, 124, 14);
		add(lblFaturamentoMensal);
		
		textField_1 = new JTextField();
		textField_1.setBounds(172, 94, 111, 42);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFaturamentoTotal = new JLabel("Faturamento Total");
		lblFaturamentoTotal.setBounds(38, 108, 124, 14);
		add(lblFaturamentoTotal);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesPrivadas());
			}
		});
		btnVoltar.setBounds(38, 266, 89, 23);
		add(btnVoltar);

	}
}
