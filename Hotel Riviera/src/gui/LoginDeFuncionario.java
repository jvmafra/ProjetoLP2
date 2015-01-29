package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.Box;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPasswordField;

public class LoginDeFuncionario extends JFrame {
	private JTextField login;
	private JPasswordField senha;
	private final Action action = new SwingAction();

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
		setTitle("Login - Funcion\u00E1rio");
		setBounds(100, 100, 494, 383);
		
		JLabel login_1 = new JLabel("Login");
		login_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		
		login = new JTextField();
		login.setColumns(10);
		
		JLabel senha_1 = new JLabel("Senha");
		senha_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		
		senha = new JPasswordField();
		senha.setColumns(10);
		
		JButton botao_entrar = new JButton("Entrar");
		botao_entrar.setAction(action);
		
		botao_entrar.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(botao_entrar))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(146)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(senha_1)
									.addComponent(senha, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)))
							.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap(145, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(login_1)
									.addComponent(login, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)))))
					.addGap(117))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(141)
					.addComponent(login_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(login, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(senha_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(botao_entrar)
					.addContainerGap(70, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Entrar");
			putValue(SHORT_DESCRIPTION, "Login de funcionario");
		}
		public void actionPerformed(ActionEvent e) {
			if (login.getText().equals("admin") && senha.getText().equals("123456"))
				 JOptionPane.showMessageDialog(null, "Acesso Permitido");
			else
				 JOptionPane.showMessageDialog(null, "Acesso Negado");
			
		}
	}
}

