package gui.gerente;

import gui.Sistema;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import nucleo.classes.pessoa.Funcionario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class NovoFuncionario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField login;
	private JPasswordField senha;
	private JCheckBox permissaoGerente;
	private JTextField nome;
	private JPasswordField confirmaSenha;

	public NovoFuncionario() {
		setBackground(new Color(51, 102, 153));
		setBounds(0,0,800,600);
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setBackground(new Color(255, 255, 255));
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogin.setBounds(251, 277, 46, 26);
		add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(243, 327, 65, 26);
		add(lblSenha);
		
		login = new JTextField();
		login.setBounds(318, 277, 111, 30);
		add(login);
		login.setColumns(10);
		
		senha = new JPasswordField();
		senha.setBounds(318, 327, 111, 30);
		add(senha);
		
		permissaoGerente = new JCheckBox("Permissao de Gerente");
		permissaoGerente.setForeground(new Color(255, 255, 255));
		permissaoGerente.setBackground(new Color(51, 102, 153));
		permissaoGerente.setFont(new Font("Dialog", Font.PLAIN, 13));
		permissaoGerente.setBounds(504, 324, 190, 23);
		add(permissaoGerente);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesFuncionario());
			}
		});
		btnVoltar.setBounds(205, 459, 90, 30);
		add(btnVoltar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setForeground(new Color(51, 102, 153));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login.setText("");
				senha.setText("");
				permissaoGerente.setSelected(false);
			}
		});
		btnLimpar.setBounds(354, 459, 90, 30);
		add(btnLimpar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setForeground(new Color(51, 102, 153));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (String.valueOf(confirmaSenha.getPassword()).equals(String.valueOf(senha.getPassword()))){
				try {
					Funcionario funcionario = new Funcionario(nome.getText(), login.getText(), String.valueOf(senha.getPassword()), permissaoGerente.isSelected());
					Sistema.getHotel().adicionaFuncionario(funcionario);
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
					Sistema.setTela(new OpcoesFuncionario());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			} else{
				JOptionPane.showMessageDialog(null,"As senhas não conferem");
				login.setText("");
				senha.setText("");
				confirmaSenha.setText("");
				permissaoGerente.setSelected(false);
			}
				}
		});
		btnCadastrar.setBounds(496, 459, 97, 30);
		add(btnCadastrar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(NovoFuncionario.class.getResource("/nucleo/icones/hotel4.png")));
		label.setBounds(317, 12, 161, 105);
		add(label);
		
		JLabel lblNewLabel = new JLabel("NOVO FUNCIONÁRIO");
		lblNewLabel.setFont(new Font("Bitstream Charter", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(270, 131, 278, 40);
		add(lblNewLabel);
		
		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(318, 227, 343, 30);
		add(nome);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNome.setBackground(Color.WHITE);
		lblNome.setBounds(251, 227, 46, 26);
		add(lblNome);
		
		confirmaSenha = new JPasswordField();
		confirmaSenha.setBounds(318, 377, 111, 30);
		add(confirmaSenha);
		
		JLabel lblConfirmeASenha = new JLabel("Confirme a Senha:");
		lblConfirmeASenha.setForeground(Color.WHITE);
		lblConfirmeASenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmeASenha.setBounds(169, 377, 128, 26);
		add(lblConfirmeASenha);
	}
}
