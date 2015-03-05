package gui.contratos;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

import nucleo.classes.pessoa.Contrato;
import javax.swing.JTextField;
import java.awt.Font;

public class FaturaFinal extends JPanel {
	
	Contrato contrato;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	public FaturaFinal(Contrato contrato) {
		this.contrato = contrato;
		
		setBackground(new Color(51, 102, 153));
		setForeground(new Color(0, 0, 0));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FaturaFinal.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(323, 0, 186, 126);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(34, 150, 732, 426);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblN = new JLabel("Nome");
		lblN.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblN.setBounds(12, 12, 70, 15);
		panel.add(lblN);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(455, 28, 252, 23);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblLogradouro.setBounds(455, 12, 95, 15);
		panel.add(lblLogradouro);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(268, 28, 165, 23);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblRg.setBounds(267, 12, 70, 15);
		panel.add(lblRg);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(12, 28, 236, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(12, 82, 236, 23);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblTelefone.setBounds(12, 66, 70, 15);
		panel.add(lblTelefone);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(268, 82, 217, 23);
		panel.add(textField_4);
		
		JLabel lblCartoDeCrdito = new JLabel("Cartão de crédito");
		lblCartoDeCrdito.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblCartoDeCrdito.setBounds(268, 66, 122, 15);
		panel.add(lblCartoDeCrdito);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(503, 82, 217, 23);
		panel.add(textField_5);
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblPeriodo.setBounds(503, 66, 70, 15);
		panel.add(lblPeriodo);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(153, 178, 122, 23);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(153, 224, 122, 23);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(153, 268, 122, 23);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(153, 314, 122, 23);
		panel.add(textField_9);

	}
}
