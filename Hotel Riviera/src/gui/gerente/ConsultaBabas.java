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
import java.awt.Font;

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
		setBounds(0,0,800,600);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(232, 171, 246, 244);
		add(scrollPane);
		
		list = new JList<Alugavel>();
		scrollPane.setViewportView(list);
		list.setModel(listModel);
		
		textField = new JTextField();
		textField.setBounds(232, 123, 216, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Digite o nome da Baba:");
		lblNewLabel.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblNewLabel.setBounds(232, 97, 170, 14);
		add(lblNewLabel);

		listModel = new DefaultListModel<Alugavel>();
		for (int i = 0; i < Sistema.getHotel().getBabas().size(); i++) {
			listModel.addElement(Sistema.getHotel().getBabas().get(i));
		}
		setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeBaba());
			}
		});
		btnVoltar.setBounds(203, 445, 117, 25);
		add(btnVoltar);
		
		JButton btnEditarBab = new JButton("Editar Bab�");
		btnEditarBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Sistema.setTela(new EditaBaba((Baba) list.getSelectedValue()));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione uma Bab� primeiro");
				}
			}
		});
		btnEditarBab.setBounds(391, 445, 117, 25);
		add(btnEditarBab);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
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
		btnBuscar.setBounds(471, 120, 117, 25);
		add(btnBuscar);
	}

}
