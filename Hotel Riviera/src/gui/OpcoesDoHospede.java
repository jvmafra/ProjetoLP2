package gui;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class OpcoesDoHospede extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public OpcoesDoHospede() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Novo H\u00F3spede");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new NovoContrato());
			}
		});
		btnNewButton.setBounds(162, 27, 344, 196);
		add(btnNewButton);
		
		JButton btnConsultaHspedes = new JButton("Consulta H\u00F3spedes");
		btnConsultaHspedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsultaHspedes.setBounds(548, 27, 344, 196);
		add(btnConsultaHspedes);

	}

}
