package gui.servicos;

import gui.Sistema;
import gui.contratos.VisualizaContrato;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nucleo.classes.pessoa.Contrato;

public class OpcoesDeServicos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Contrato contrato;

	/**
	 * Create the panel.
	 */
	public OpcoesDeServicos(Contrato contrato) {
		setBackground(new Color(51, 102, 153));
		this.contrato = contrato;
		setLayout(null);
		setBounds(0, 0, 800, 600);
		JButton btnAlguelDeCarro = new JButton("ALUGAR CARRO");
		btnAlguelDeCarro.setForeground(new Color(51, 102, 153));
		btnAlguelDeCarro.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlguelDeCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new AlugaCarro(getContrato()));
			}
		});
		btnAlguelDeCarro.setBounds(309, 161, 187, 53);
		add(btnAlguelDeCarro);
		
		JButton btnContrataBab = new JButton("CONTRATAR BABA");
		btnContrataBab.setForeground(new Color(51, 102, 153));
		btnContrataBab.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnContrataBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new ContrataBaba(getContrato()));
			}
		});
		btnContrataBab.setBounds(309, 245, 187, 53);
		add(btnContrataBab);
		
		JButton btnAdicionaRefeio = new JButton("NOVA REFEICAO");
		btnAdicionaRefeio.setForeground(new Color(51, 102, 153));
		btnAdicionaRefeio.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdicionaRefeio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovaRefeicao(getContrato()));
			}
		});
		btnAdicionaRefeio.setBounds(309, 332, 187, 53);
		add(btnAdicionaRefeio);

		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new VisualizaContrato(getContrato()));
			}
		});
		btnVoltar.setBounds(351, 521, 90, 30);
		add(btnVoltar);
		
		JButton btnNewButton = new JButton("MASSAGEM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovaMassagem(getContrato()));
			}
		});
		btnNewButton.setForeground(new Color(51, 102, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(309, 419, 189, 53);
		add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(OpcoesDeServicos.class.getResource("/nucleo/icones/hotel4 feito.png")));
		label.setBounds(318, 23, 147, 102);
		add(label);

	}
	public Contrato getContrato(){
		return contrato;
	}
}