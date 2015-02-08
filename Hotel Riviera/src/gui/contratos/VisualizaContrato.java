package gui.contratos;

import gui.Sistema;
import gui.servicos.OpcoesDeServicos;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import classes.Pessoa.Contrato;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizaContrato extends JPanel {
	private JTextField status;
	private JTextField servicos;
	private Contrato contrato;

	/**
	 * Create the panel.
	 */
	public VisualizaContrato(Contrato contrato) {
		this.contrato = contrato;
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		status = new JTextField();
		status.setEditable(false);
		status.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		status.setBounds(22, 86, 248, 391);
		add(status);
		status.setColumns(10);
		status.setText(getContrato().mostraStatus());
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.setBounds(68, 532, 117, 25);
		add(btnVoltar);
		
		JButton btnFecharContrato = new JButton("Fechar Contrato");
		btnFecharContrato.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnFecharContrato.setBounds(603, 349, 162, 25);
		add(btnFecharContrato);
		
		JButton btnNewButton = new JButton("Adicionar Serviço");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeServicos(getContrato()));
			}
		});
		btnNewButton.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnNewButton.setBounds(603, 282, 162, 25);
		add(btnNewButton);
		
		servicos = new JTextField();
		servicos.setEditable(false);
		servicos.setBounds(350, 86, 241, 391);
		add(servicos);
		servicos.setColumns(10);
		servicos.setText(getContrato().imprimeCadaServicoEspecial());
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnNewButton_1.setBounds(603, 221, 162, 25);
		add(btnNewButton_1);

	}
	
	public Contrato getContrato(){
		return contrato;
	}
}
