package gui.opiniao;

import gui.Sistema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import nucleo.classes.hotel.*;

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
		final JEditorPane editorPane = new JEditorPane();
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
		final SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 10, 1);
		spinner.setModel(model);
		add(spinner);
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeOpiniao());

			}
		});
		btnVoltar.setBounds(78, 363, 89, 23);
		add(btnVoltar);
		
		JButton btnSalvar = new JButton("Salvar opini\u00E3o");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Opiniao opiniao = new Opiniao(editorPane.getText(), Integer.parseInt(model.getNumber().toString()));
					Sistema.getHotel().adicionaOpiniao(opiniao);
					editorPane.setText("");

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(283, 288, 131, 51);
		add(btnSalvar);

	}
}