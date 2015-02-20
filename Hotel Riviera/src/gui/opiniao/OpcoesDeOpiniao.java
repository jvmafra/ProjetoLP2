package gui.opiniao;

import gui.PaginaInicialHotel;
import gui.Sistema;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class OpcoesDeOpiniao extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public OpcoesDeOpiniao() {
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		JButton btnNovaOpinio = new JButton("NOVA OPINIAO");
		btnNovaOpinio.setFont(new Font("NanumGothic", Font.BOLD, 15));
		btnNovaOpinio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new CadastraOpiniao());
			}
		});
		btnNovaOpinio.setBounds(234, 113, 328, 51);
		add(btnNovaOpinio);
		
		JButton btnQualificaoDoHotel = new JButton("MEDIA DO HOTEL");
		btnQualificaoDoHotel.setFont(new Font("NanumGothic", Font.BOLD, 15));
		btnQualificaoDoHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Sistema.getHotel().getOpinioes().size() == 0)
					JOptionPane.showMessageDialog(null, "Nao existem opinioes cadastradas");
				else
					Sistema.setTela(new QualificacaoDoHotel());
			}
		});
		btnQualificaoDoHotel.setBounds(234, 201, 328, 51);
		add(btnQualificaoDoHotel);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("NanumGothic", Font.BOLD, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new PaginaInicialHotel());
			}
		});
		btnVoltar.setBounds(349, 431, 89, 23);
		add(btnVoltar);

	}

}