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
import nucleo.classes.pessoa.Contrato;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VisualizaContrato extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea servicos;
	private Contrato contrato;

	/**
	 * Create the panel.
	 */
	public VisualizaContrato(Contrato contrato) {
		setBackground(new Color(51, 102, 153));
		this.contrato = contrato;
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeContrato());
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(89, 537, 90, 30);
		add(btnVoltar);
		
		JButton btnFecharContrato = new JButton("Fechar Contrato");
		btnFecharContrato.setForeground(new Color(51, 102, 153));
		btnFecharContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (getContrato().isAberto()) {
					int j = JOptionPane.showConfirmDialog(null, "Deseja mesmo fechar o contrato?");
					if (j == 0) {
						Sistema.getHotel().check_out(getContrato());
						Sistema.setTela(new FaturaFinal(getContrato()));
					}
					
					else  {
						Sistema.setTela(new VisualizaContrato(getContrato()));
					}
				}
				
				else
					JOptionPane.showMessageDialog(null, "O contrato ja foi fechado!");
				
			}
		});
		btnFecharContrato.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFecharContrato.setBounds(514, 537, 150, 30);
		add(btnFecharContrato);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VisualizaContrato.class.getResource("/nucleo/icones/hotel4 feito.png")));
		lblNewLabel.setBounds(326, 11, 161, 105);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Novo Serviço");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getContrato().isAberto())
					Sistema.setTela(new OpcoesDeServicos(getContrato()));
				else
					JOptionPane.showMessageDialog(null, "O contrato ja foi fechado!");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setForeground(new Color(51, 102, 153));
		btnNewButton.setBounds(282, 536, 150, 30);
		add(btnNewButton);
		
		JScrollPane scrStatus = new JScrollPane();
		scrStatus.setBounds(57, 145, 290, 360);
		
		JTextArea status = new JTextArea();
		status.setText(getContrato().imprimeResumoAtual());
		status.setFont(new Font("Tahoma", Font.PLAIN, 13));
		status.setBounds(57, 146, 291, 362);
		status.setBackground(new Color(51, 102, 153));
		status.setForeground(new Color(255, 255, 255));
		status.setEditable(false);
		
		scrStatus.setViewportView(status);
		add(scrStatus);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(462, 145, 290, 360);
		
		servicos = new JTextArea();
		servicos.setBackground(new Color(51, 102, 153));
		servicos.setForeground(new Color(255, 255, 255));
		servicos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		servicos.setText(getContrato().imprimeCadaServicoEspecial());
		servicos.setEditable(false);
		
		scrollPane.setViewportView(servicos);
		add(scrollPane);

	}
	
	public Contrato getContrato(){
		return contrato;
	}
}