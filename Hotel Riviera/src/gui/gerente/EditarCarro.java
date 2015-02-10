package gui.gerente;

import gui.Sistema;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.Carro.Carro;

public class EditarCarro extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Carro carro;
	private JTextField descricao, placa, luxo;

	/**
	 * Create the panel.
	 */
	public EditarCarro(Carro c) {
		this.carro = c;

		setBounds(0, 0, 552, 376);
		setLayout(null);
		
		descricao = new JTextField();
		descricao.setBounds(233, 62, 177, 28);
		descricao.setText(carro.getDescricao());
		add(descricao);
		descricao.setColumns(10);
		
		JLabel descricao_1 = new JLabel("descricao:");
		descricao_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		descricao_1.setBounds(177, 68, 70, 15);
		add(descricao_1);

		JLabel placa_1 = new JLabel("placa:");
		placa_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		placa_1.setBounds(156, 134, 70, 15);
		add(placa_1);
		
		placa = new JTextField();
		placa.setBounds(233, 128, 177, 28);
		placa.setText(carro.getPlaca());
		add(placa);
		placa.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carro.setDescricao(descricao.getText());
				try {
					carro.setPlaca(placa.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(321, 231, 89, 23);
		add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesPrivadas());
			}
		});
		btnVoltar.setBounds(190, 231, 89, 23);
		add(btnVoltar);
	}

}
