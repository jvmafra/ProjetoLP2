package gui.contratos;

import gui.PaginaInicialHotel;
import gui.Sistema;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;

public class OpcoesDeContrato extends JPanel {

	/**
	 * Create the panel.
	 */
	public OpcoesDeContrato() {
		setBackground(new Color(51, 102, 153));
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		JButton btnContratosEmAberto = new JButton("CONTRATOS EXISTENTES");
		btnContratosEmAberto.setForeground(new Color(51, 102, 153));
		btnContratosEmAberto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new BuscaContrato());

		}});
		btnContratosEmAberto.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnContratosEmAberto.setBounds(266, 275, 277, 57);
		add(btnContratosEmAberto);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(364, 436, 77, 25);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new PaginaInicialHotel());
			}
		});
		add(btnVoltar);
		
		JButton btnNovoContrato = new JButton("NOVO CONTRATO");
		btnNovoContrato.setForeground(new Color(51, 102, 153));
		btnNovoContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new NovoContrato());
			}
		});
		btnNovoContrato.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNovoContrato.setBounds(266, 157, 277, 65);
		add(btnNovoContrato);

	}
}