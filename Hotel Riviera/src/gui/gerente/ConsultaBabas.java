package gui.gerente;

import excecoes.NomeInvalidoException;
import excecoes.TelefoneInvalidoException;
import gui.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;

import classes.Baba.Baba;
import classes.HotelOpiniaoServicosPeriodo.Alugavel;
import classes.Pessoa.Contrato;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaBabas extends JPanel {
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
	public ConsultaBabas() {
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
		
		JLabel lblNewLabel = new JLabel("Digite o nome da Babá:");
		lblNewLabel.setBounds(29, 37, 170, 14);
		add(lblNewLabel);

		listModel = new DefaultListModel<Alugavel>();
		for (int i = 0; i < Sistema.getHotel().getBabas().size(); i++) {
			listModel.addElement(Sistema.getHotel().getBabas().get(i));
		}
		list.setModel(listModel);
		setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeBaba());
			}
		});
		btnVoltar.setBounds(130, 374, 117, 25);
		add(btnVoltar);
		
		JButton btnEditarBab = new JButton("Editar Babá");
		btnEditarBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Sistema.setTela(new EditaBaba((Baba) list.getSelectedValue()));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione uma Babá primeiro");
				}
			}
		});
		btnEditarBab.setBounds(290, 374, 117, 25);
		add(btnEditarBab);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String busca = textField.getText();
				if (busca == null || busca.equals(""))
					JOptionPane.showMessageDialog(null, "Digite o nome da Babá");
				listModel.clear();
				for (int i = 0; i < Sistema.getHotel().getBabas().size(); i++) {
					if (Sistema.getHotel().getBabas().get(i).getNome().contains(busca))
						listModel.addElement(Sistema.getHotel().getBabas().get(i));
				}
			}
		});
		btnBuscar.setBounds(330, 56, 117, 25);
		add(btnBuscar);
	}

}
