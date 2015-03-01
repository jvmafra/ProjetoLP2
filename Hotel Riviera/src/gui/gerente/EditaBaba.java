package gui.gerente;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import nucleo.classes.servicos.Baba;
import nucleo.excecoes.NomeInvalidoException;
import nucleo.excecoes.TelefoneInvalidoException;
import gui.Sistema;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.ImageIcon;

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
		setBounds(0,0,800,600);
		setBackground(new Color(51, 102, 153));
		this.baba = b;
		
		setLayout(null);
		
		nome = new JTextField();
		nome.setBounds(366, 256, 175, 30);
		nome.setText(b.getNome());
		add(nome);
		nome.setColumns(10);
		
		JLabel nome_1 = new JLabel("Nome:");
		nome_1.setForeground(new Color(255, 255, 255));
		nome_1.setBounds(295, 261, 70, 15);
		nome_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(nome_1);

		JLabel telefone_1 = new JLabel("Telefone:");
		telefone_1.setForeground(new Color(255, 255, 255));
		telefone_1.setBounds(284, 314, 70, 15);
		telefone_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(telefone_1);
		
		telefone = new JTextField();
		telefone.setBounds(366, 309, 175, 30);
		telefone.setText(b.getTelefone());
		add(telefone);
		telefone.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(51, 102, 153));
		btnSalvar.setBounds(521, 409, 90, 30);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					baba.setNome(nome.getText());
				} catch (NomeInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					baba.setTelefone(telefone.getText());
					JOptionPane.showMessageDialog(null,"Salvo com sucesso");
					Sistema.setTela(new OpcoesDeBaba());
				} catch (TelefoneInvalidoException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});
		add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setBounds(215, 409, 90, 30);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeBaba());
			}
		});
		add(btnVoltar);
		
		JButton btnRemovarBab = new JButton("Remover Baba");
		btnRemovarBab.setForeground(new Color(51, 102, 153));
		btnRemovarBab.setBounds(340, 408, 150, 30);
		btnRemovarBab.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemovarBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.getHotel().removeBaba(baba);
				Sistema.setTela(new OpcoesDeBaba());
			}
		});
		add(btnRemovarBab);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EditaBaba.class.getResource("/nucleo/icones/hotel4.png")));
		label.setBounds(340, 56, 185, 100);
		add(label);

	}
}