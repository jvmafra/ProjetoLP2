package gui.opcoesdogerente;

import gui.Sistema;

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
		setLayout(null);
		
		JLabel lblDescircao = new JLabel("Descricao: ");
		lblDescircao.setBounds(83, 65, 71, 19);
		lblDescircao.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		add(lblDescircao);
		
		descricao = new JTextField();
		descricao.setBounds(159, 64, 86, 20);
		add(descricao);
		descricao.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Placa:");
		lblNewLabel.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblNewLabel.setBounds(114, 105, 39, 19);
		add(lblNewLabel);
		
		placa = new JTextField();
		placa.setBounds(158, 104, 86, 20);
		add(placa);
		placa.setColumns(10);
		
		luxo = new JCheckBox("Luxo");
		luxo.setFont(new Font("NanumGothic", Font.BOLD, 14));
		luxo.setBounds(271, 84, 59, 27);
		add(luxo);
		
		JButton voltar = new JButton("Voltar");
		voltar.setFont(new Font("NanumGothic", Font.BOLD, 14));
		voltar.setBounds(45, 169, 73, 27);
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
		limpar.setBounds(166, 169, 79, 27);
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
		concluir.setBounds(292, 169, 91, 27);
		add(concluir);
	}
	
}

