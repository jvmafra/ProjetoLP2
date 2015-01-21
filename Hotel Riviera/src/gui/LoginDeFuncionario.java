package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
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
import javax.swing.JTextPane;

public class LoginDeFuncionario extends JInternalFrame {
	private JTextField login;
	private JTextField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDeFuncionario frame = new LoginDeFuncionario();
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
	public LoginDeFuncionario() {
		setFrameIcon(new ImageIcon("D:\\Imagens\\\u00CDcones Projeto LP2\\png\\hotel22.png"));
		setTitle("Login - Funcion\u00E1rio");
		setBounds(100, 100, 494, 383);
		
		JLabel login_1 = new JLabel("Login");
		login_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		
		login = new JTextField();
		login.setColumns(10);
		
		JLabel senha_1 = new JLabel("Senha");
		senha_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		
		senha = new JTextField();
		senha.setColumns(10);
		
		JButton botao_entrar = new JButton("Entrar");
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
					.addContainerGap(68, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
