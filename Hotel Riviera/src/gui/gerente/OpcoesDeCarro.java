package gui.gerente;

import gui.Sistema;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
		setBounds(0,0,800,600);
		JButton btnEditaCarro = new JButton("EDITA CARRO");
		btnEditaCarro.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnEditaCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new ConsultaCarro());
			}
		});
		btnEditaCarro.setBounds(289, 252, 210, 77);
		add(btnEditaCarro);
		
		JButton btnCadastraBab = new JButton("CADASTRA CARRO");
		btnCadastraBab.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnCadastraBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovoCarro());
			}
		});
		btnCadastraBab.setBounds(289, 121, 212, 77);
		add(btnCadastraBab);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new OpcoesPrivadas());
			}
		});
		btnVoltar.setBounds(343, 394, 117, 25);
		add(btnVoltar);
		

	}

}