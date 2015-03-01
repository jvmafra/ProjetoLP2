package gui.gerente;

import gui.Sistema;
import gui.hospede.ExibeHospede;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class HospedesMais extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<String> list;
	private DefaultListModel<String> listModel;

	/**
	 * Create the panel.
	 */
	public HospedesMais() {
		setBackground(new Color(51, 102, 153));
		setBounds(0, 0, 800, 600);
		setLayout(null);

		JLabel lblNewLabel = new JLabel(new ImageIcon(
				ExibeHospede.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(323, 22, 138, 89);
		add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 149, 335, 331);
		add(scrollPane);

		list = new JList<String>();
		list.setFont(new Font("Dialog", Font.PLAIN, 13));
		list.setBackground(new Color(51, 102, 153));
		list.setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(list);
		listModel = new DefaultListModel<String>();

		melhoresHospedes();
		list.setModel(listModel);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesEstatisticas());
			}
		});
		btnVoltar.setBounds(359, 521, 90, 30);
		add(btnVoltar);

	}

	public void melhoresHospedes() {
		List<String> nomes = new ArrayList<String>();
		List<Integer> numDeHospedagens = new ArrayList<Integer>();
		for (int i = 0; i < Sistema.getHotel().getHospedes().size(); i++) {
			nomes.add(Sistema.getHotel().getHospedes().get(i).getNome());
			numDeHospedagens.add(Sistema.getHotel().pesquisaContrato(Sistema.getHotel().getHospedes().get(i).getNome()).size());
		}
		
		for (int a = numDeHospedagens.size()-1; a >=0; a--){
			int maior = 0;
			int id = 0;
			for (int i = 0; i < numDeHospedagens.size(); i++) {
				if (numDeHospedagens.get(i) > maior)
					id = i;
					maior = numDeHospedagens.get(i);
			}
			listModel.addElement(nomes.get(id) + " - " + numDeHospedagens.get(id) + " hospedagem(s).");
			nomes.remove(id);
			numDeHospedagens.remove(id);
			if (listModel.getSize() == 10) break;
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
}

