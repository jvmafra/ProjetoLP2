package gui.servicos;

import gui.PaginaInicialHotel;
import gui.Sistema;
import gui.contratos.VisualizaContrato;

import javax.swing.JPanel;
import javax.swing.JButton;

import classes.Pessoa.Contrato;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpcoesDeServicos extends JPanel {
	private Contrato contrato;

	/**
	 * Create the panel.
	 */
	public OpcoesDeServicos(Contrato contrato) {
		this.contrato = contrato;
		setLayout(null);
		setBounds(0, 0, 800, 600);
		JButton btnAlguelDeCarro = new JButton("Alugar Carro");
		btnAlguelDeCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new AlugaCarro(getContrato()));
			}
		});
		btnAlguelDeCarro.setBounds(240, 49, 136, 32);
		add(btnAlguelDeCarro);
		
		JButton btnContrataBab = new JButton("Contratar Bab\u00E1");
		btnContrataBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new ContrataBaba(getContrato()));
			}
		});
		btnContrataBab.setBounds(240, 106, 136, 32);
		add(btnContrataBab);
		
		JButton btnAdicionaRefeio = new JButton("Adicionar Refei\u00E7\u00E3o");
		btnAdicionaRefeio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovaRefeicao(getContrato()));
			}
		});
		btnAdicionaRefeio.setBounds(237, 161, 139, 32);
		add(btnAdicionaRefeio);

		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new VisualizaContrato(getContrato()));
			}
		});
		btnVoltar.setBounds(64, 241, 89, 23);
		add(btnVoltar);

	}
	public Contrato getContrato(){
		return contrato;
	}
}
