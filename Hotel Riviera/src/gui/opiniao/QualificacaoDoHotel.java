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
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 800, 600);
		JLabel lblComentariosMaisRecentes = new JLabel("MAIS RECENTES");
		lblComentariosMaisRecentes.setFont(new Font("NanumGothic", Font.BOLD, 14));
		lblComentariosMaisRecentes.setBounds(344, 0, 135, 36);
		add(lblComentariosMaisRecentes);
		
		JLabel lblMdiaDoHotel = new JLabel("MEDIA DE ACEITACAO: ");
		lblMdiaDoHotel.setFont(new Font("NanumGothic", Font.BOLD, 14));
		lblMdiaDoHotel.setBounds(251, 405, 184, 25);
		add(lblMdiaDoHotel);
		
		media_hotel = new JTextField();
		media_hotel.setBounds(422, 408, 86, 20);
		media_hotel.setText(String.valueOf(Sistema.getHotel().MediaDoHotel()));
		add(media_hotel);
		media_hotel.setColumns(10);
		media_hotel.setText(Sistema.getHotel().MediaDoHotel());
		
		status = new JTextPane();
		status.setEditable(false);
		status.setBackground(UIManager.getColor("PopupMenu.background"));
		status.setFont(new Font("NanumGothic", Font.BOLD, 13));
		status.setBounds(207, 37, 405, 355);
		status.setText(Sistema.getHotel().imprimeOpinioes());
		add(status);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("NanumGothic", Font.BOLD, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeOpiniao());

			}
		});
		btnVoltar.setBounds(346, 526, 89, 23);
		add(btnVoltar);
		

	}
}