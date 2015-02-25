package gui.contratos;

import gui.PaginaInicialHotel;
import gui.Sistema;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class OpcoesDeContrato extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<Contrato> list;

	/**
	 * Create the panel.
	 */
	public OpcoesDeContrato() {
		setBackground(new Color(51, 102, 153));
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		
		JTextField textField = new JTextField();
		textField.setText("");
		textField.setBounds(493, 210, 280, 30);
		add(textField);
		textField.setColumns(10);

		JLabel lblDigiteONome = new JLabel(
				"Digite o nome ou o CPF do hospede:");
		lblDigiteONome.setForeground(new Color(255, 255, 255));
		lblDigiteONome.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblDigiteONome.setBounds(433, 170, 280, 41);
		add(lblDigiteONome);

		// Adiciona os quartos disponíveis no jList
		DefaultListModel<Contrato> listModel = new DefaultListModel<Contrato>();
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
		btnVoltar.setLocation(371, 524);
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
		btnNovoContrato.setBounds(536, 346, 100, 25);
		add(btnNovoContrato);

		JButton btnRemover = new JButton("Remover");
		btnRemover.setForeground(new Color(51, 102, 153));
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Contrato contrato = list.getSelectedValue();
				if (contrato == null)
					JOptionPane
							.showMessageDialog(null, "Selecione um contrato");
				else {
					Sistema.getHotel().getContratos().remove(contrato);
					Sistema.setTela(new BuscaContrato());
				}

			}
		});
		btnRemover.setActionCommand("Remover");
		btnRemover.setBounds(536, 396, 100, 25);
		add(btnRemover);

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
		btnAbrir.setBounds(536, 446, 100, 25);
		add(btnAbrir);

		JLabel lblNewLabel = new JLabel(new ImageIcon(BuscaContrato.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(322, 33, 134, 85);
		add(lblNewLabel);
		
		JRadioButton rdbtnFechados = new JRadioButton("Fechados");
		rdbtnFechados.setFont(new Font("Dialog", Font.PLAIN, 12));
		rdbtnFechados.setForeground(Color.WHITE);
		rdbtnFechados.setBounds(501, 259, 119, 23);
		rdbtnFechados.setOpaque(false);
		add(rdbtnFechados);
		
		JRadioButton rdbtnAbertos = new JRadioButton("Abertos");
		rdbtnAbertos.setFont(new Font("Dialog", Font.PLAIN, 12));
		rdbtnAbertos.setForeground(Color.WHITE);
		rdbtnAbertos.setBounds(624, 259, 149, 23);
		rdbtnAbertos.setOpaque(false);
		add(rdbtnAbertos);
	}
}