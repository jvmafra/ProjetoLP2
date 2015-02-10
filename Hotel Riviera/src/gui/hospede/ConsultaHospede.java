package gui.hospede;

import gui.Sistema;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import classes.Pessoa.Hospede;

public class ConsultaHospede extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JList<Hospede> list = null;

	/**
	 * Create the panel.
	 */
	public ConsultaHospede() {

		
		setLayout(null);
		setBounds(0, 0, 800, 600);
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(176, 76, 447, 30);
		add(textField);
		textField.setColumns(10);

		JLabel lblDigiteONome = new JLabel(
				"Digite o Nome ou o CPF do H\u00F3spede:");
		lblDigiteONome.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblDigiteONome.setBounds(42, 25, 280, 41);
		add(lblDigiteONome);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDoHospede());
			}
		});
		btnVoltar.setBounds(30, 566, 89, 23);
		add(btnVoltar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(177, 210, 335, 261);
		add(scrollPane);

		list = new JList<Hospede>();
		scrollPane.setViewportView(list);
		final DefaultListModel<Hospede> listModel = new DefaultListModel<Hospede>();

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listModel.clear();
				String busca = textField.getText();
				if (busca.length() < 5){
					JOptionPane.showMessageDialog(null,
							"Seja mais especifico em sua busca");
					}
				else {
					try {
						Long.parseLong(busca);
						for (int i = 0; i < Sistema.getHotel().getHospedes()
								.size(); i++) {
							if (Sistema.getHotel().getHospedes().get(i)
									.getCPF().contains(busca))
								listModel.addElement(Sistema.getHotel()
										.getHospedes().get(i));
						}
					} catch (Exception e) {
						for (int i = 0; i < Sistema.getHotel().getHospedes()
								.size(); i++) {
							if (Sistema.getHotel().getHospedes().get(i)
									.getNome().contains(busca))
								listModel.addElement(Sistema.getHotel()
										.getHospedes().get(i));
						}
					}
				}
			}
		});
		list.setModel(listModel);
		btnBuscar.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		btnBuscar.setBounds(307, 128, 147, 41);
		add(btnBuscar);

		JLabel lblResultadosDaSua = new JLabel("Resultados da sua Busca:");
		lblResultadosDaSua.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblResultadosDaSua.setBounds(42, 169, 160, 30);
		add(lblResultadosDaSua);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new EditaHospede(list.getSelectedValue()));
			}
		});
		btnEditar.setBounds(573, 342, 112, 41);
		add(btnEditar);

	}
}
