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
		setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 206, 209), new Color(95, 158, 160), null, null), new MatteBorder(10, 10, 10, 10, (Color) new Color(176, 196, 222))));
										setLayout(null);
										
										JLabel login_1 = new JLabel("Login");
										login_1.setBounds(81, 71, 29, 16);
										add(login_1);
										login_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
										
										login = new JTextField();
										login.setBounds(130, 69, 86, 20);
										add(login);
										login.setColumns(10);
										
										JLabel senha_1 = new JLabel("Senha");
										senha_1.setBounds(76, 102, 34, 16);
										add(senha_1);
										senha_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
										
										senha = new JPasswordField();
										senha.setBounds(130, 100, 86, 20);
										add(senha);
										senha.setColumns(10);
												
														JButton botao_entrar = new JButton("Entrar");
														botao_entrar.setBounds(89, 141, 86, 25);
														botao_entrar.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																							
																if(acessoPermitido){
																	
																	
															}
															}
														});
														add(botao_entrar);
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
