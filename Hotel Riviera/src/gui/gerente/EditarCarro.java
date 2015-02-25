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
import javax.swing.ImageIcon;

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
		setBackground(new Color(51, 102, 153));
		this.carro = c;

		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		descricao = new JTextField();
		descricao.setBounds(332, 186, 177, 28);
		descricao.setText(carro.getDescricao());
		add(descricao);
		descricao.setColumns(10);
		
		JLabel descricao_1 = new JLabel("Descricao:");
		descricao_1.setForeground(new Color(255, 255, 255));
		descricao_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		descricao_1.setBounds(252, 191, 70, 15);
		add(descricao_1);

		JLabel placa_1 = new JLabel("Placa:");
		placa_1.setForeground(new Color(255, 255, 255));
		placa_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		placa_1.setBounds(278, 246, 70, 15);
		add(placa_1);
		
		placa = new JTextField();
		placa.setBounds(332, 241, 177, 28);
		placa.setText(carro.getPlaca());
		add(placa);
		placa.setColumns(10);
		
		luxo = new JCheckBox("Luxo");
		luxo.setForeground(new Color(255, 255, 255));
		luxo.setBackground(new Color(51, 102, 153));
		luxo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		luxo.setBounds(450, 286, 59, 27);
		luxo.setSelected(carro.isLuxo());
		add(luxo);
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(51, 102, 153));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					carro.setDescricao(descricao.getText());
					carro.setPlaca(placa.getText());
					carro.setLuxo(luxo.isSelected());
					JOptionPane.showMessageDialog(null, "Carro editado com sucesso");
					Sistema.setTela(new OpcoesDeCarro());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Parametros de edicao invalidos");
				}
			}
		});
		btnSalvar.setBounds(433, 374, 89, 23);
		add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeCarro());
			}
		});
		btnVoltar.setBounds(259, 374, 89, 23);
		add(btnVoltar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(EditarCarro.class.getResource("/nucleo/icones/hotel4.png")));
		label.setBounds(322, 30, 143, 97);
		add(label);
	}

}