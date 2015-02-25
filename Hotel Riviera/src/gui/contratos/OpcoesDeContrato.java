package gui.contratos;

import gui.PaginaInicialHotel;
import gui.Sistema;
import gui.hospede.OpcoesDoHospede;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import nucleo.classes.pessoa.Contrato;

import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

public class OpcoesDeContrato extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<Contrato> list;
	private JRadioButton rdbtnAbertos, rdbtnGeral, rdbtnFechados_1;
	private DefaultListModel<Contrato> listModel;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public OpcoesDeContrato() {
		setBackground(new Color(51, 102, 153));
		setBounds(0, 0, 800, 600);
		setLayout(null);

		textField = new JTextField();
		textField.setText("");
		textField.setBounds(492, 181, 280, 30);
		add(textField);
		textField.setColumns(10);

		JLabel lblDigiteONome = new JLabel("Digite o nome ou o CPF do hospede:");
		lblDigiteONome.setForeground(new Color(255, 255, 255));
		lblDigiteONome.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblDigiteONome.setBounds(492, 147, 280, 30);
		add(lblDigiteONome);

		// Adiciona os quartos disponíveis no jList
		listModel = new DefaultListModel<Contrato>();
		for (int i = 0; i < Sistema.getHotel().getContratos().size(); i++) {
			listModel.addElement(Sistema.getHotel().getContratos().get(i));
		}
		setLayout(null);

		// Instancia o scrollPane que contem o jList
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 180, 365, 315);
		add(scrollPane);

		// Intancio o jList que contem os quartos
		list = new JList<Contrato>();
		list.setForeground(new Color(255, 255, 255));
		list.setBackground(new Color(51, 102, 153));
		scrollPane.setViewportView(list);
		list.setFont(new Font("Tahoma", Font.PLAIN, 13));

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(listModel);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setSize(100, 25);
		btnVoltar.setLocation(376, 533);
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new PaginaInicialHotel());
			}
		});

		add(btnVoltar);

		JButton btnNovoContrato = new JButton("Novo");
		btnNovoContrato.setForeground(new Color(51, 102, 153));
		btnNovoContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new NovoContrato());
			}
		});
		btnNovoContrato.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovoContrato.setBounds(580, 354, 100, 25);
		add(btnNovoContrato);

		rdbtnAbertos = new JRadioButton("Abertos");
		rdbtnAbertos.setFont(new Font("Dialog", Font.PLAIN, 12));
		rdbtnAbertos.setForeground(Color.WHITE);
		rdbtnAbertos.setBounds(587, 219, 93, 23);
		rdbtnAbertos.setOpaque(false);
		add(rdbtnAbertos);

		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.setForeground(new Color(51, 102, 153));
		btnAbrir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contrato contrato = list.getSelectedValue();
				if (contrato == null)
					JOptionPane
							.showMessageDialog(null, "Selecione um contrato");
				else {
					Sistema.setTela(new VisualizaContrato(contrato));
				}
			}
		});
		btnAbrir.setActionCommand("Remover");
		btnAbrir.setBounds(580, 406, 100, 25);
		add(btnAbrir);

		JLabel lblNewLabel = new JLabel(new ImageIcon(
				OpcoesDeContrato.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(322, 33, 134, 85);
		add(lblNewLabel);

		rdbtnGeral = new JRadioButton("Geral");
		rdbtnGeral.setOpaque(false);
		rdbtnGeral.setForeground(Color.WHITE);
		rdbtnGeral.setFont(new Font("Dialog", Font.PLAIN, 12));
		rdbtnGeral.setBounds(673, 219, 99, 23);
		add(rdbtnGeral);

		rdbtnFechados_1 = new JRadioButton("Fechados");
		rdbtnFechados_1.setOpaque(false);
		rdbtnFechados_1.setForeground(Color.WHITE);
		rdbtnFechados_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		rdbtnFechados_1.setBounds(487, 219, 93, 23);
		add(rdbtnFechados_1);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnFechados_1);
		grupo.add(rdbtnGeral);
		grupo.add(rdbtnAbertos);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					listModel.clear();
					if (rdbtnAbertos.isSelected()) {
						for (int i = 0; i < Sistema.getHotel()
								.getContratosAbertos().size(); i++) {
							listModel.addElement(Sistema.getHotel()
									.getContratosAbertos().get(i));
						}
					} else if (rdbtnFechados_1.isSelected()) {
						for (int i = 0; i < Sistema.getHotel()
								.getContratosFechados().size(); i++) {
							listModel.addElement(Sistema.getHotel()
									.getContratosFechados().get(i));
						}
					} else
						for (int i = 0; i < Sistema.getHotel().getContratos()
								.size(); i++) {
							listModel.addElement(Sistema.getHotel()
									.getContratos().get(i));
						}
				
			}
		});
		btnBuscar.setForeground(new Color(51, 102, 153));
		btnBuscar.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnBuscar.setBounds(580, 250, 100, 25);
		add(btnBuscar);

	}
}