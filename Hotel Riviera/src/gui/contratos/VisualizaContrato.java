package gui.contratos;

import gui.Sistema;
import gui.servicos.OpcoesDeServicos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import nucleo.classes.pessoa.Contrato;

public class VisualizaContrato extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextPane servicos;
	private Contrato contrato;

	/**
	 * Create the panel.
	 */
	public VisualizaContrato(Contrato contrato) {
		setBackground(Color.WHITE);
		this.contrato = contrato;
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new BuscaContrato());
			}
		});
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.setBounds(68, 532, 117, 25);
		add(btnVoltar);
		
		JButton btnFecharContrato = new JButton("Fechar Contrato");
		btnFecharContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContrato().fechaContrato();
				Sistema.setTela(new VisualizaContrato(getContrato()));
				
			}
		});
		btnFecharContrato.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnFecharContrato.setBounds(613, 319, 162, 25);
		add(btnFecharContrato);
		
		JButton btnNewButton = new JButton("Adicionar Servico");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getContrato().isAberto())
					Sistema.setTela(new OpcoesDeServicos(getContrato()));
				else
					JOptionPane.showMessageDialog(null, "O contrato ja foi fechado!");
			}
		});
		
		btnNewButton.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnNewButton.setBounds(613, 230, 162, 25);
		add(btnNewButton);
		
		servicos = new JTextPane();
		servicos.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		servicos.setEditable(false);
		servicos.setText(getContrato().imprimeCadaServicoEspecial());
		servicos.setBounds(350, 86, 241, 391);
		add(servicos);
		servicos.setText(getContrato().imprimeCadaServicoEspecial());
		
		JTextPane status = new JTextPane();
		status.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		status.setBounds(50, 78, 234, 399);
		status.setText(getContrato().imprimeResumoAtual());
		add(status);

	}
	
	public Contrato getContrato(){
		return contrato;
	}
}