package gui.opiniao;

import gui.Sistema;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import nucleo.classes.servicos.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class QualificacaoDoHotel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField media_hotel;
	private JTextPane status;

	/**
	 * Create the panel.
	 */
	public QualificacaoDoHotel() {
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0, 0, 800, 600);
		JLabel lblComentariosMaisRecentes = new JLabel("OPINIOES CADASTRADAS");
		lblComentariosMaisRecentes.setForeground(new Color(255, 255, 255));
		lblComentariosMaisRecentes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblComentariosMaisRecentes.setBounds(306, 153, 214, 36);
		add(lblComentariosMaisRecentes);
		
		JLabel lblMdiaDoHotel = new JLabel("MEDIA DE ACEITACAO: ");
		lblMdiaDoHotel.setForeground(new Color(255, 255, 255));
		lblMdiaDoHotel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMdiaDoHotel.setBounds(251, 467, 184, 25);
		add(lblMdiaDoHotel);
		
		media_hotel = new JTextField();
		media_hotel.setBounds(408, 471, 86, 20);
		media_hotel.setText(String.valueOf(Sistema.getHotel().MediaDoHotel()));
		add(media_hotel);
		media_hotel.setColumns(10);
		media_hotel.setText(Sistema.getHotel().MediaDoHotel());
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeOpiniao());

			}
		});
		btnVoltar.setBounds(346, 526, 89, 23);
		add(btnVoltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(221, 200, 376, 226);
		add(scrollPane);
		
		status = new JTextPane();
		status.setForeground(new Color(51, 102, 153));
		scrollPane.setViewportView(status);
		status.setEditable(false);
		status.setBackground(new Color(255, 255, 255));
		status.setFont(new Font("Tahoma", Font.PLAIN, 13));
		status.setText(Sistema.getHotel().imprimeOpinioes());
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(QualificacaoDoHotel.class.getResource("/nucleo/icones/hotel4.png")));
		label.setBounds(324, 11, 273, 131);
		add(label);
		

	}
}