package gui.gerente;

import gui.Sistema;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class OpcoesDeBaba extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public OpcoesDeBaba() {
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0,0,800,600);
		JButton btnEditaBab = new JButton("EDITA BABA");
		btnEditaBab.setForeground(new Color(51, 102, 153));
		btnEditaBab.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnEditaBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new ConsultaBabas());
			}
		});
		btnEditaBab.setBounds(296, 338, 210, 77);
		add(btnEditaBab);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new OpcoesPrivadas());
			}
		});
		btnVoltar.setBounds(345, 469, 117, 25);
		add(btnVoltar);
		
		JButton btnNewButton = new JButton("CADASTRA BABA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovaBaba());
			}
		});
		btnNewButton.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnNewButton.setForeground(new Color(51, 102, 153));
		btnNewButton.setBounds(296, 229, 210, 77);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("OPCOES DE BABA");
		lblNewLabel.setFont(new Font("Bitstream Charter", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(289, 134, 278, 40);
		add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(OpcoesDeBaba.class.getResource("/nucleo/icones/hotel4.png")));
		label.setBounds(325, 24, 151, 98);
		add(label);
		

	}
}