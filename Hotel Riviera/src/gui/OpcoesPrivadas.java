package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpcoesPrivadas extends JPanel {

	/**
	 * Create the panel.
	 */
	public OpcoesPrivadas() {
		setLayout(null);
		
		JButton btnFaturamentos = new JButton("Faturamentos");
		btnFaturamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new FaturamentoDoHotel());
			}
		});
		btnFaturamentos.setBounds(116, 78, 174, 33);
		add(btnFaturamentos);
		
		JButton btnCadastraFuncionrio = new JButton("Cadastra Funcion\u00E1rio");
		btnCadastraFuncionrio.setBounds(117, 137, 173, 33);
		add(btnCadastraFuncionrio);

	}

}
