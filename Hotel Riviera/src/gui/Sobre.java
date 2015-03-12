package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Sobre extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Sobre() {
		setBackground(new Color(51, 102, 153));
		repaint();
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		JLabel nome_projeto = new JLabel("HOTEL RIVIERA - Projeto de Laboratório de Programação 2\r\n\r\n");
		nome_projeto.setBounds(216, 200, 398, 17);
		nome_projeto.setForeground(Color.WHITE);
		nome_projeto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(nome_projeto);
		
		JLabel lblProfessorGustavoSoares = new JLabel("PROFESSOR: \r\n\r\nGustavo Soares");
		lblProfessorGustavoSoares.setBounds(304, 274, 204, 17);
		lblProfessorGustavoSoares.setForeground(Color.WHITE);
		lblProfessorGustavoSoares.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblProfessorGustavoSoares);
		
		JLabel lblGrupo = new JLabel("GRUPO:");
		lblGrupo.setBounds(364, 322, 56, 17);
		lblGrupo.setForeground(Color.WHITE);
		lblGrupo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblGrupo);
		
		JLabel lblAdielAndrade = new JLabel("Adiel Andrade");
		lblAdielAndrade.setBounds(350, 353, 95, 17);
		lblAdielAndrade.setForeground(Color.WHITE);
		lblAdielAndrade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblAdielAndrade);
		
		JLabel lblEdvalMatheus = new JLabel("Edval Matheus");
		lblEdvalMatheus.setBounds(345, 382, 100, 17);
		lblEdvalMatheus.setForeground(Color.WHITE);
		lblEdvalMatheus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblEdvalMatheus);
		
		JLabel lblHugoGabrielBezerra = new JLabel("Hugo Gabriel Bezerra");
		lblHugoGabrielBezerra.setBounds(332, 410, 147, 17);
		lblHugoGabrielBezerra.setForeground(Color.WHITE);
		lblHugoGabrielBezerra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblHugoGabrielBezerra);
		
		JLabel lblJooVictorMafra = new JLabel("Joao Victor Mafra");
		lblJooVictorMafra.setBounds(342, 438, 113, 17);
		lblJooVictorMafra.setForeground(Color.WHITE);
		lblJooVictorMafra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblJooVictorMafra);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(355, 498, 76, 27);
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Dialog", Font.PLAIN, 14));
		add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new PaginaInicialHotel());
			}
		});
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setBounds(374, 126, 46, 14);
		add(label);
		
	
	}
}