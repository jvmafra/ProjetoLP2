package gui.gerente;

import gui.Sistema;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpcoesDeBaba extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public OpcoesDeBaba() {
		setLayout(null);
		
		JButton btnEditaBab = new JButton("Edita Babá");
		btnEditaBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new ConsultaBabas());
			}
		});
		btnEditaBab.setBounds(187, 163, 210, 77);
		add(btnEditaBab);
		
		JButton btnCadastraBab = new JButton("Cadastra Babá");
		btnCadastraBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovaBaba());
			}
		});
		btnCadastraBab.setBounds(185, 41, 212, 77);
		add(btnCadastraBab);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new OpcoesPrivadas());
			}
		});
		btnVoltar.setBounds(85, 305, 117, 25);
		add(btnVoltar);
		

	}
}
