package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;

public class QualificacaoDoHotel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public QualificacaoDoHotel() {
		setLayout(null);
		
		JLabel lblComentariosMaisRecentes = new JLabel("Comentarios mais recentes");
		lblComentariosMaisRecentes.setBounds(48, 64, 135, 36);
		add(lblComentariosMaisRecentes);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 111, 233, 254);
		add(editorPane);
		
		JLabel lblMdiaDoHotel = new JLabel("M\u00E9dia do Hotel");
		lblMdiaDoHotel.setBounds(437, 75, 86, 25);
		add(lblMdiaDoHotel);
		
		textField = new JTextField();
		textField.setBounds(437, 111, 86, 20);
		add(textField);
		textField.setColumns(10);

	}

}
