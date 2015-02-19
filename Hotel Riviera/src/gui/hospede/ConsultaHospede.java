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

import nucleo.classes.pessoa.Hospede;

public class ConsultaHospede extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JList<Hospede> list;

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
				"Digite o Nome ou o CPF do Hospede:");
		lblDigiteONome.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblDigiteONome.setBounds(176, 29, 280, 41);
		add(lblDigiteONome);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDoHospede());
			}
		});
		btnVoltar.setBounds(313, 527, 89, 23);
		add(btnVoltar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(177, 210, 335, 261);
		add(scrollPane);

		list = new JList<Hospede>();
		scrollPane.setViewportView(list);
		final DefaultListModel<Hospede> listModel = new DefaultListModel<Hospede>();

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listModel.clear();
				String busca = textField.getText();
				if (busca.length() < 4){
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
		btnBuscar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnBuscar.setBounds(313, 116, 130, 23);
		add(btnBuscar);

		JLabel lblResultadosDaSua = new JLabel("Resultados da busca:");
		lblResultadosDaSua.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblResultadosDaSua.setBounds(176, 166, 241, 30);
		add(lblResultadosDaSua);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedValue() != null)
					Sistema.setTela(new EditaHospede(list.getSelectedValue()));
				else
					mostraTelaDeErro();
			}
		});
		btnEditar.setBounds(573, 333, 112, 41);
		add(btnEditar);
		
		JButton btnNewButton = new JButton("Abrir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() == null)
					mostraTelaDeErro();
				else
					Sistema.setTela(new ExibeHospede(list.getSelectedValue()));
			}
		});
		btnNewButton.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnNewButton.setBounds(573, 267, 112, 41);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remover");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() != null){
					Sistema.getHotel().removeHospede(list.getSelectedValue());
					Sistema.setTela(new ConsultaHospede());
				}
				else
					mostraTelaDeErro();
			}
		});
		btnNewButton_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnNewButton_1.setBounds(573, 395, 112, 41);
		add(btnNewButton_1);

	}
	
	private void mostraTelaDeErro() {
		JOptionPane.showMessageDialog(null,	"Selecione um hospede antes");

	}


}