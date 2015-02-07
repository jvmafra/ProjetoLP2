package gui.contratos;

import gui.PaginaInicialHotel;
import gui.Sistema;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class OpcoesDeContrato extends JPanel {

	/**
	 * Create the panel.
	 */
	public OpcoesDeContrato() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{34, 277, 0};
		gridBagLayout.rowHeights = new int[]{57, 62, 35, 62, 34, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnContratosEmAberto = new JButton("Contratos em Aberto");
		GridBagConstraints gbc_btnContratosEmAberto = new GridBagConstraints();
		gbc_btnContratosEmAberto.fill = GridBagConstraints.BOTH;
		gbc_btnContratosEmAberto.insets = new Insets(0, 0, 5, 0);
		gbc_btnContratosEmAberto.gridx = 1;
		gbc_btnContratosEmAberto.gridy = 1;
		add(btnContratosEmAberto, gbc_btnContratosEmAberto);
		
		JButton btnContratosFechados = new JButton("Contratos Fechados");
		GridBagConstraints gbc_btnContratosFechados = new GridBagConstraints();
		gbc_btnContratosFechados.fill = GridBagConstraints.BOTH;
		gbc_btnContratosFechados.insets = new Insets(0, 0, 5, 0);
		gbc_btnContratosFechados.gridx = 1;
		gbc_btnContratosFechados.gridy = 3;
		add(btnContratosFechados, gbc_btnContratosFechados);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new PaginaInicialHotel());
			}
		});
		GridBagConstraints gbc_btnVoltar = new GridBagConstraints();
		gbc_btnVoltar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnVoltar.gridx = 1;
		gbc_btnVoltar.gridy = 5;
		add(btnVoltar, gbc_btnVoltar);

	}
}
