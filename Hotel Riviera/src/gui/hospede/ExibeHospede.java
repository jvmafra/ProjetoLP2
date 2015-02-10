package gui.hospede;

import javax.swing.JPanel;

import classes.Pessoa.Hospede;
import javax.swing.JTextPane;

public class ExibeHospede extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Hospede hospede;
	/**
	 * Create the panel.
	 */
	public ExibeHospede(Hospede h) {
		this.hospede = h;
		setLayout(null);
		
		JTextPane texthospede = new JTextPane();
		texthospede.setBounds(38, 70, 206, 240);
		texthospede.setText(hospede.toString());
		texthospede.setEditable(false);
		add(texthospede);

	}
}
