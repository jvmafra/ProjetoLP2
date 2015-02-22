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
import javax.swing.JLabel;
import javax.swing.ImageIcon;

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
		setBackground(new Color(51, 102, 153));
		this.hospede = h;
		setBounds(0,0,800,600);
		setLayout(null);
		
		JTextPane texthospede = new JTextPane();
		texthospede.setForeground(new Color(255, 255, 255));
		texthospede.setBackground(new Color(51, 102, 153));
		texthospede.setFont(new Font("Tahoma", Font.PLAIN, 14));
		texthospede.setBounds(306, 166, 314, 231);
		texthospede.setText(hospede.mostraInformacoes());
		texthospede.setEditable(false);
		add(texthospede);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new ConsultaHospede());
			}
		});
		btnVoltar.setBounds(356, 408, 89, 23);
		add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ExibeHospede.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(323, 22, 138, 89);
		add(lblNewLabel);

	}
}