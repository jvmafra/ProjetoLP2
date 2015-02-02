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

public class NovoCarro extends JFrame {

	private JPanel contentPane;
	private JTextField placa;
	private final Action limpar_dados = new SwingAction();
	JCheckBox IsLuxo;
	private final Action cadastrar_veiculo = new SwingAction_1();

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPlacaDoVeculo = new JLabel("Placa do ve\u00EDculo");
		lblPlacaDoVeculo.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		placa = new JTextField();
		placa.setColumns(10);
		
		IsLuxo = new JCheckBox("Luxo");
		IsLuxo.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		
		JButton btnVoltar = new JButton("Voltar");
		
		JButton limpar = new JButton("Limpar");
		limpar.setAction(limpar_dados);
		
		JButton cadastrar = new JButton("Cadastar");
		cadastrar.setAction(cadastrar_veiculo);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(btnVoltar)
					.addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
					.addComponent(limpar)
					.addGap(75)
					.addComponent(cadastrar)
					.addGap(78))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(136)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(IsLuxo)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPlacaDoVeculo)
							.addGap(18)
							.addComponent(placa, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(154, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(112)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(placa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPlacaDoVeculo))
					.addGap(18)
					.addComponent(IsLuxo)
					.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltar)
						.addComponent(cadastrar)
						.addComponent(limpar))
					.addGap(20))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Limpar");
			putValue(SHORT_DESCRIPTION, "Limpar dados do cadastro");
		}
		public void actionPerformed(ActionEvent e) {
			IsLuxo.setSelected(false);
			placa.setText("");
			
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Cadastrar");
			putValue(SHORT_DESCRIPTION, "Cadastrar veiculo");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				Carro carro = new Carro(placa.getText(), IsLuxo.isSelected());
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			} catch (PlacaInvalidaException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	}
}
