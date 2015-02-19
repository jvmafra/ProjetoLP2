package gui.gerente;

import gui.Sistema;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
		setBounds(0,0,800,600);
		JButton btnEditaBab = new JButton("EDITA BABA");
		btnEditaBab.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnEditaBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new ConsultaBabas());
			}
		});
		btnEditaBab.setBounds(287, 264, 210, 77);
		add(btnEditaBab);
		
		JButton btnCadastraBab = new JButton("CADASTRA BABA");
		btnCadastraBab.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnCadastraBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovaBaba());
			}
		});
		btnCadastraBab.setBounds(287, 117, 212, 77);
		add(btnCadastraBab);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new OpcoesPrivadas());
			}
		});
		btnVoltar.setBounds(339, 405, 117, 25);
		add(btnVoltar);
		

	}
}