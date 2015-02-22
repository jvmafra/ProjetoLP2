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

public class NovoFuncionario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField login;
	private JPasswordField senha;
	private JCheckBox permissaoGerente;

	public NovoFuncionario() {
		setBounds(0,0,800,600);
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogin.setBounds(292, 196, 46, 26);
		add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(292, 246, 46, 14);
		add(lblSenha);
		
		login = new JTextField();
		login.setBounds(359, 201, 111, 20);
		add(login);
		login.setColumns(10);
		
		senha = new JPasswordField();
		senha.setBounds(359, 245, 111, 19);
		add(senha);
		
		permissaoGerente = new JCheckBox("Permissao de Gerente");
		permissaoGerente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		permissaoGerente.setBounds(323, 294, 147, 23);
		add(permissaoGerente);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesFuncionario());
			}
		});
		btnVoltar.setBounds(210, 391, 100, 23);
		add(btnVoltar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login.setText("");
				senha.setText("");
				permissaoGerente.setSelected(false);
			}
		});
		btnLimpar.setBounds(359, 391, 89, 23);
		add(btnLimpar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Funcionario funcionario = new Funcionario(login.getText(), senha.getText(), permissaoGerente.isSelected());
					Sistema.getHotel().adicionaFuncionario(funcionario);
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnCadastrar.setBounds(501, 391, 100, 23);
		add(btnCadastrar);
	}
}
