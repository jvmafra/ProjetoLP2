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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		status.setText(getContrato().imprimeResumoAtual());
		status.setEditable(false);
		status.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		status.setBounds(22, 86, 248, 391);
		add(status);
		status.setColumns(10);
		status.setText(getContrato().mostraStatus());
		
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
		
		JButton btnNewButton = new JButton("Adicionar Serviço");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeServicos(getContrato()));
			}
		});
		btnNewButton.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnNewButton.setBounds(613, 230, 162, 25);
		add(btnNewButton);
		
		servicos = new JTextField();
		servicos.setEditable(false);
		servicos.setText(getContrato().imprimeCadaServicoEspecial());
		servicos.setBounds(350, 86, 241, 391);
		add(servicos);
		servicos.setColumns(10);
		servicos.setText(getContrato().imprimeCadaServicoEspecial());

	}
	
	public Contrato getContrato(){
		return contrato;
	}
}
