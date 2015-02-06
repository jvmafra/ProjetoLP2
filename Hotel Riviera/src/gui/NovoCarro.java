package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import classes.Carro.Carro;
import excecoes.PlacaInvalidaException;
import java.awt.event.ActionListener;

public class NovoCarro extends JFrame {
	private JTextField descricao;
	private JTextField placa;
	private JCheckBox luxo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoCarro frame = new NovoCarro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NovoCarro() {
		setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		setResizable(false);
		setTitle("Cadastrar novo carro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 333);
		getContentPane().setLayout(null);
		
		JLabel lblDescircao = new JLabel("Descricao: ");
		lblDescircao.setBounds(133, 92, 95, 15);
		lblDescircao.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		getContentPane().add(lblDescircao);
		
		descricao = new JTextField();
		descricao.setBounds(213, 90, 163, 19);
		getContentPane().add(descricao);
		descricao.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Placa:");
		lblNewLabel.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblNewLabel.setBounds(133, 132, 70, 15);
		getContentPane().add(lblNewLabel);
		
		placa = new JTextField();
		placa.setBounds(213, 130, 114, 19);
		getContentPane().add(placa);
		placa.setColumns(10);
		
		luxo = new JCheckBox("Luxo");
		luxo.setFont(new Font("NanumGothic", Font.BOLD, 14));
		luxo.setBounds(338, 128, 129, 23);
		getContentPane().add(luxo);
		
		JButton voltar = new JButton("Voltar");
		voltar.setFont(new Font("NanumGothic", Font.BOLD, 14));
		voltar.setBounds(53, 252, 117, 25);
		getContentPane().add(voltar);
		
		JButton limpar = new JButton("Limpar");
		limpar.setFont(new Font("NanumGothic", Font.BOLD, 14));
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				luxo.setSelected(false);
				placa.setText("");
				descricao.setText("");
			}
		});
		limpar.setBounds(201, 252, 117, 25);
		getContentPane().add(limpar);
		
		JButton concluir = new JButton("Concluir");
		concluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Carro carro = new Carro(descricao.getText(), placa.getText(), luxo.isSelected());
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
					Sistema.getHotel().adicionaCarro(carro);
				}  catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		concluir.setFont(new Font("NanumGothic", Font.BOLD, 14));
		concluir.setBounds(353, 252, 117, 25);
		getContentPane().add(concluir);
	}
	
}

