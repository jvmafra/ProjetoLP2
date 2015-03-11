package gui.gerente;

import gui.Sistema;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nucleo.classes.formas_cobranca.Estrategia;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NovaEstrategia extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nome;
	private JTextField fator;

	/**
	 * Create the frame.
	 */
	public NovaEstrategia() {
		setBackground(new Color(51, 102, 153));
		setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		JLabel lblDescircao = new JLabel("Nome: ");
		lblDescircao.setForeground(new Color(255, 255, 255));
		lblDescircao.setBounds(276, 266, 71, 19);
		lblDescircao.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		add(lblDescircao);
		
		nome = new JTextField();
		nome.setBounds(336, 266, 150, 30);
		add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Fator: ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblNewLabel.setBounds(286, 324, 71, 19);
		add(lblNewLabel);
		
		fator = new JTextField();
		fator.setBounds(336, 316, 150, 30);
		add(fator);
		fator.setColumns(10);
		
		
		JButton voltar = new JButton("Voltar");
		voltar.setForeground(new Color(51, 102, 153));
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeEstrategia());
			}
		});
		voltar.setFont(new Font("NanumGothic", Font.PLAIN, 12));
		voltar.setBounds(184, 460, 90, 30);
		add(voltar);
		
		JButton limpar = new JButton("Limpar");
		limpar.setForeground(new Color(51, 102, 153));
		limpar.setFont(new Font("NanumGothic", Font.PLAIN, 12));
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome.setText("");
				fator.setText("");
			}
		});
		limpar.setBounds(344, 460, 90, 30);
		add(limpar);
		
		JButton concluir = new JButton("Concluir");
		concluir.setForeground(new Color(51, 102, 153));
		concluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Estrategia e = new Estrategia(nome.getText(), Double.parseDouble(fator.getText()));
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
					Sistema.getHotel().adicionaEstrategia(e);
					Sistema.setTela(new OpcoesDeEstrategia());
				}  catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		concluir.setFont(new Font("NanumGothic", Font.PLAIN, 12));
		concluir.setBounds(508, 460, 90, 30);
		add(concluir);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(NovaBaba.class.getResource("/nucleo/icones/hotel4 feito.png")));
		lblNewLabel_1.setBounds(327, 40, 160, 105);
		add(lblNewLabel_1);
	}

}