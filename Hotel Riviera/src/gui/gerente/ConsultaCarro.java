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

import nucleo.classes.hotel.Alugavel;
import nucleo.classes.servicos.Carro;

import java.awt.Font;
import java.awt.Color;

public class ConsultaCarro extends JPanel {

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
	public ConsultaCarro() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0,0,800,600);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(252, 144, 246, 244);
		add(scrollPane);
		
		scrollPane.setViewportView(list);
		list.setModel(listModel);
		
		textField = new JTextField();
		textField.setBounds(252, 112, 216, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Digite a placa do Carro:");
		lblNewLabel.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblNewLabel.setBounds(284, 87, 170, 14);
		add(lblNewLabel);

		for (int i = 0; i < Sistema.getHotel().getCarros().size(); i++) {
			listModel.addElement(Sistema.getHotel().getCarros().get(i));
		}
		setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeCarro());
			}
		});
		btnVoltar.setBounds(235, 400, 117, 25);
		add(btnVoltar);
		
		JButton btnEditarBab = new JButton("Editar Carro");
		btnEditarBab.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnEditarBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Sistema.setTela(new EditarCarro((Carro) list.getSelectedValue()));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione um Carro primeiro");
				}
			}

		});
		btnEditarBab.setBounds(427, 400, 129, 25);
		add(btnEditarBab);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
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
						if (((Carro) (Sistema.getHotel().getCarros().get(i))).getPlaca().contains(busca))
							listModel.addElement(Sistema.getHotel().getCarros().get(i));
					}
				}
			}
		});
		btnBuscar.setBounds(480, 109, 117, 25);
		add(btnBuscar);
	}
	
	
	
	
}