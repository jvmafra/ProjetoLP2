package gui.hospede;

import gui.EnviaEmail;
import gui.Sistema;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import nucleo.classes.pessoa.Contrato;
import nucleo.classes.pessoa.Hospede;

public class ExibeHospede extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Hospede hospede;
	private JTextField contratos;
	private JTextField atualmente;
	/**
	 * Create the panel.
	 */
	public ExibeHospede(Hospede h) {
		setBackground(new Color(51, 102, 153));
		this.hospede = h;
		setBounds(0,0,800,600);
		setLayout(null);
		
		JTextArea texthospede = new JTextArea();
		texthospede.setForeground(new Color(255, 255, 255));
		texthospede.setBackground(new Color(51, 102, 153));
		texthospede.setFont(new Font("Tahoma", Font.PLAIN, 14));
		texthospede.setBounds(250, 163, 314, 177);
		texthospede.setText(hospede.mostraInformacoes());
		texthospede.setEditable(false);
		add(texthospede);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new OpcoesDoHospede());
			}
		});
		btnVoltar.setBounds(250, 524, 90, 30);
		add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ExibeHospede.class.getResource("/nucleo/icones/hotel4 feito.png")));
		lblNewLabel.setBounds(323, 22, 138, 89);
		add(lblNewLabel);
		
		JLabel lblRe = new JLabel("Reservas ja efetuadas: ");
		lblRe.setForeground(new Color(255, 255, 255));
		lblRe.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblRe.setBounds(306, 379, 183, 15);
		add(lblRe);
		
		contratos = new JTextField();
		contratos.setBackground(new Color(51, 102, 153));
		contratos.setForeground(new Color(255, 255, 255));
		contratos.setFont(new Font("Dialog", Font.PLAIN, 14));
		contratos.setEditable(false);
		contratos.setBounds(473, 377, 38, 30);
		add(contratos);
		contratos.setColumns(10);
		contratos.setText(String.valueOf(contratosJaFeitos()));
		contratos.setOpaque(false);
		
		JLabel lblAtualmente = new JLabel("Atualmente:");
		lblAtualmente.setForeground(new Color(255, 255, 255));
		lblAtualmente.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblAtualmente.setBounds(306, 435, 100, 15);
		add(lblAtualmente);
		
		atualmente = new JTextField();
		atualmente.setBackground(new Color(51, 102, 153));
		atualmente.setEditable(false);
		atualmente.setFont(new Font("Dialog", Font.PLAIN, 14));
		atualmente.setForeground(new Color(255, 255, 255));
		atualmente.setBounds(397, 428, 180, 30);
		add(atualmente);
		atualmente.setColumns(10);
		atualmente.setText(atualmente());
		atualmente.setOpaque(false);
		atualmente.setEditable(false);
		
		JButton btnEmail = new JButton("Email");
		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new EnviaEmail(hospede));
			}
		});
		btnEmail.setForeground(new Color(51, 102, 153));
		btnEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEmail.setBounds(474, 524, 90, 30);
		add(btnEmail);

	}
	
	public int contratosJaFeitos(){
		return Sistema.getHotel().pesquisaContrato(hospede.getNome()).size();
	}
	
	public String atualmente() {
		Calendar hoje = new GregorianCalendar();
		for (Contrato contrato: Sistema.getHotel().pesquisaContrato(hospede.getNome())){
			if (contrato.getPeriodo().dataIsContida(hoje))
				return contrato.getQuarto().toString();
		}
		
		return "Nao hospedado";
	}
}