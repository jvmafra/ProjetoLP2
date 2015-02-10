package gui.gerente;

import gui.Sistema;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpcoesDeCarro extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public OpcoesDeCarro() {
		setLayout(null);
		
		JButton btnEditaCarro = new JButton("Edita Carro");
		btnEditaCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new ConsultaCarro());
			}
		});
		btnEditaCarro.setBounds(187, 163, 210, 77);
		add(btnEditaCarro);
		
		JButton btnCadastraBab = new JButton("Cadastra Carro");
		btnCadastraBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovoCarro());
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
