package gui;

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
	private final Action action = new SwingAction();
	private boolean acessoPermitido = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDeFuncionario JFrame = new LoginDeFuncionario();
					JFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the JFrame.
	 */
	public LoginDeFuncionario() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(251, 349, 278, 207);
		add(panel);
		panel.setLayout(null);
		JLabel login_1 = new JLabel("Login");
		login_1.setBounds(48, 71, 51, 16);
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
		
		JButton botao_entrar = new JButton("Entrar");
		botao_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botao_entrar.setBounds(95, 168, 86, 25);
		panel.add(botao_entrar);
		botao_entrar.setAction(action);
		botao_entrar.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LoginDeFuncionario.class.getResource("/nucleo/icones/Logo Hotel.png")));
		lblNewLabel.setBounds(77, 0, 528, 410);
		add(lblNewLabel);

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Entrar");
			putValue(SHORT_DESCRIPTION, "Login de funcionario");
		}
		
		public void actionPerformed(ActionEvent e) {
			if (login.getText().equals("admin") && senha.getText().equals("123456")){
				//JOptionPane.showMessageDialog(null, "Acesso Permitido");
				acessoPermitido = true;
				Sistema.setTela(new PaginaInicialHotel());
			
		}
			else
				JOptionPane.showMessageDialog(null, "Acesso Negado");{
				login.setText("");
				senha.setText("");
				 }
		}
		
	}
}
