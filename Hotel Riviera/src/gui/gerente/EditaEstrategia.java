package gui.gerente;

import gui.Sistema;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nucleo.classes.formas_cobranca.Estrategia;

public class EditaEstrategia extends JPanel {
	private Estrategia estrategia;
	private JTextField nome;
	private JTextField fator;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public EditaEstrategia(Estrategia e) {
		setBounds(0, 0, 800, 600);
		setBackground(new Color(51, 102, 153));
		this.estrategia = e;
		
		setLayout(null);

		nome = new JTextField();
		nome.setBounds(331, 233, 175, 30);
		nome.setText(estrategia.getNome());
		add(nome);
		nome.setColumns(10);

		JLabel nome_1 = new JLabel("Nome:");
		nome_1.setForeground(new Color(255, 255, 255));
		nome_1.setBounds(260, 238, 70, 15);
		nome_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(nome_1);

		JLabel fator_1 = new JLabel("Fator:");
		fator_1.setForeground(new Color(255, 255, 255));
		fator_1.setBounds(260, 292, 53, 15);
		fator_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(fator_1);

		fator = new JTextField();
		fator.setBounds(331, 286, 175, 30);
		fator.setText(String.valueOf(estrategia.getFator()));
		add(fator);
		fator.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(51, 102, 153));
		btnSalvar.setBounds(454, 386, 90, 30);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					estrategia.setNome(nome.getText());
					estrategia.setFator(Double.parseDouble(fator.getText()));
					JOptionPane.showMessageDialog(null, "Salvo com sucesso");
					Sistema.setTela(new OpcoesDeEstrategia());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		add(btnSalvar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setBounds(260, 386, 90, 30);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeEstrategia());
			}
		});
		add(btnVoltar);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EditaEstrategia.class
				.getResource("/nucleo/icones/hotel4.png")));
		label.setBounds(321, 40, 138, 100);
		add(label);

	}

}