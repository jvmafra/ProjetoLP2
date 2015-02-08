package gui.opiniao;

import gui.Sistema;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import classes.HotelOpiniaoServicosPeriodo.Opiniao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QualificacaoDoHotel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public QualificacaoDoHotel() {
		setLayout(null);
		setBounds(0, 0, 800, 600);
		JLabel lblComentariosMaisRecentes = new JLabel("Comentarios mais recentes");
		lblComentariosMaisRecentes.setBounds(49, 28, 135, 36);
		add(lblComentariosMaisRecentes);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(128, 72, 233, 254);
		editorPane.setText(Sistema.getHotel().imprimeOpinioes());
		add(editorPane);
		
		JLabel lblMdiaDoHotel = new JLabel("M\u00E9dia do Hotel");
		lblMdiaDoHotel.setBounds(414, 34, 86, 25);
		add(lblMdiaDoHotel);
		
		textField = new JTextField();
		textField.setBounds(424, 72, 86, 20);
		textField.setText(String.valueOf(Sistema.getHotel().MediaDoHotel()));
		add(textField);
		textField.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeOpiniao());

			}
		});
		btnVoltar.setBounds(44, 337, 89, 23);
		add(btnVoltar);

	}

}
