package gui.opcoesdogerente;

import gui.PaginaInicialHotel;
import gui.Sistema;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		JButton btnFaturamentos = new JButton("Faturamentos");
		btnFaturamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new FaturamentoDoHotel());
			}
		});
		btnFaturamentos.setBounds(117, 44, 174, 33);
		add(btnFaturamentos);
		
		JButton btnCadastraFuncionrio = new JButton("Cadastra Funcion\u00E1rio");
		btnCadastraFuncionrio.setBounds(117, 88, 174, 33);
		add(btnCadastraFuncionrio);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new PaginaInicialHotel());
			}
		});
		btnVoltar.setBounds(40, 266, 89, 23);
		add(btnVoltar);
		
		JButton btnCadastroCarro = new JButton("Cadastra Carro");
		btnCadastroCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovoCarro());
			}
		});
		btnCadastroCarro.setBounds(117, 133, 174, 33);
		add(btnCadastroCarro);
		
		JButton btnCadastraBab = new JButton("Cadastra Bab\u00E1");
		btnCadastraBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovaBaba());
			}
		});
		btnCadastraBab.setBounds(117, 177, 174, 33);
		add(btnCadastraBab);
		
		JButton btnCadastraQuarto = new JButton("Cadastra Quarto");
		btnCadastraQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new CadastroQuarto());
			}
		});
		btnCadastraQuarto.setBounds(117, 216, 174, 33);
		add(btnCadastraQuarto);

	}

}
