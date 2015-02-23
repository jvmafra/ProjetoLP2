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
import javax.swing.ImageIcon;

public class FaturamentoDoHotel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnVoltar;

	/**
	 * Create the panel.
	 */
	public FaturamentoDoHotel() {
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0, 0, 800, 600);
		textField = new JTextField();
		textField.setBounds(339, 206, 179, 42);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblFaturamentoMensal = new JLabel("Faturamento Mensal");
		lblFaturamentoMensal.setForeground(new Color(255, 255, 255));
		lblFaturamentoMensal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFaturamentoMensal.setBounds(199, 218, 143, 14);
		add(lblFaturamentoMensal);
		
		textField_1 = new JTextField();
		textField_1.setBounds(339, 293, 179, 42);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFaturamentoTotal = new JLabel("Faturamento Total");
		lblFaturamentoTotal.setForeground(new Color(255, 255, 255));
		lblFaturamentoTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFaturamentoTotal.setBounds(205, 305, 124, 14);
		add(lblFaturamentoTotal);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesEstatisticas());
			}
		});
		btnVoltar.setBounds(369, 454, 89, 23);
		add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FaturamentoDoHotel.class.getResource("/nucleo/icones/hotel4.png")));
		label.setBounds(339, 31, 143, 118);
		add(label);

	}
}