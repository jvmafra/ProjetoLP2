package gui.gerente;

import gui.Sistema;
import gui.opiniao.OpcoesDeOpiniao;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpcoesEstatisticas extends JPanel {

	private static final long serialVersionUID = 1L;

	public OpcoesEstatisticas() {
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		JButton btnFaturamento = new JButton("FATURAMENTO");
		btnFaturamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new FaturamentoDoHotel());
			}
		});
		btnFaturamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFaturamento.setBounds(274, 175, 233, 37);
		add(btnFaturamento);
		
		JButton btnServicos = new JButton("SERVICOS PREFERIDOS");
		btnServicos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnServicos.setBounds(274, 237, 233, 37);
		add(btnServicos);
		
		JButton btnHospedes = new JButton("HOSPEDES +");
		btnHospedes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHospedes.setBounds(274, 300, 233, 37);
		add(btnHospedes);
		
		JButton btnOpinioes = new JButton("OPINIOES");
		btnOpinioes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeOpiniao());
			}
		});
		btnOpinioes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnOpinioes.setBounds(274, 365, 233, 37);
		add(btnOpinioes);
	}

}
