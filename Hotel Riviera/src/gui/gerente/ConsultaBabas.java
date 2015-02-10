package gui.gerente;

import gui.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;

import classes.Baba.Baba;
import classes.HotelOpiniaoServicosPeriodo.Alugavel;
import classes.Pessoa.Contrato;

public class ConsultaBabas extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public ConsultaBabas() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 164, 246, 244);
		add(scrollPane);
		
		JList<Alugavel> list = new JList<Alugavel>();
		scrollPane.setViewportView(list);
		
		textField = new JTextField();
		textField.setBounds(147, 93, 170, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(64, 96, 46, 14);
		add(lblNewLabel);

		DefaultListModel<Alugavel> listModel = new DefaultListModel<Alugavel>();
		for (int i = 0; i < Sistema.getHotel().getBabas().size(); i++) {
			listModel.addElement(Sistema.getHotel().getBabas().get(i));
		}
		list.setModel(listModel);
		setLayout(null);
	}
}
