package gui.gerente;

import gui.Sistema;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import nucleo.classes.formas_cobranca.Estrategia;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class OpcoesDeEstrategia extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<Estrategia> list;

	/**
	 * Create the panel.
	 */
	public OpcoesDeEstrategia() {
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0, 0, 800, 600);
		JButton btnNovaEstrategia = new JButton("Nova");
		btnNovaEstrategia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovaEstrategia());
			}
		});
		btnNovaEstrategia.setForeground(new Color(51, 102, 153));
		btnNovaEstrategia.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNovaEstrategia.setBounds(526, 345, 106, 33);
		add(btnNovaEstrategia);

		JButton btnEditaEstrategia = new JButton("Editar");
		btnEditaEstrategia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() == null)
					JOptionPane.showMessageDialog(null,	"Selecione uma estratégia antes");
				else
					Sistema.setTela(new EditaEstrategia(list.getSelectedValue()));
			}
		});
		btnEditaEstrategia.setForeground(new Color(51, 102, 153));
		btnEditaEstrategia.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnEditaEstrategia.setBounds(526, 203, 106, 33);
		add(btnEditaEstrategia);
		
		JButton btnRemoveEstrategia = new JButton("Remover");
		btnRemoveEstrategia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() == null)
					JOptionPane.showMessageDialog(null,	"Selecione uma estratégia antes");
				else{
					Sistema.getHotel().removeEstrategia(list.getSelectedValue());
					//repaint();
					revalidate();
				}
			}
		});
		btnRemoveEstrategia.setForeground(new Color(51, 102, 153));
		btnRemoveEstrategia.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnRemoveEstrategia.setBounds(526, 273, 106, 33);
		add(btnRemoveEstrategia);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesPrivadas());
			}
		});
		btnVoltar.setBounds(359, 515, 89, 23);
		add(btnVoltar);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(130, 200, 335, 204);
		add(scrollPane);

		list = new JList<Estrategia>();
		list.setBackground(new Color(51, 102, 153));
		list.setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(list);
		final DefaultListModel<Estrategia> listModel = new DefaultListModel<Estrategia>();

		for (int i = 0; i < Sistema.getHotel().getEstrategias().size(); i++) {
			listModel.addElement(Sistema.getHotel().getEstrategias().get(i));
			}
		list.setModel(listModel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(OpcoesDeEstrategia.class.getResource("/nucleo/icones/hotel4.png")));
		label.setBounds(338, 12, 221, 120);
		add(label);

	}
}