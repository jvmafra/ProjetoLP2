package gui;

import gui.gerente.OpcoesPrivadas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginDeFuncionario extends JPanel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField login;
	private JPasswordField senha;
	private boolean analisaGerente;
	JButton btnEntrar;
	private JLabel areaReservada;

	
	public LoginDeFuncionario(boolean analisaGerente) {
		this.analisaGerente = analisaGerente;
		setBackground(Color.WHITE);
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(103, 0, 528, 387);
		lblNewLabel.setIcon(new ImageIcon(LoginDeFuncionario.class.getResource("/nucleo/icones/Logo Hotel.png")));
		add(lblNewLabel);
		JLabel login_1 = new JLabel("Login");
		login_1.setBounds(310, 358, 51, 16);
		add(login_1);
		login_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		
		
		JLabel senha_1 = new JLabel("Senha");
		senha_1.setBounds(310, 398, 44, 16);
		add(senha_1);
		senha_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
	                    btnEntrar.doClick(); 
	                    }
			}
		});
		btnEntrar.setBounds(363, 433, 90, 30);
		add(btnEntrar);
		btnEntrar.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Sistema.getHotel().verificaLogin(login.getText(), String.valueOf(senha.getPassword()), isAnalisaGerente()))
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
		
		senha = new JPasswordField();
		senha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
	                    btnEntrar.doClick(); 
	                    }
			}
		});
		senha.setBounds(363, 394, 100, 30);
		add(senha);
		senha.setColumns(10);
		
		login = new JTextField();
		login.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
	                    senha.grabFocus(); 
	                    }
			}
		});
		login.setBounds(363, 354, 100, 30);
		add(login);
		login.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(363, 483, 90, 30);
		if (isAnalisaGerente()){
			alteraTela(lblNewLabel, login_1, senha_1, btnEntrar, btnVoltar);
			
		}
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new PaginaInicialHotel());
			}
		});
		btnVoltar.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		

	}


	private void alteraTela(JLabel lblNewLabel, JLabel login_1, JLabel senha_1,
			JButton btnEntrar, JButton btnVoltar) {
		add(btnVoltar);
		setBackground(new Color(51, 102, 153));
		lblNewLabel.setIcon(new ImageIcon(LoginDeFuncionario.class.getResource("/nucleo/icones/hotel4 feito.png")));
		lblNewLabel.setBounds(331, 80, 184, 98);
		senha_1.setForeground(Color.WHITE);
		login_1.setForeground(Color.WHITE);
		btnEntrar.setForeground(new Color(51, 102, 153));
		btnVoltar.setForeground(new Color(51, 102, 153));
		areaReservada = new JLabel("AREA RESERVADA");
		areaReservada.setFont(new Font("Bitstream Charter", Font.BOLD, 26));
		areaReservada.setForeground(new Color(255, 255, 255));
		areaReservada.setBounds(296, 200, 262, 55);
		add(areaReservada);
	}

	
	private boolean isAnalisaGerente(){
		return analisaGerente;
	}
}
