package gui.hospede;
import gui.PaginaInicialHotel;
import gui.Sistema;
import gui.contratos.NovoContrato;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.GridLayout;

import javax.swing.JLabel;


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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 600);;
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Novo H\u00F3spede");
		btnNewButton.setBounds(64, 27, 158, 65);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new NovoContrato());
			}
		});
		
		JButton btnConsultaHspedes = new JButton("Consulta H\u00F3spedes");
		btnConsultaHspedes.setBounds(280, 27, 158, 65);
		panel.add(btnConsultaHspedes);
		
		btnConsultaHspedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new ConsutaHospede());
			}
		});
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new PaginaInicialHotel());
			}
		});
		btnVoltar.setBounds(10, 171, 89, 23);
		panel.add(btnVoltar);

	}
}
