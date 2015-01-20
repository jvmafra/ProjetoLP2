package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastroHospede extends JInternalFrame {
	private JTextField nome1;
	private JTextField cpf1;
	private JTextField rg1;
	private JTextField telefone1;
	private JTextField email1;
	private JTextField endereco1;

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
		setFrameIcon(new ImageIcon("D:\\Imagens\\\u00CDcones Projeto LP2\\png\\hotel22.png"));
		setTitle("Novo h\u00F3spede");
		setBounds(100, 100, 495, 383);
		
		JLabel nome = new JLabel("Nome");
		nome.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JLabel cpf = new JLabel("CPF");
		cpf.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JLabel rg = new JLabel("RG");
		rg.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JLabel email = new JLabel("E-mail");
		email.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JLabel telefone = new JLabel("Telefone");
		telefone.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JLabel endereco = new JLabel("Endere\u00E7o");
		endereco.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		nome1 = new JTextField();
		nome1.setColumns(10);
		
		cpf1 = new JTextField();
		cpf1.setColumns(10);
		
		rg1 = new JTextField();
		rg1.setColumns(10);
		
		telefone1 = new JTextField();
		telefone1.setColumns(10);
		
		email1 = new JTextField();
		email1.setColumns(10);
		
		endereco1 = new JTextField();
		endereco1.setColumns(10);
		
		JButton concluir = new JButton("Concluir");
		concluir.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(telefone)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(telefone1, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(endereco)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(endereco1, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(nome)
										.addComponent(cpf)
										.addComponent(rg)
										.addComponent(email))
									.addGap(28)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(email1, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(rg1, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
											.addComponent(cpf1, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
											.addComponent(nome1, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)))))
							.addGap(52))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(concluir)
							.addGap(41))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nome)
						.addComponent(nome1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cpf)
						.addComponent(cpf1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rg)
						.addComponent(rg1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(email)
						.addComponent(email1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(telefone)
						.addComponent(telefone1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(endereco)
						.addComponent(endereco1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(concluir)
					.addGap(22))
		);
		getContentPane().setLayout(groupLayout);

	}

}
