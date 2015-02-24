package gui.gerente;

import gui.Sistema;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import nucleo.classes.pessoa.Funcionario;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;

public class EditaFuncionario extends JPanel {
	private Funcionario funcionario;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNome;
	private JTextField textLogin;
	private JTextField textSenha;
	private JLabel lblLogin;
	private JLabel lblSenha;

	/**
	 * Create the panel.
	 */
	public EditaFuncionario(Funcionario f) {
		this.funcionario = f;
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		textNome = new JTextField();
		textNome.setBounds(412, 241, 128, 22);
		textNome.setText(funcionario.getNome());
		add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(316, 241, 78, 22);
		add(lblNome);
		
		JLabel label = new JLabel(new ImageIcon(OpcoesDeEstrategia.class.getResource("/nucleo/icones/hotel4.png")));
		label.setBounds(300, 12, 221, 120);
		add(label);
		
		textLogin = new JTextField();
		textLogin.setColumns(10);
		textLogin.setBounds(412, 291, 128, 22);
		textLogin.setText(funcionario.getLogin());
		add(textLogin);
		
		textSenha = new JTextField();
		textSenha.setColumns(10);
		textSenha.setBounds(412, 341, 128, 22);
		textSenha.setText(funcionario.getSenha());
		add(textSenha);
		
		lblLogin = new JLabel("Login:");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(316, 291, 78, 22);
		add(lblLogin);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(316, 341, 78, 22);
		add(lblSenha);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(51, 102, 153));
		btnSalvar.setBounds(464, 418, 89, 23);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					funcionario.setNome(textNome.getText());
					funcionario.setLogin(textLogin.getText());
					funcionario.setSenha(textSenha.getText());
					JOptionPane.showMessageDialog(null, "Salvo com sucesso");
					Sistema.setTela(new OpcoesFuncionario());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		add(btnSalvar);

		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesFuncionario());
			}
		});
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnVoltar.setBounds(344, 418, 89, 23);
		add(btnVoltar);

	}
}
