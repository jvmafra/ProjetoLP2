package gui.servicos;

import gui.PaginaInicialHotel;
import gui.Sistema;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpcoesDeServicos extends JPanel {

	/**
	 * Create the panel.
	 */
	public OpcoesDeServicos() {
		setLayout(null);
		
		JButton btnAlguelDeCarro = new JButton("Alugar Carro");
		btnAlguelDeCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new AlugaCarro());
			}
		});
		btnAlguelDeCarro.setBounds(240, 49, 136, 32);
		add(btnAlguelDeCarro);
		
		JButton btnContrataBab = new JButton("Contratar Bab\u00E1");
		btnContrataBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new ContrataBaba());
			}
		});
		btnContrataBab.setBounds(240, 106, 136, 32);
		add(btnContrataBab);
		
		JButton btnAdicionaRefeio = new JButton("Adicionar Refei\u00E7\u00E3o");
		btnAdicionaRefeio.setBounds(237, 161, 139, 32);
		add(btnAdicionaRefeio);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new PaginaInicialHotel());
			}
		});
		btnVoltar.setBounds(64, 241, 89, 23);
		add(btnVoltar);

	}
}
