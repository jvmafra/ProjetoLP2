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
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 800, 600);;
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Novo H\u00F3spede");
		btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		btnNewButton.setBounds(296, 133, 222, 142);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new NovoHospede(false));
			}
		});
		
		JButton btnConsultaHspedes = new JButton("Consulta H\u00F3spedes");
		btnConsultaHspedes.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		btnConsultaHspedes.setBounds(298, 328, 220, 142);
		panel.add(btnConsultaHspedes);
		
		btnConsultaHspedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new ConsultaHospede());
			}
		});
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new PaginaInicialHotel());
			}
		});
		btnVoltar.setBounds(53, 533, 95, 25);
		panel.add(btnVoltar);

	}
}