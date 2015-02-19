package gui.contratos;

import java.util.Calendar;
import java.util.GregorianCalendar;

import gui.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import nucleo.classes.hotel.Periodo;
import nucleo.classes.pessoa.Contrato;
import nucleo.classes.pessoa.Hospede;
import nucleo.classes.quartos.Quarto;
import nucleo.classes.quartos.QuartoPresidencial;
import nucleo.excecoes.EntradaDeDadosException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class BuscaContrato extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<Contrato> list;

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public BuscaContrato() {
		setBackground(Color.WHITE);
		setBounds(0,0, 800, 600);
		setForeground(Color.WHITE);

		// Adiciona os quartos disponíveis no jList
		DefaultListModel<Contrato> listModel = new DefaultListModel<Contrato>();
		for (int i = 0; i < Sistema.getHotel().getContratos().size(); i++) {
			listModel.addElement(Sistema.getHotel().getContratos().get(i));
		}
		setLayout(null);

		// Intancio o jList que contem os quartos
		list = new JList<Contrato>();
		list.setFont(new Font("NanumGothic", Font.PLAIN, 13));
		list.setBounds(143, 92, 216, 183);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(listModel);

		// Instancia o scrollPane que contem o jList
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(239, 44, 282, 315);
		add(scrollPane);
		scrollPane.setViewportView(list);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeContrato());
			}
		});
		btnVoltar.setBounds(196, 408, 117, 25);
		add(btnVoltar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Contrato contrato = list.getSelectedValue();
				if (contrato == null)
					JOptionPane.showMessageDialog(null, "Selecione um contrato");
				else{
					Sistema.getHotel().getContratos().remove(contrato);
					Sistema.setTela(new BuscaContrato());
				}

			}
		});
		btnRemover.setActionCommand("Remover");
		btnRemover.setBounds(330, 408, 117, 25);
		add(btnRemover);

		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contrato contrato = list.getSelectedValue();
				if (contrato == null)
					JOptionPane.showMessageDialog(null, "Selecione um contrato");
				else{
				Sistema.setTela(new VisualizaContrato(contrato));
				}
			}
		});
		btnAbrir.setActionCommand("Remover");
		btnAbrir.setBounds(467, 408, 117, 25);
		add(btnAbrir);
	}
}