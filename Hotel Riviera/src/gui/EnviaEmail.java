package gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nucleo.classes.pessoa.Hospede;
import javax.swing.JEditorPane;
import javax.swing.JTextField;

public class EnviaEmail extends JPanel {
	Hospede destinatario;
	
	private static final long serialVersionUID = 1L;
	private JTextField textEmail;
	private JTextField textDestinatario;

	/**
	 * Create the panel.
	 */
	public EnviaEmail(Hospede destinatario) {
		this.destinatario = destinatario;
		
		setLayout(null);
		setBounds(0, 0, 800, 600);
		setBackground(new Color(51, 102, 153));
		JLabel lblEmail= new JLabel(new ImageIcon(EnviaEmail.class
				.getResource("/nucleo/icones/hotel4.png")));
		lblEmail.setBounds(322, 33, 134, 85);
		lblEmail.setText(destinatario.getEmail());
		add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(151, 204, 382, 30);
		add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setForeground(Color.WHITE);
		lblEmail_1.setBounds(81, 203, 52, 30);
		add(lblEmail_1);
		
		textDestinatario = new JTextField();
		textDestinatario.setColumns(10);
		textDestinatario.setBounds(151, 150, 382, 30);
		add(textDestinatario);
		
		JLabel lblDestinatrio = new JLabel("Destinatário");
		lblDestinatrio.setForeground(Color.WHITE);
		lblDestinatrio.setBounds(31, 149, 102, 30);
		add(lblDestinatrio);
		
		JEditorPane edTextoEmail = new JEditorPane();
		edTextoEmail.setBounds(151, 268, 530, 303);
		add(edTextoEmail);
		
		JLabel lblTextoDoEmail = new JLabel("Texto do Email");
		lblTextoDoEmail.setForeground(Color.WHITE);
		lblTextoDoEmail.setBounds(12, 269, 121, 30);
		add(lblTextoDoEmail);

	}
}
