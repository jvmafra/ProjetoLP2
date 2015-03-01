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
import java.awt.Color;
import javax.swing.ImageIcon;


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
		setBackground(new Color(51, 102, 153));
		setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		JLabel lblDescircao = new JLabel("Nome: ");
		lblDescircao.setForeground(new Color(255, 255, 255));
		lblDescircao.setBounds(177, 247, 71, 19);
		lblDescircao.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		add(lblDescircao);
		
		nome = new JTextField();
		nome.setBounds(237, 247, 339, 30);
		add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Telefone: ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblNewLabel.setBounds(164, 321, 76, 19);
		add(lblNewLabel);
		
		telefone = new JTextField();
		telefone.setBounds(240, 317, 150, 30);
		add(telefone);
		telefone.setColumns(10);
		
		
		JButton voltar = new JButton("Voltar");
		voltar.setForeground(new Color(51, 102, 153));
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeBaba());
			}
		});
		voltar.setFont(new Font("NanumGothic", Font.PLAIN, 12));
		voltar.setBounds(183, 439, 90, 30);
		add(voltar);
		
		JButton limpar = new JButton("Limpar");
		limpar.setForeground(new Color(51, 102, 153));
		limpar.setFont(new Font("NanumGothic", Font.PLAIN, 12));
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome.setText("");
				telefone.setText("");
			}
		});
		limpar.setBounds(343, 439, 90, 30);
		add(limpar);
		
		JButton concluir = new JButton("Concluir");
		concluir.setForeground(new Color(51, 102, 153));
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
		concluir.setBounds(507, 439, 90, 30);
		add(concluir);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(NovaBaba.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel_1.setBounds(327, 40, 160, 105);
		add(lblNewLabel_1);
	}
}