package gui.gerente;

import gui.PaginaInicialHotel;
import gui.Sistema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;

public class OpcoesPrivadas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public OpcoesPrivadas() {
		setLayout(null);
		setBounds(0, 0, 800, 600);
		JButton btnFaturamentos = new JButton("FATURAMENTOS");
		btnFaturamentos.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnFaturamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new FaturamentoDoHotel());
			}
		});
		btnFaturamentos.setBounds(320, 107, 174, 33);
		add(btnFaturamentos);
		
		JButton btnCadastraFuncionrio = new JButton("NOVO FUNCIONARIO");
		btnCadastraFuncionrio.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnCadastraFuncionrio.setBounds(320, 177, 174, 33);
		add(btnCadastraFuncionrio);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new PaginaInicialHotel());
			}
		});
		btnVoltar.setBounds(357, 482, 89, 23);
		add(btnVoltar);
		
		JButton btnCadastroCarro = new JButton("CARRO");
		btnCadastroCarro.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnCadastroCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeCarro());
			}
		});
		btnCadastroCarro.setBounds(320, 240, 174, 33);
		add(btnCadastroCarro);
		
		JButton btnCadastraBab = new JButton("BABA");
		btnCadastraBab.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnCadastraBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeBaba());
			}
		});
		btnCadastraBab.setBounds(320, 308, 174, 33);
		add(btnCadastraBab);
		
		JButton btnCadastraQuarto = new JButton("CADASTRA QUARTO");
		btnCadastraQuarto.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnCadastraQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new CadastroQuarto());
			}
		});
		btnCadastraQuarto.setBounds(320, 385, 174, 33);
		add(btnCadastraQuarto);

	}

}