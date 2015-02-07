package gui.opiniao;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JEditorPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

public class CadastraOpiniao extends JPanel {

	/**
	 * Create the panel.
	 */
	public CadastraOpiniao() {
		setLayout(null);
		
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

	}
}
