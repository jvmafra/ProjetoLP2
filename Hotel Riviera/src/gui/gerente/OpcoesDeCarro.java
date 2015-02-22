package gui.gerente;

import gui.Sistema;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class OpcoesDeCarro extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public OpcoesDeCarro() {
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0,0,800,600);
		JButton btnEditaCarro = new JButton("EDITA CARRO");
		btnEditaCarro.setForeground(new Color(51, 102, 153));
		btnEditaCarro.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnEditaCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new ConsultaCarro());
			}
		});
		btnEditaCarro.setBounds(304, 351, 210, 77);
		add(btnEditaCarro);
		
		JButton btnCadastraBab = new JButton("CADASTRA CARRO");
		btnCadastraBab.setForeground(new Color(51, 102, 153));
		btnCadastraBab.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnCadastraBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovoCarro());
			}
		});
		btnCadastraBab.setBounds(302, 228, 212, 77);
		add(btnCadastraBab);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new OpcoesPrivadas());
			}
		});
		btnVoltar.setBounds(346, 485, 117, 25);
		add(btnVoltar);
		
		JLabel lblNewLabel2 = new JLabel("OPCOES DE CARRO");
		lblNewLabel2.setFont(new Font("Bitstream Charter", Font.BOLD, 26));
		lblNewLabel2.setForeground(new Color(255, 255, 255));
		lblNewLabel2.setBounds(289, 134, 278, 40);
		add(lblNewLabel2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(OpcoesDeCarro.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(332, 30, 235, 105);
		add(lblNewLabel);
		

	}

}