package gui.hospede;
import gui.PaginaInicialHotel;
import gui.Sistema;

import javax.swing.JPanel;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class OpcoesDoHospede extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public OpcoesDoHospede() {
		setBorder(new LineBorder(new Color(128, 0, 0), 10, true));
		setLayout(null);
		setBounds(0, 0, 800, 600);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 153));
		panel.setBounds(0, 0, 800, 600);;
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("NOVO H\u00D3SPEDE");
		btnNewButton.setForeground(new Color(51, 102, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(298, 204, 222, 95);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new NovoHospede(false));
			}
		});
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new PaginaInicialHotel());
			}
		});
		btnVoltar.setBounds(358, 501, 95, 25);
		panel.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(OpcoesDoHospede.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(337, 37, 144, 120);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("CONSULTA H\u00D3SPEDE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new ConsultaHospede());
			}
		});
		btnNewButton_1.setForeground(new Color(51, 102, 153));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(298, 345, 222, 95);
		panel.add(btnNewButton_1);

	}
}