package gui.hospede;

import excecoes.EntradaDeDadosException;
import gui.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import classes.Pessoa.Hospede;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JList;

public class ConsutaHospede extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public ConsutaHospede() {
		try {
			Hospede h1 = new Hospede("Edvalzinho","10530025485", "3224432", "18",  "e@hot.com", "8888888888", "ary", "4001635716004159");
			Sistema.getHotel().adicionaHospede(h1);
		} catch (EntradaDeDadosException e1) {
			e1.printStackTrace();
		}
		setLayout(null);
		setBounds(0, 0, 800, 600);
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(325, 32, 447, 30);
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
		scrollPane.setBounds(302, 206, 335, 182);
		add(scrollPane);

		JList<Hospede> list = new JList<Hospede>();
		scrollPane.setViewportView(list);
		final DefaultListModel<Hospede> listModel = new DefaultListModel<Hospede>();

		// Intancio o jList que contem os quartos
		// JList<Quarto> list = new JList<Quarto>();
		// list.setBounds(30, 134, 243, 100);
		// list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//
		// // Instancia o scrollPane que contem o jList
		// JScrollPane scrollPane = new JScrollPane();
		// scrollPane.setSize(243, 197);
		// scrollPane.setLocation(30, 134);
		// scrollPane.setViewportView(list);
		// quartosDisponiveis.add(scrollPane);
		//
		// // Adiciona os quartos disponíveis no jList
		// DefaultListModel<Quarto> listModel = new DefaultListModel<Quarto>();
		// for (int i = 0; i < hotel.getQuartos().size(); i++) {
		// listModel.addElement(hotel.getQuartos().get(i));
		// }
		// list.setModel(listModel);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listModel.clear();
				String busca = textField.getText();
				if (busca.length() < 5){
					System.out.println(Sistema.getHotel().getHospedes().size());
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
		btnBuscar.setBounds(226, 97, 147, 41);
		add(btnBuscar);

		JLabel lblResultadosDaSua = new JLabel("Resultados da sua Busca:");
		lblResultadosDaSua.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblResultadosDaSua.setBounds(42, 169, 160, 30);
		add(lblResultadosDaSua);

	}
}
