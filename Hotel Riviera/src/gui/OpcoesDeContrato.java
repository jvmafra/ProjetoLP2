package gui;

import javax.swing.JPanel;
import javax.swing.JButton;

public class OpcoesDeContrato extends JPanel {

	/**
	 * Create the panel.
	 */
	public OpcoesDeContrato() {
		setLayout(null);
		
		JButton btnContratosEmAberto = new JButton("Contratos em Aberto");
		btnContratosEmAberto.setBounds(87, 57, 224, 62);
		add(btnContratosEmAberto);
		
		JButton btnContratosFechados = new JButton("Contratos Fechados");
		btnContratosFechados.setBounds(87, 154, 224, 62);
		add(btnContratosFechados);

	}
}
