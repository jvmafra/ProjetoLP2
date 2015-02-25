package gui;

import gui.contratos.OpcoesDeContrato;
import gui.gerente.OpcoesPrivadas;
import gui.hospede.OpcoesDoHospede;
import gui.opiniao.OpcoesDeOpiniao;
import gui.servicos.OpcoesDeServicos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PaginaInicialHotel extends JPanel {
	
	private static final long serialVersionUID = 1L;


	public PaginaInicialHotel() {
		setBackground(new Color(51, 102, 153));
		repaint();
		setBounds(0, 0, 800, 600);
				
		final JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 153));
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0,863,666);		
		setLayout(null);
		add(panel);
		panel.setLayout(null);
		
		JButton btnHospede = new JButton("H\u00D3SPEDE");
		btnHospede.setForeground(new Color(51, 102, 153));
		btnHospede.setIcon(null);
		btnHospede.setBounds(317, 146, 150, 50);

		btnHospede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDoHospede());
			}
		});
		btnHospede.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(btnHospede);
		
		JButton btnContratos = new JButton("CONTRATOS");
		btnContratos.setForeground(new Color(51, 102, 153));
		btnContratos.setBounds(317, 224, 150, 50);
		btnContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeContrato());
			}
		});
		btnContratos.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(btnContratos);
		
		JButton btnOpinies = new JButton("SOBRE");
		btnOpinies.setForeground(new Color(51, 102, 153));
		btnOpinies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOpinies.setBounds(317, 380, 150, 50);
		btnOpinies.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(btnOpinies);
		
		JButton btnReservaldo = new JButton("RESERVADO");
		btnReservaldo.setForeground(new Color(51, 102, 153));
		btnReservaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new LoginDeFuncionario(true));
			}
		});
		btnReservaldo.setBounds(317, 301, 150, 50);
		btnReservaldo.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(btnReservaldo);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setForeground(new Color(51, 102, 153));
		btnSair.setBounds(317, 459, 150, 50);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new LoginDeFuncionario(false));
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PaginaInicialHotel.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(317, 30, 158, 94);
		panel.add(lblNewLabel);

	}


}	