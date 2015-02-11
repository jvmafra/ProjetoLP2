package gui.gerente;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.Baba.Baba;

import javax.swing.JButton;

import excecoes.TelefoneInvalidoException;
import gui.Sistema;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditaBaba extends JPanel {
	private Baba baba;
	private JTextField nome;
	private JTextField telefone;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public EditaBaba(Baba b) {
		this.baba = b;
		
		setBounds(0, 0, 552, 376);
		setLayout(null);
		
		nome = new JTextField();
		nome.setBounds(233, 62, 177, 28);
		nome.setText(b.getNome());
		add(nome);
		nome.setColumns(10);
		
		JLabel nome_1 = new JLabel("Nome:");
		nome_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		nome_1.setBounds(177, 68, 70, 15);
		add(nome_1);

		JLabel telefone_1 = new JLabel("Telefone:");
		telefone_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		telefone_1.setBounds(156, 134, 70, 15);
		add(telefone_1);
		
		telefone = new JTextField();
		telefone.setBounds(233, 128, 177, 28);
		telefone.setText(b.getTelefone());
		add(telefone);
		telefone.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				baba.setNome(nome.getText());
				try {
					baba.setTelefone(telefone.getText());
				} catch (TelefoneInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(375, 231, 89, 23);
		add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new ConsultaBabas());
			}
		});
		btnVoltar.setBounds(72, 231, 89, 23);
		add(btnVoltar);
		
		JButton btnRemovarBab = new JButton("Remover Baba");
		btnRemovarBab.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnRemovarBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.getHotel().removeBaba(baba);
				Sistema.setTela(new ConsultaBabas());
			}
		});
		btnRemovarBab.setBounds(195, 230, 150, 25);
		add(btnRemovarBab);

	}
}
