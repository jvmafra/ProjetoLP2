package gui.servicos;

import gui.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import classes.Baba.Baba;
public class ContrataBaba extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ContrataBaba() {
setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(417, 63, 159, 29);
		spinner.setModel(new SpinnerDateModel());
		add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(417, 125, 159, 29);
		spinner_1.setModel(new SpinnerDateModel());
		add(spinner_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 76, 207, 168);
		add(scrollPane);
		
		JList<Baba> list = new JList<Baba>();
		
		DefaultListModel<Baba> lista = new DefaultListModel<Baba>();
		for (int i = 0; i < Sistema.getHotel().getBabas().size(); i++) {
			lista.addElement(Sistema.getHotel().getBabas().get(i));
		}
		list.setModel(lista);
		scrollPane.setViewportView(list);
		

	}
}
