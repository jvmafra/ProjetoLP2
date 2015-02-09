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

public class OpcoesDeContrato extends JPanel {

	/**
	 * Create the panel.
	 */
	public OpcoesDeContrato() {
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		JButton btnContratosEmAberto = new JButton("CONTRATOS EXISTENTES");
		btnContratosEmAberto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					Sistema.setTela(new BuscaContrato());

		}});
		btnContratosEmAberto.setFont(new Font("NanumGothic", Font.BOLD, 14));
		btnContratosEmAberto.setBounds(266, 275, 277, 57);
		add(btnContratosEmAberto);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 15));
		btnVoltar.setBounds(372, 456, 77, 25);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new PaginaInicialHotel());
			}
		});
		add(btnVoltar);
		
		JButton btnNovoContrato = new JButton("NOVO CONTRATO");
		btnNovoContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new NovoContrato());
			}
		});
		btnNovoContrato.setFont(new Font("NanumGothic", Font.BOLD, 15));
		btnNovoContrato.setBounds(266, 157, 277, 65);
		add(btnNovoContrato);

	}
}
