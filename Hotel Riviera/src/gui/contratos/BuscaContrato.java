package gui.contratos;

import java.util.Calendar;
import java.util.GregorianCalendar;

import excecoes.EntradaDeDadosException;
import gui.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import classes.FormasCobranca.EstrategiaCobranca;
import classes.FormasCobranca.EstrategiaSaoJoao;
import classes.HotelOpiniaoServicosPeriodo.Periodo;
import classes.Pessoa.Contrato;
import classes.Pessoa.Hospede;
import classes.Quartos.Quarto;
import classes.Quartos.QuartoPresidencial;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

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

		setForeground(Color.WHITE);

		// Adiciona os quartos disponíveis no jList
		DefaultListModel<Contrato> listModel = new DefaultListModel<Contrato>();
		for (int i = 0; i < Sistema.getHotel().getContratos().size(); i++) {
			listModel.addElement(Sistema.getHotel().getContratos().get(i));
		}
		setLayout(null);

		// Intancio o jList que contem os quartos
		list = new JList<Contrato>();
		list.setBounds(143, 92, 216, 183);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(listModel);

		// Instancia o scrollPane que contem o jList
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(239, 44, 282, 315);
		add(scrollPane);
		scrollPane.setViewportView(list);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeContrato());
			}
		});
		btnVoltar.setBounds(196, 408, 117, 25);
		add(btnVoltar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object obj = list.getSelectedValue();
				if (obj == null)
					JOptionPane
							.showMessageDialog(null, "Selecione um contrato");

				Contrato c = (Contrato) obj;
				Sistema.getHotel().getContratos().remove(c);
				Sistema.setTela(new BuscaContrato());

			}
		});
		btnRemover.setActionCommand("Remover");
		btnRemover.setBounds(330, 408, 117, 25);
		add(btnRemover);

		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.setActionCommand("Remover");
		btnAbrir.setBounds(467, 408, 117, 25);
		add(btnAbrir);
	}
}
