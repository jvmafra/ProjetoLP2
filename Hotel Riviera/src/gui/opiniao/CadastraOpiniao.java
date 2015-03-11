package gui.opiniao;

import gui.Sistema;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

import nucleo.classes.hotel.Opiniao;

public class CadastraOpiniao extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CadastraOpiniao() {
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0, 0, 800, 600);
		final JTextArea editorPane = new JTextArea();
		editorPane.setForeground(new Color(51, 102, 153));
		editorPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		editorPane.setBackground(new Color(255, 255, 255));
		editorPane.setBounds(291, 155, 303, 161);
		add(editorPane);
		
		JLabel lblContenos = new JLabel("OPINIAO:");
		lblContenos.setForeground(new Color(255, 255, 255));
		lblContenos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContenos.setBounds(198, 191, 83, 93);
		add(lblContenos);
		
		JLabel lblDSuaNota = new JLabel("NOTA:");
		lblDSuaNota.setForeground(new Color(255, 255, 255));
		lblDSuaNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDSuaNota.setBounds(347, 386, 83, 26);
		add(lblDSuaNota);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinner.setBounds(421, 384, 54, 33);
		final SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 10, 1);
		spinner.setModel(model);
		add(spinner);
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeOpiniao());

			}
		});
		btnVoltar.setBounds(274, 489, 90, 30);
		add(btnVoltar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(51, 102, 153));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Opiniao opiniao = new Opiniao(editorPane.getText(), Integer.parseInt(model.getNumber().toString()));
					Sistema.getHotel().adicionaOpiniao(opiniao);
					JOptionPane.showMessageDialog(null,	"Salvo com sucesso!");
					Sistema.setTela(new OpcoesDeOpiniao());
					

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,	e1.getMessage());
				}
			}
		});
		btnSalvar.setBounds(486, 489, 90, 30);
		add(btnSalvar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CadastraOpiniao.class.getResource("/nucleo/icones/hotel4 feito.png")));
		label.setBounds(347, 11, 196, 119);
		add(label);

	}
}