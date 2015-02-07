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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{125, 34, 36, 86, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{103, 20, 20, 25, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
										
										JLabel login_1 = new JLabel("Login");
										GridBagConstraints gbc_login_1 = new GridBagConstraints();
										gbc_login_1.anchor = GridBagConstraints.EAST;
										gbc_login_1.insets = new Insets(0, 0, 5, 5);
										gbc_login_1.gridx = 5;
										gbc_login_1.gridy = 2;
										add(login_1, gbc_login_1);
										login_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
										
										login = new JTextField();
										GridBagConstraints gbc_login = new GridBagConstraints();
										gbc_login.anchor = GridBagConstraints.NORTHWEST;
										gbc_login.insets = new Insets(0, 0, 5, 5);
										gbc_login.gridx = 7;
										gbc_login.gridy = 2;
										add(login, gbc_login);
										login.setColumns(10);
										
										JLabel senha_1 = new JLabel("Senha");
										GridBagConstraints gbc_senha_1 = new GridBagConstraints();
										gbc_senha_1.anchor = GridBagConstraints.WEST;
										gbc_senha_1.insets = new Insets(0, 0, 5, 5);
										gbc_senha_1.gridx = 5;
										gbc_senha_1.gridy = 4;
										add(senha_1, gbc_senha_1);
										senha_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
										
										senha = new JPasswordField();
										GridBagConstraints gbc_senha = new GridBagConstraints();
										gbc_senha.anchor = GridBagConstraints.NORTHWEST;
										gbc_senha.insets = new Insets(0, 0, 5, 5);
										gbc_senha.gridx = 7;
										gbc_senha.gridy = 4;
										add(senha, gbc_senha);
										senha.setColumns(10);
												
														JButton botao_entrar = new JButton("Entrar");
														botao_entrar.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																							
																if(acessoPermitido){
																	Sistema.setTela(new PaginaInicialHotel());
																	//frame.setVisible(true);
																	//setVisible(false);
															}
															}
														});
														GridBagConstraints gbc_botao_entrar = new GridBagConstraints();
														gbc_botao_entrar.insets = new Insets(0, 0, 5, 0);
														gbc_botao_entrar.anchor = GridBagConstraints.NORTH;
														gbc_botao_entrar.gridwidth = 3;
														gbc_botao_entrar.gridx = 6;
														gbc_botao_entrar.gridy = 6;
														add(botao_entrar, gbc_botao_entrar);
														botao_entrar.setAction(action);
														
														botao_entrar.setFont(new Font("Tw Cen MT", Font.PLAIN, 14)); 

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
			
		}
			else
				 JOptionPane.showMessageDialog(null, "Acesso Negado");{
				login.setText("");
				senha.setText("");
				 }
		}
		
	}
}
