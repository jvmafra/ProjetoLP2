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
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

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
		setBackground(new Color(51, 102, 153));
		this.contrato = contrato;
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeContrato());
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(89, 519, 117, 25);
		add(btnVoltar);
		
		JButton btnFecharContrato = new JButton("FECHAR CONTRATO");
		btnFecharContrato.setForeground(new Color(51, 102, 153));
		btnFecharContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContrato().fechaContrato();
				Sistema.setTela(new VisualizaContrato(getContrato()));
				
			}
		});
		btnFecharContrato.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFecharContrato.setBounds(514, 519, 188, 25);
		add(btnFecharContrato);
		
		JTextPane status = new JTextPane();
		status.setBackground(new Color(51, 102, 153));
		status.setForeground(new Color(255, 255, 255));
		status.setFont(new Font("Tahoma", Font.PLAIN, 13));
		status.setBounds(57, 146, 291, 362);
		status.setText(getContrato().imprimeResumoAtual());
		add(status);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VisualizaContrato.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(326, 11, 161, 105);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("NOVO SERVICO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getContrato().isAberto())
					Sistema.setTela(new OpcoesDeServicos(getContrato()));
				else
					JOptionPane.showMessageDialog(null, "O contrato ja foi fechado!");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(51, 102, 153));
		btnNewButton.setBounds(282, 518, 161, 26);
		add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(450, 126, 302, 382);
		add(scrollPane);
		
		servicos = new JTextPane();
		scrollPane.setViewportView(servicos);
		servicos.setBackground(new Color(51, 102, 153));
		servicos.setForeground(new Color(255, 255, 255));
		servicos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		servicos.setEditable(false);
		servicos.setText(getContrato().imprimeCadaServicoEspecial());
		servicos.setText(getContrato().imprimeCadaServicoEspecial());

	}
	
	public Contrato getContrato(){
		return contrato;
	}
}