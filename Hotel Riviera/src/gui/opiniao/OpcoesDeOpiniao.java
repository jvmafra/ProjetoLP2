package gui.opiniao;

import gui.PaginaInicialHotel;
import gui.Sistema;
import gui.gerente.OpcoesEstatisticas;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class OpcoesDeOpiniao extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public OpcoesDeOpiniao() {
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		JButton btnNovaOpinio = new JButton("NOVA OPINIAO");
		btnNovaOpinio.setForeground(new Color(51, 102, 153));
		btnNovaOpinio.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNovaOpinio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new CadastraOpiniao());
			}
		});
		btnNovaOpinio.setBounds(234, 201, 328, 51);
		add(btnNovaOpinio);
		
		JButton btnQualificaoDoHotel = new JButton("MEDIA DO HOTEL");
		btnQualificaoDoHotel.setForeground(new Color(51, 102, 153));
		btnQualificaoDoHotel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQualificaoDoHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Sistema.getHotel().getOpinioes().size() == 0)
					JOptionPane.showMessageDialog(null, "Nao existem opinioes cadastradas");
				else
					Sistema.setTela(new QualificacaoDoHotel());
			}
		});
		btnQualificaoDoHotel.setBounds(234, 297, 328, 51);
		add(btnQualificaoDoHotel);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesEstatisticas());
			}
		});
		btnVoltar.setBounds(349, 431, 89, 23);
		add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(OpcoesDeOpiniao.class.getResource("/nucleo/icones/hotel4.png")));
		label.setBounds(325, 27, 138, 105);
		add(label);

	}

}