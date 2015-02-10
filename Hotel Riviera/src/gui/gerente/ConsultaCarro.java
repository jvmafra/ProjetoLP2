package gui.gerente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import classes.Carro.Carro;
import classes.HotelOpiniaoServicosPeriodo.Alugavel;

public class ConsultaCarro extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JList<Alugavel> list;
	private DefaultListModel<Alugavel> listModel;

	/**
	 * Create the panel.
	 */
	public ConsultaCarro() {

		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(142, 108, 246, 244);
		add(scrollPane);
		
		list = new JList<Alugavel>();
		scrollPane.setViewportView(list);
		
		textField = new JTextField();
		textField.setBounds(75, 59, 216, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Digite a placa do Carro:");
		lblNewLabel.setBounds(29, 37, 170, 14);
		add(lblNewLabel);

		listModel = new DefaultListModel<Alugavel>();
		for (int i = 0; i < Sistema.getHotel().getCarros().size(); i++) {
			listModel.addElement(Sistema.getHotel().getCarros().get(i));
		}
		list.setModel(listModel);
		setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeCarro());
			}
		});
		btnVoltar.setBounds(130, 374, 117, 25);
		add(btnVoltar);
		
		JButton btnEditarBab = new JButton("Editar Carro");
		btnEditarBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Sistema.setTela(new EditarCarro((Carro) list.getSelectedValue()));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione um Carro primeiro");
				}
			}

		});
		btnEditarBab.setBounds(290, 374, 129, 25);
		add(btnEditarBab);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.clear();
				String busca = textField.getText();
				if (busca == null || busca.equals("")){
					for (int i = 0; i < Sistema.getHotel().getCarros().size(); i++) {
						listModel.addElement(Sistema.getHotel().getCarros().get(i));
					}
				} else {
					for (int i = 0; i < Sistema.getHotel().getCarros().size(); i++) {
						if (Sistema.getHotel().getCarros().get(i).getPlaca().contains(busca))
							listModel.addElement(Sistema.getHotel().getCarros().get(i));
					}
				}
			}
		});
		btnBuscar.setBounds(330, 56, 117, 25);
		add(btnBuscar);
	}

	
	
	
	
	
	
	
	
	
	
}
