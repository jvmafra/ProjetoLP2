package gui;

import gui.gerente.OpcoesPrivadas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

import java.awt.Color;

import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

public class LoginDeFuncionario extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField login;
	private JPasswordField senha;
	private boolean analisaGerente;

	
	public LoginDeFuncionario(boolean analisaGerente) {
		this.analisaGerente = analisaGerente;
		setBackground(Color.WHITE);
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(243, 307, 278, 207);
		add(panel);
		panel.setLayout(null);
		JLabel login_1 = new JLabel("Login");
		login_1.setBounds(43, 72, 51, 16);
		panel.add(login_1);
		login_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		
		JLabel senha_1 = new JLabel("Senha");
		senha_1.setBounds(43, 113, 44, 16);
		panel.add(senha_1);
		senha_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		
		senha = new JPasswordField();
		senha.setBounds(95, 112, 98, 20);
		panel.add(senha);
		senha.setColumns(10);
		
		login = new JTextField();
		login.setBounds(95, 70, 98, 20);
		panel.add(login);
		login.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Sistema.getHotel().verificaLogin(login.getText(), senha.getText(), isAnalisaGerente()))
					if (isAnalisaGerente())
						Sistema.setTela(new OpcoesPrivadas());
					else
						Sistema.setTela(new PaginaInicialHotel());
				else
					JOptionPane.showMessageDialog(null, "Acesso Negado");{
					login.setText("");
					senha.setText("");
					 }
			}
		});
		btnEntrar.setBounds(95, 154, 86, 25);
		panel.add(btnEntrar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LoginDeFuncionario.class.getResource("/nucleo/icones/Logo Hotel.png")));
		lblNewLabel.setBounds(72, 11, 528, 362);
		add(lblNewLabel);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(338, 515, 86, 25);
		if (isAnalisaGerente())
			add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new PaginaInicialHotel());
			}
		});
		btnVoltar.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		

	}

	
	private boolean isAnalisaGerente(){
		return analisaGerente;
	}
}
