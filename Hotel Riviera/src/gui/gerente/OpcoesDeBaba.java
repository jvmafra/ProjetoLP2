package gui.gerente;

import gui.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import nucleo.classes.hotel.Alugavel;
import nucleo.classes.servicos.Baba;

public class OpcoesDeBaba extends JPanel {
	private JTextField textField;
	private JList<Alugavel> list = new JList<Alugavel>();
	private DefaultListModel<Alugavel> listModel = new DefaultListModel<Alugavel>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public OpcoesDeBaba() {
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0,0,800,600);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(121, 257, 246, 244);
		add(scrollPane);
		list.setFont(new Font("Tahoma", Font.PLAIN, 13));
		list.setForeground(new Color(51, 102, 153));
		
		scrollPane.setViewportView(list);
		list.setModel(listModel);
		textField = new JTextField();
		textField.setBounds(121, 215, 216, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Digite o nome da Baba:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(121, 189, 170, 25);
		add(lblNewLabel);
		
		for (Alugavel baba: Sistema.getHotel().getBabas()) {
			listModel.addElement(baba);
		}
		setLayout(null);
		
		
		
		JButton btnEditaBab = new JButton("Editar");
		btnEditaBab.setForeground(new Color(51, 102, 153));
		btnEditaBab.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnEditaBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() == null)
					JOptionPane.showMessageDialog(null,	"Selecione uma Babá antes");
				else{
					Sistema.setTela(new EditaBaba((Baba) list.getSelectedValue()));
				}
			}
		});
		btnEditaBab.setBounds(443, 419, 101, 25);
		add(btnEditaBab);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new OpcoesPrivadas());
			}
		});
		btnVoltar.setBounds(347, 548, 88, 25);
		add(btnVoltar);
		
		JButton btnNewButton = new JButton("Nova");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovaBaba());
			}
		});
		btnNewButton.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnNewButton.setForeground(new Color(51, 102, 153));
		btnNewButton.setBounds(443, 310, 101, 27);
		add(btnNewButton);
		
		JLabel lblLabel = new JLabel("OPCOES DE BABA");
		lblLabel.setFont(new Font("Bitstream Charter", Font.BOLD, 26));
		lblLabel.setForeground(new Color(255, 255, 255));
		lblLabel.setBounds(289, 134, 278, 40);
		add(lblLabel);
		
		JLabel label = new JLabel(new ImageIcon(OpcoesDeBaba.class.getResource("/nucleo/icones/hotel4.png")));
		label.setBounds(325, 24, 151, 98);
		add(label);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() == null)
					JOptionPane.showMessageDialog(null,	"Selecione uma Babá antes");
				else{
					Sistema.getHotel().removeBaba((Baba) list.getSelectedValue());
					Sistema.setTela(new OpcoesDeBaba());
				}
			}
		});
		btnRemover.setForeground(new Color(51, 102, 153));
		btnRemover.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnRemover.setBounds(443, 363, 101, 27);
		add(btnRemover);
		

	}
}