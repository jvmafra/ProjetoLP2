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
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

public class EditaFuncionario extends JPanel {
	private Funcionario funcionario;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNome;
	private JTextField textLogin;
	private JPasswordField textSenha;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JPasswordField confirmaSenha;

	/**
	 * Create the panel.
	 */
	public EditaFuncionario(Funcionario f) {
		this.funcionario = f;
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0, 0, 800, 600);
		textNome = new JTextField();
		textNome.setBounds(416, 178, 344, 30);
		
		add(textNome);
		textNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(320, 178, 78, 22);
		add(lblNome);

		JLabel label = new JLabel(new ImageIcon(
				OpcoesDeEstrategia.class
						.getResource("/nucleo/icones/hotel4 feito.png")));
		label.setBounds(300, 12, 221, 120);
		add(label);

		textLogin = new JTextField();
		textLogin.setColumns(10);
		textLogin.setBounds(416, 228, 130, 30);
		add(textLogin);

		textSenha = new JPasswordField();
		textSenha.setColumns(10);
		textSenha.setBounds(416, 278, 130, 30);
		add(textSenha);

		lblLogin = new JLabel("Login:");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(320, 228, 78, 22);
		add(lblLogin);

		lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(320, 278, 78, 22);
		add(lblSenha);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(51, 102, 153));
		btnSalvar.setBounds(464, 418, 89, 23);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (confirmaSenha.getText().equals(textSenha.getText())) {
					try {
						funcionario.setNome(textNome.getText());
						funcionario.setLogin(textLogin.getText());
						funcionario.setSenha(textSenha.getText());
						JOptionPane
								.showMessageDialog(null, "Salvo com sucesso");
						Sistema.setTela(new OpcoesFuncionario());
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				} else {
					JOptionPane.showMessageDialog(null,"As senhas n�o conferem\n"
							+ "Os dados foram restaurados");
					preencheCampos();
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

		confirmaSenha = new JPasswordField();
		confirmaSenha.setText((String) null);
		confirmaSenha.setColumns(10);
		confirmaSenha.setBounds(416, 328, 130, 30);
		add(confirmaSenha);

		JLabel lblConfirmeASenha = new JLabel("Confirme a senha:");
		lblConfirmeASenha.setForeground(Color.WHITE);
		lblConfirmeASenha.setBounds(300, 328, 98, 22);
		add(lblConfirmeASenha);
		preencheCampos();

	}
	
	private void preencheCampos(){
		textNome.setText(funcionario.getNome());
		textLogin.setText(funcionario.getLogin());
		confirmaSenha.setText(funcionario.getSenha());
		textSenha.setText(funcionario.getSenha());
		
	}
}
