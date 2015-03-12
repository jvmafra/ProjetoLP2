package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sobre extends JPanel {


	private static final long serialVersionUID = 1L;

	public Sobre() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Sobre.class.getResource("/nucleo/icones/ufcg.jpg")));
		logo.setBounds(261, -13, 280, 242);
		add(logo);
		
		JLabel nome_projeto = new JLabel("HOTEL RIVIERA - Projeto de Laboratório de Programação 2\r\n\r\n");
		nome_projeto.setForeground(new Color(0, 0, 0));
		nome_projeto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nome_projeto.setBounds(227, 181, 405, 128);
		add(nome_projeto);
		
		JLabel lblProfessorGustavoSoares = new JLabel("PROFESSOR: \r\n\r\nGustavo Soares");
		lblProfessorGustavoSoares.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorGustavoSoares.setBounds(227, 240, 232, 109);
		add(lblProfessorGustavoSoares);
		
		JLabel lblGrupo = new JLabel("GRUPO:");
		lblGrupo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGrupo.setBounds(228, 309, 206, 90);
		add(lblGrupo);
		
		JLabel lblAdielAndrade = new JLabel("Adiel Andrade");
		lblAdielAndrade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdielAndrade.setBounds(261, 380, 146, 26);
		add(lblAdielAndrade);
		
		JLabel lblEdvalMatheus = new JLabel("Edval Matheus");
		lblEdvalMatheus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEdvalMatheus.setBounds(261, 417, 146, 26);
		add(lblEdvalMatheus);
		
		JLabel lblHugoGabrielBezerra = new JLabel("Hugo Gabriel Bezerra");
		lblHugoGabrielBezerra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHugoGabrielBezerra.setBounds(261, 454, 146, 26);
		add(lblHugoGabrielBezerra);
		
		JLabel lblJooVictorMafra = new JLabel("João Victor Mafra");
		lblJooVictorMafra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJooVictorMafra.setBounds(261, 491, 146, 26);
		add(lblJooVictorMafra);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new PaginaInicialHotel());
			}
		});
		btnVoltar.setBackground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVoltar.setBounds(359, 534, 89, 23);
		add(btnVoltar);

	}
}
