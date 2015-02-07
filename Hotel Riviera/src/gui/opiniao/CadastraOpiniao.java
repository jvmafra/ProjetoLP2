package gui.opiniao;

import gui.Sistema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class CadastraOpiniao extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CadastraOpiniao() {
		setLayout(null);
		setBounds(0, 0, 800, 600);
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(190, 34, 224, 119);
		add(editorPane);
		
		JLabel lblContenos = new JLabel("D\u00EA sua opini\u00E3o:");
		lblContenos.setBounds(84, 34, 83, 93);
		add(lblContenos);
		
		JLabel lblDSuaNota = new JLabel("D\u00EA sua nota:");
		lblDSuaNota.setBounds(84, 199, 83, 26);
		add(lblDSuaNota);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(190, 191, 57, 43);
		add(spinner);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeOpiniao());

			}
		});
		btnVoltar.setBounds(10, 266, 89, 23);
		add(btnVoltar);

	}
}
