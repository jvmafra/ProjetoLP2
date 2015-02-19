package gui.hospede;

import gui.Sistema;

import javax.swing.JPanel;

import nucleo.classes.pessoa.Hospede;

import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

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
		setBackground(Color.WHITE);
		this.hospede = h;
		setBounds(0,0,800,600);
		setLayout(null);
		
		JTextPane texthospede = new JTextPane();
		texthospede.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		texthospede.setBounds(268, 46, 244, 282);
		texthospede.setText(hospede.mostraInformacoes());
		texthospede.setEditable(false);
		add(texthospede);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new ConsultaHospede());
			}
		});
		btnVoltar.setBounds(351, 340, 89, 23);
		add(btnVoltar);

	}
}