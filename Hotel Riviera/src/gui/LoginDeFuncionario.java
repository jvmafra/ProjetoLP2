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
import javax.swing.border.TitledBorder;

public class LoginDeFuncionario extends JFrame {
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
		setTitle("Login - Funcion\u00E1rio");
		setBounds(100, 100, 835, 590);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(206, 107, 470, 331);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Login Funcionario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(63, 71, 301, 172);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton botao_entrar = new JButton("Entrar");
		botao_entrar.addActionListener(new ActionListener() {
			// galera isso foi uma das coisas que nathaniel fez. Serve para mudar de frame.
			public void actionPerformed(ActionEvent e) {
				PaginaInicialHotel frame = new PaginaInicialHotel();
				
				if(acessoPermitido){
					frame.setVisible(true);
					setVisible(false);
			}
			}
		});
		botao_entrar.setBounds(104, 133, 75, 27);
		panel_1.add(botao_entrar);
		botao_entrar.setAction(action);
		
		botao_entrar.setFont(new Font("Tw Cen MT", Font.PLAIN, 14)); 
		
		JLabel senha_1 = new JLabel("Senha");
		senha_1.setBounds(42, 85, 44, 17);
		panel_1.add(senha_1);
		senha_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		
		senha = new JPasswordField();
		senha.setBounds(104, 78, 114, 19);
		panel_1.add(senha);
		senha.setColumns(10);
		
		JLabel login_1 = new JLabel("Login");
		login_1.setBounds(54, 37, 37, 17);
		panel_1.add(login_1);
		login_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		
		login = new JTextField();
		login.setBounds(104, 35, 114, 19);
		panel_1.add(login);
		login.setColumns(10);

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Entrar");
			putValue(SHORT_DESCRIPTION, "Login de funcionario");
		}
		public void actionPerformed(ActionEvent e) {
			if (login.getText().equals("admin") && senha.getText().equals("123456")){
				JOptionPane.showMessageDialog(null, "Acesso Permitido");
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
