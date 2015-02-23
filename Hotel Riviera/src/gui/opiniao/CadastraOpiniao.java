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
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

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
		final JEditorPane editorPane = new JEditorPane();
		editorPane.setForeground(new Color(51, 102, 153));
		editorPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		editorPane.setBackground(new Color(255, 255, 255));
		editorPane.setBounds(291, 199, 303, 105);
		add(editorPane);
		
		JLabel lblContenos = new JLabel("OPINIAO:");
		lblContenos.setForeground(new Color(255, 255, 255));
		lblContenos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContenos.setBounds(198, 211, 83, 93);
		add(lblContenos);
		
		JLabel lblDSuaNota = new JLabel("NOTA:");
		lblDSuaNota.setForeground(new Color(255, 255, 255));
		lblDSuaNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDSuaNota.setBounds(214, 374, 83, 26);
		add(lblDSuaNota);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinner.setBounds(291, 367, 37, 43);
		final SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 10, 1);
		spinner.setModel(model);
		add(spinner);
		
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeOpiniao());

			}
		});
		btnVoltar.setBounds(255, 491, 109, 26);
		add(btnVoltar);
		
		JButton btnSalvar = new JButton("SALVAR");
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
		btnSalvar.setBounds(467, 491, 127, 26);
		add(btnSalvar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CadastraOpiniao.class.getResource("/nucleo/icones/hotel4.png")));
		label.setBounds(350, 51, 196, 119);
		add(label);

	}
}