package gui.opiniao;

import gui.PaginaInicialHotel;
import gui.Sistema;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpcoesDeOpiniao extends JPanel {

	/**
	 * Create the panel.
	 */
	public OpcoesDeOpiniao() {
		setLayout(null);
		
		JButton btnNovaOpinio = new JButton("Nova Opini\u00E3o");
		btnNovaOpinio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new CadastraOpiniao());
			}
		});
		btnNovaOpinio.setBounds(257, 88, 147, 51);
		add(btnNovaOpinio);
		
		JButton btnQualificaoDoHotel = new JButton("Qualifica\u00E7\u00E3o do Hotel");
		btnQualificaoDoHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new QualificacaoDoHotel());
			}
		});
		btnQualificaoDoHotel.setBounds(256, 171, 148, 51);
		add(btnQualificaoDoHotel);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new PaginaInicialHotel());
			}
		});
		btnVoltar.setBounds(72, 310, 89, 23);
		add(btnVoltar);

	}

}
