package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.Carro.Carro;

public class NovoCarro extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		setBounds(100, 100, 528, 333);
		
		JLabel lblDescircao = new JLabel("Descricao: ");
		lblDescircao.setBounds(133, 92, 95, 15);
		lblDescircao.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		add(lblDescircao);
		
		descricao = new JTextField();
		descricao.setBounds(213, 90, 163, 19);
		add(descricao);
		descricao.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Placa:");
		lblNewLabel.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblNewLabel.setBounds(133, 132, 70, 15);
		add(lblNewLabel);
		
		placa = new JTextField();
		placa.setBounds(213, 130, 114, 19);
		add(placa);
		placa.setColumns(10);
		
		luxo = new JCheckBox("Luxo");
		luxo.setFont(new Font("NanumGothic", Font.BOLD, 14));
		luxo.setBounds(338, 128, 129, 23);
		add(luxo);
		
		JButton voltar = new JButton("Voltar");
		voltar.setFont(new Font("NanumGothic", Font.BOLD, 14));
		voltar.setBounds(53, 252, 117, 25);
		add(voltar);
		
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
		add(limpar);
		
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
		add(concluir);
	}
	
}

