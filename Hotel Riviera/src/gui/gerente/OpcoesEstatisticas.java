package gui.gerente;

import gui.Sistema;
import gui.opiniao.OpcoesDeOpiniao;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class OpcoesEstatisticas extends JPanel {

	private static final long serialVersionUID = 1L;

	public OpcoesEstatisticas() {
		setBackground(new Color(51, 102, 153));
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		JButton btnFaturamento = new JButton("FATURAMENTO");
		btnFaturamento.setForeground(new Color(51, 102, 153));
		btnFaturamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new FaturamentoDoHotel());
			}
		});
		btnFaturamento.setFont(new Font("Dialog", Font.BOLD, 15));
		btnFaturamento.setBounds(285, 174, 233, 37);
		add(btnFaturamento);
		
		JButton btnServicos = new JButton("SERVICOS PREFERIDOS");
		btnServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new ServicosPreferidos());
			}
		});
		btnServicos.setForeground(new Color(51, 102, 153));
		btnServicos.setFont(new Font("Dialog", Font.BOLD, 15));
		btnServicos.setBounds(285, 235, 233, 37);
		add(btnServicos);
		
		JButton btnHospedes = new JButton("HOSPEDES +");
		btnHospedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new HospedesMais());
			}
		});
		btnHospedes.setForeground(new Color(51, 102, 153));
		btnHospedes.setFont(new Font("Dialog", Font.BOLD, 15));
		btnHospedes.setBounds(285, 297, 233, 37);
		add(btnHospedes);
		
		JButton btnOpinioes = new JButton("OPINIOES");
		btnOpinioes.setForeground(new Color(51, 102, 153));
		btnOpinioes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeOpiniao());
			}
		});
		btnOpinioes.setFont(new Font("Dialog", Font.BOLD, 15));
		btnOpinioes.setBounds(285, 363, 233, 37);
		add(btnOpinioes);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesPrivadas());
			}
		});
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnVoltar.setBounds(357, 462, 90, 30);
		add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(OpcoesEstatisticas.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(319, 30, 151, 105);
		add(lblNewLabel);
	}
}
