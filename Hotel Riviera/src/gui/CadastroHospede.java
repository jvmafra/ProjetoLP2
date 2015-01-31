package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Toolkit;

import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import classes.Pessoa.Hospede;

import java.awt.event.ActionListener;

public class CadastroHospede extends JFrame {
	private JTextField nome;
	private JTextField cpf;
	private JTextField rg;
	private JTextField telefone;
	private JTextField email;
	private JTextField endereco;
	private final Action action = new SwingAction();
	private JTextField numCartao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroHospede frame = new CadastroHospede();
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
	public CadastroHospede() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroHospede.class.getResource("/icones/hotel22.png")));
		setTitle("Novo h\u00F3spede");
		setBounds(100, 100, 495, 383);
		
		JLabel nome_1 = new JLabel("Nome");
		nome_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JLabel cpf_1 = new JLabel("CPF");
		cpf_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JLabel rg_1 = new JLabel("RG");
		rg_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JLabel email_1 = new JLabel("E-mail");
		email_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JLabel telefone_1 = new JLabel("Telefone");
		telefone_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JLabel endereco_1 = new JLabel("Endere\u00E7o");
		endereco_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		nome = new JTextField();
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setColumns(10);
		
		rg = new JTextField();
		rg.setColumns(10);
		
		telefone = new JTextField();
		telefone.setColumns(10);
		
		email = new JTextField();
		email.setColumns(10);
		
		endereco = new JTextField();
		endereco.setColumns(10);
		
		JButton concluir = new JButton("Concluir");
		concluir.setAction(action);
		concluir.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JButton limpar = new JButton("Limpar");
		limpar.setFont(new Font("Dialog", Font.PLAIN, 15));
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nome.setText("");
				cpf.setText("");
				rg.setText("");
				telefone.setText("");
				email.setText("");
				endereco.setText("");
			}
		});
		
		JLabel lblCarto = new JLabel("Cart\u00E3o");
		lblCarto.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		numCartao = new JTextField();
		numCartao.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(152)
							.addComponent(limpar)
							.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
							.addComponent(concluir))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(telefone_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(telefone, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(nome_1)
										.addComponent(cpf_1)
										.addComponent(rg_1)
										.addComponent(email_1))
									.addGap(28)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(email, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(rg, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
											.addComponent(cpf, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
											.addComponent(nome, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(endereco_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(numCartao, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
										.addComponent(endereco, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))))))
					.addGap(52))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCarto)
					.addContainerGap(423, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nome_1)
						.addComponent(nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cpf_1)
						.addComponent(cpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rg_1)
						.addComponent(rg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(email_1)
						.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(telefone_1)
						.addComponent(telefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(endereco_1)
						.addComponent(endereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCarto)
						.addComponent(numCartao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(limpar)
						.addComponent(concluir))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Concluir");
			putValue(SHORT_DESCRIPTION, "Cadastro de hospede");
		}
		public void actionPerformed(ActionEvent e) {	
			try {
				Hospede hospede = new Hospede(nome.getText(), cpf.getText(), rg.getText(), email.getText(), telefone.getText(), endereco.getText(), numCartao.getText());
				JOptionPane.showMessageDialog(null, "Hospede criado!");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	}
}

