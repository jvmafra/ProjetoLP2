package gui;

import gui.hospede.ExibeHospede;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import nucleo.classes.arquivo.Email;
import nucleo.classes.pessoa.Hospede;

/**
 * Tela que representa o envio de email para um hospede
 * @author Hugo Gabriel
 */

public class EnviaEmail extends JPanel {
	private Hospede hospede;
	
	private static final long serialVersionUID = 1L;
	private JTextField textEmail;
	private JTextField txtAssunto;
	private JEditorPane editorPane;
	
	

	/**
	 * Create the panel.
	 */
	public EnviaEmail(Hospede destinatario) {
		this.hospede = destinatario;
		setBounds(0, 0, 800, 600);
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		JLabel icone = new JLabel(new ImageIcon(EnviaEmail.class
				.getResource("/nucleo/icones/hotel4 feito.png")));
		icone.setBounds(312, 11, 138, 105);
		add(icone);
		
		JLabel lblEmail_1 = new JLabel("Email: ");
		lblEmail_1.setBounds(95, 141, 57, 20);
		lblEmail_1.setForeground(Color.WHITE);
		add(lblEmail_1);
		
		textEmail = new JTextField();
		textEmail.setBounds(157, 141, 465, 30);
		textEmail.setText(destinatario.getEmail());
		add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblAssunto = new JLabel("Assunto: ");
		lblAssunto.setBounds(81, 188, 69, 14);
		lblAssunto.setForeground(Color.WHITE);
		add(lblAssunto);
		
		txtAssunto = new JTextField();
		txtAssunto.setBounds(155, 185, 465, 30);
		txtAssunto.setText((String) null);
		txtAssunto.setColumns(10);
		add(txtAssunto);
		
		JLabel lblTextoDoEmail = new JLabel("Texto do Email: ");
		lblTextoDoEmail.setBounds(54, 231, 98, 14);
		lblTextoDoEmail.setForeground(Color.WHITE);
		add(lblTextoDoEmail);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(648, 307, 90, 30);
		btnEnviar.setForeground(new Color(51, 102, 153));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Email e = new Email();
				try {
					e.enviaEmail(textEmail.getText(), editorPane.getText(), txtAssunto.getText());
					JOptionPane.showMessageDialog(null, "Email enviado com sucesso.");
					Sistema.setTela(new ExibeHospede(hospede));

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível enviar seu email.");
				}
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(157, 231, 465, 333);
		add(scrollPane);
		
		editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnEnviar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new ExibeHospede(hospede));
			}
		});
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(648, 393, 90, 30);
		add(btnVoltar);

		
	}
}
