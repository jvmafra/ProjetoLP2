package gui.gerente;

import gui.Sistema;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class FaturamentoDoHotel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnVoltar;

	/**
	 * Create the panel.
	 */
	public FaturamentoDoHotel() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 800, 600);
		textField = new JTextField();
		textField.setBounds(347, 132, 179, 42);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblFaturamentoMensal = new JLabel("Faturamento Mensal");
		lblFaturamentoMensal.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblFaturamentoMensal.setBounds(186, 145, 143, 14);
		add(lblFaturamentoMensal);
		
		textField_1 = new JTextField();
		textField_1.setBounds(347, 205, 179, 42);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFaturamentoTotal = new JLabel("Faturamento Total");
		lblFaturamentoTotal.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblFaturamentoTotal.setBounds(205, 218, 124, 14);
		add(lblFaturamentoTotal);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesPrivadas());
			}
		});
		btnVoltar.setBounds(369, 292, 89, 23);
		add(btnVoltar);

	}
}