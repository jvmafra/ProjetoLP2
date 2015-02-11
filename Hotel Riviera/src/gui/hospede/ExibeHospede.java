package gui.hospede;

import gui.Sistema;

import javax.swing.JPanel;

import classes.Pessoa.Hospede;

import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExibeHospede extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Hospede hospede;
	/**
	 * Create the panel.
	 */
	public ExibeHospede(Hospede h) {
		this.hospede = h;
		setLayout(null);
		
		JTextPane texthospede = new JTextPane();
		texthospede.setBounds(157, 45, 206, 240);
		texthospede.setText(hospede.mostraInformacoes());
		texthospede.setEditable(false);
		add(texthospede);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new ConsultaHospede());
			}
		});
		btnVoltar.setBounds(204, 326, 89, 23);
		add(btnVoltar);

	}
}
