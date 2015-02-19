package gui.servicos;

import gui.PaginaInicialHotel;
import gui.Sistema;
import gui.contratos.VisualizaContrato;

import javax.swing.JPanel;
import javax.swing.JButton;

import nucleo.classes.pessoa.Contrato;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class OpcoesDeServicos extends JPanel {
	private Contrato contrato;

	/**
	 * Create the panel.
	 */
	public OpcoesDeServicos(Contrato contrato) {
		setBackground(Color.WHITE);
		this.contrato = contrato;
		setLayout(null);
		setBounds(0, 0, 800, 600);
		JButton btnAlguelDeCarro = new JButton("ALUGAR CARRO");
		btnAlguelDeCarro.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnAlguelDeCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new AlugaCarro(getContrato()));
			}
		});
		btnAlguelDeCarro.setBounds(292, 105, 160, 53);
		add(btnAlguelDeCarro);
		
		JButton btnContrataBab = new JButton("CONTRATAR BABA");
		btnContrataBab.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnContrataBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new ContrataBaba(getContrato()));
			}
		});
		btnContrataBab.setBounds(292, 206, 160, 53);
		add(btnContrataBab);
		
		JButton btnAdicionaRefeio = new JButton("NOVA REFEICAO");
		btnAdicionaRefeio.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnAdicionaRefeio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovaRefeicao(getContrato()));
			}
		});
		btnAdicionaRefeio.setBounds(292, 297, 156, 53);
		add(btnAdicionaRefeio);

		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new VisualizaContrato(getContrato()));
			}
		});
		btnVoltar.setBounds(329, 449, 89, 23);
		add(btnVoltar);

	}
	public Contrato getContrato(){
		return contrato;
	}
}