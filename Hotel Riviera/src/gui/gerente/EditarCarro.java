package gui.gerente;

import gui.Sistema;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nucleo.classes.servicos.*;
import java.awt.Color;

public class EditarCarro extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Carro carro;
	private JTextField descricao, placa;
	JCheckBox luxo;

	/**
	 * Create the panel.
	 */
	public EditarCarro(Carro c) {
		setBackground(Color.WHITE);
		this.carro = c;

		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		descricao = new JTextField();
		descricao.setBounds(233, 62, 177, 28);
		descricao.setText(carro.getDescricao());
		add(descricao);
		descricao.setColumns(10);
		
		JLabel descricao_1 = new JLabel("descricao:");
		descricao_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		descricao_1.setBounds(145, 68, 70, 15);
		add(descricao_1);

		JLabel placa_1 = new JLabel("placa:");
		placa_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		placa_1.setBounds(145, 134, 70, 15);
		add(placa_1);
		
		placa = new JTextField();
		placa.setBounds(233, 128, 177, 28);
		placa.setText(carro.getPlaca());
		add(placa);
		placa.setColumns(10);
		
		luxo = new JCheckBox("Luxo");
		luxo.setBackground(Color.WHITE);
		luxo.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		luxo.setBounds(235, 176, 59, 27);
		luxo.setSelected(carro.isLuxo());
		add(luxo);
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					carro.setDescricao(descricao.getText());
					carro.setPlaca(placa.getText());
					carro.setLuxo(luxo.isSelected());
					JOptionPane.showMessageDialog(null, "Carro editado com sucesso");
					Sistema.setTela(new ConsultaCarro());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Parametros de edicao invalidos");
				}
			}
		});
		btnSalvar.setBounds(393, 231, 89, 23);
		add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new ConsultaCarro());
			}
		});
		btnVoltar.setBounds(92, 231, 89, 23);
		add(btnVoltar);
		
		JButton btnRemoveCarro = new JButton("Remove Carro");
		btnRemoveCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.getHotel().removeCarro(carro);
				Sistema.setTela(new ConsultaCarro());
			}
		});
		btnRemoveCarro.setBounds(224, 230, 138, 25);
		add(btnRemoveCarro);
	}

}