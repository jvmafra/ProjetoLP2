package gui.gerente;

import gui.Sistema;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nucleo.classes.servicos.Carro;
import java.awt.Color;
import javax.swing.ImageIcon;

public class NovoCarro extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField descricao;
	private JTextField placa;
	private JCheckBox luxo;

	/**
	 * Create the frame.
	 */
	public NovoCarro() {
		setBackground(new Color(51, 102, 153));
		setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		JLabel lblDescircao = new JLabel("Descricao: ");
		lblDescircao.setForeground(new Color(255, 255, 255));
		lblDescircao.setBackground(new Color(255, 255, 255));
		lblDescircao.setBounds(264, 215, 71, 19);
		lblDescircao.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		add(lblDescircao);
		
		descricao = new JTextField();
		descricao.setBounds(353, 215, 175, 20);
		add(descricao);
		descricao.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Placa:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblNewLabel.setBounds(295, 246, 39, 19);
		add(lblNewLabel);
		
		placa = new JTextField();
		placa.setBounds(353, 246, 86, 19);
		add(placa);
		placa.setColumns(10);
		
		luxo = new JCheckBox("Luxo");
		luxo.setForeground(new Color(255, 255, 255));
		luxo.setBackground(new Color(51, 102, 153));
		luxo.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		luxo.setBounds(475, 242, 59, 27);
		add(luxo);
		
		JButton voltar = new JButton("Voltar");
		voltar.setForeground(new Color(51, 102, 153));
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeCarro());
			}
		});
		voltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		voltar.setBounds(231, 351, 73, 27);
		add(voltar);
		
		JButton limpar = new JButton("Limpar");
		limpar.setForeground(new Color(51, 102, 153));
		limpar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				luxo.setSelected(false);
				placa.setText("");
				descricao.setText("");
			}
		});
		limpar.setBounds(370, 351, 79, 27);
		add(limpar);
		
		JButton concluir = new JButton("Concluir");
		concluir.setForeground(new Color(51, 102, 153));
		concluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Carro carro = new Carro(descricao.getText(), placa.getText(), luxo.isSelected());
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
					Sistema.getHotel().adicionaCarro(carro);
					Sistema.setTela(new OpcoesDeCarro());
				}  catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		concluir.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		concluir.setBounds(512, 351, 91, 27);
		add(concluir);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(NovoCarro.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel_1.setBounds(341, 12, 166, 90);
		add(lblNewLabel_1);
	}
	
}
