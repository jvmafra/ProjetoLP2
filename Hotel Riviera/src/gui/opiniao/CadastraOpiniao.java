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

public class CadastraOpiniao extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CadastraOpiniao() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 800, 600);
		final JEditorPane editorPane = new JEditorPane();
		editorPane.setFont(new Font("NanumGothic", Font.PLAIN, 13));
		editorPane.setBackground(UIManager.getColor("ProgressBar.foreground"));
		editorPane.setBounds(255, 121, 388, 119);
		add(editorPane);
		
		JLabel lblContenos = new JLabel("OPINIAO:");
		lblContenos.setFont(new Font("NanumGothic", Font.BOLD, 14));
		lblContenos.setBounds(168, 147, 83, 93);
		add(lblContenos);
		
		JLabel lblDSuaNota = new JLabel("NOTA:");
		lblDSuaNota.setFont(new Font("NanumGothic", Font.BOLD, 14));
		lblDSuaNota.setBounds(181, 313, 83, 26);
		add(lblDSuaNota);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(260, 305, 37, 43);
		final SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 10, 1);
		spinner.setModel(model);
		add(spinner);
		
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("NanumGothic", Font.BOLD, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeOpiniao());

			}
		});
		btnVoltar.setBounds(260, 419, 109, 26);
		add(btnVoltar);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setFont(new Font("NanumGothic", Font.BOLD, 14));
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
		btnSalvar.setBounds(455, 419, 127, 26);
		add(btnSalvar);

	}
}