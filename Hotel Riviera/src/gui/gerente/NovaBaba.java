package gui.gerente;

import gui.Sistema;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nucleo.classes.servicos.*;


public class NovaBaba extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nome;
	private JTextField telefone;

	/**
	 * Create the frame.
	 */
	public NovaBaba() {
		setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		JLabel lblDescircao = new JLabel("Nome: ");
		lblDescircao.setBounds(282, 191, 71, 19);
		lblDescircao.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		add(lblDescircao);
		
		nome = new JTextField();
		nome.setBounds(336, 191, 151, 20);
		add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Telefone: ");
		lblNewLabel.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblNewLabel.setBounds(261, 245, 76, 19);
		add(lblNewLabel);
		
		telefone = new JTextField();
		telefone.setBounds(336, 245, 151, 20);
		add(telefone);
		telefone.setColumns(10);
		
		
		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeBaba());
			}
		});
		voltar.setFont(new Font("NanumGothic", Font.PLAIN, 12));
		voltar.setBounds(182, 319, 73, 27);
		add(voltar);
		
		JButton limpar = new JButton("Limpar");
		limpar.setFont(new Font("NanumGothic", Font.PLAIN, 12));
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome.setText("");
				telefone.setText("");
			}
		});
		limpar.setBounds(343, 319, 79, 27);
		add(limpar);
		
		JButton concluir = new JButton("Concluir");
		concluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Baba baba = new Baba(nome.getText(), telefone.getText());
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
					Sistema.getHotel().adicionaBaba(baba);
					Sistema.setTela(new OpcoesDeBaba());
				}  catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		concluir.setFont(new Font("NanumGothic", Font.PLAIN, 12));
		concluir.setBounds(509, 319, 91, 27);
		add(concluir);
	}
	
}