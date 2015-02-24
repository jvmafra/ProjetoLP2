package gui.gerente;

import gui.Sistema;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class OpcoesFuncionario extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OpcoesFuncionario() {
		setBackground(new Color(51, 102, 153));
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		JButton btnNovoFuncionario = new JButton("NOVO FUNCIONARIO");
		btnNovoFuncionario.setForeground(new Color(51, 102, 153));
		btnNovoFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovoFuncionario());
			}
		});
		btnNovoFuncionario.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNovoFuncionario.setBounds(304, 222, 231, 56);
		add(btnNovoFuncionario);
		
		JButton btnEditaFuncionario = new JButton("EDITA FUNCIONARIO");
		btnEditaFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditaFuncionario.setForeground(new Color(51, 102, 153));
		btnEditaFuncionario.setFont(new Font("Dialog", Font.BOLD, 15));
		btnEditaFuncionario.setBounds(304, 314, 231, 56);
		add(btnEditaFuncionario);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesPrivadas());
			}
		});
		btnVoltar.setBounds(375, 459, 89, 23);
		add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(OpcoesFuncionario.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(347, 71, 141, 94);
		add(lblNewLabel);
	}

}
