package gui.gerente;

import gui.Sistema;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpcoesFuncionario extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OpcoesFuncionario() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		JButton btnNovoFuncionario = new JButton("NOVO FUNCIONARIO");
		btnNovoFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovoFuncionario());
			}
		});
		btnNovoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNovoFuncionario.setBounds(304, 183, 201, 56);
		add(btnNovoFuncionario);
		
		JButton btnEditaFuncionario = new JButton("EDITA FUNCIONARIO");
		btnEditaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEditaFuncionario.setBounds(304, 286, 201, 56);
		add(btnEditaFuncionario);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesPrivadas());
			}
		});
		btnVoltar.setBounds(365, 450, 89, 23);
		add(btnVoltar);
	}

}
