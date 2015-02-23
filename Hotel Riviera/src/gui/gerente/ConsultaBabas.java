package gui.gerente;

import nucleo.excecoes.NomeInvalidoException;
import nucleo.excecoes.TelefoneInvalidoException;
import gui.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;

import nucleo.classes.servicos.Baba;
import nucleo.classes.hotel.*;
import nucleo.classes.pessoa.Contrato;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ConsultaBabas extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JList<Alugavel> list = new JList<Alugavel>();
	private DefaultListModel<Alugavel> listModel = new DefaultListModel<Alugavel>();

	/**
	 * Create the panel.
	 */
	public ConsultaBabas() {
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0,0,800,600);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(285, 220, 246, 244);
		add(scrollPane);
		list.setFont(new Font("Tahoma", Font.PLAIN, 13));
		list.setForeground(new Color(51, 102, 153));
		
		scrollPane.setViewportView(list);
		list.setModel(listModel);
		
		textField = new JTextField();
		textField.setBounds(285, 178, 216, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Digite o nome da Baba:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(285, 152, 170, 25);
		add(lblNewLabel);
		
		for (Alugavel baba: Sistema.getHotel().getBabas()) {
			listModel.addElement(baba);
		}
		setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeBaba());
			}
		});
		btnVoltar.setBounds(236, 509, 117, 25);
		add(btnVoltar);
		
		JButton btnEditarBab = new JButton("Editar");
		btnEditarBab.setForeground(new Color(51, 102, 153));
		btnEditarBab.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditarBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Sistema.setTela(new EditaBaba((Baba) list.getSelectedValue()));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione uma Baba primeiro");
				}
			}
		});
		btnEditarBab.setBounds(450, 509, 117, 25);
		add(btnEditarBab);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(51, 102, 153));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String busca = textField.getText();
				if (busca == null || busca.equals(""))
					JOptionPane.showMessageDialog(null, "Digite o nome da Bab�");
				listModel.clear();
				for (int i = 0; i < Sistema.getHotel().getBabas().size(); i++) {
					if (((Baba) (Sistema.getHotel().getBabas().get(i))).getNome().contains(busca))
						listModel.addElement(Sistema.getHotel().getBabas().get(i));
				}
			}
		});
		btnBuscar.setBounds(520, 174, 117, 25);
		add(btnBuscar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ConsultaBabas.class.getResource("/nucleo/icones/hotel4.png")));
		label.setBounds(338, 25, 229, 105);
		add(label);
	}

}