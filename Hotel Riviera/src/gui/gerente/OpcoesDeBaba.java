package gui.gerente;

import gui.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import nucleo.classes.hotel.Alugavel;
import nucleo.classes.servicos.Baba;

public class OpcoesDeBaba extends JPanel {
	private JTextField textField;
	private JList<Alugavel> list = new JList<Alugavel>();
	private DefaultListModel<Alugavel> listModel = new DefaultListModel<Alugavel>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public OpcoesDeBaba() {
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0,0,800,600);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(188, 275, 246, 244);
		add(scrollPane);
		list.setFont(new Font("Dialog", Font.PLAIN, 13));
		list.setForeground(new Color(51, 102, 153));
		
		scrollPane.setViewportView(list);
		list.setModel(listModel);
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 13));
		textField.setForeground(new Color(51, 102, 153));
		textField.setBounds(225, 212, 277, 30);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Digite o nome da Baba:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(188, 185, 170, 25);
		add(lblNewLabel);
		
		for (Alugavel baba: Sistema.getHotel().getBabas()) {
			listModel.addElement(baba);
		}
		setLayout(null);
		
		
		
		JButton btnEditaBab = new JButton("Editar");
		btnEditaBab.setForeground(new Color(51, 102, 153));
		btnEditaBab.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnEditaBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() == null)
					JOptionPane.showMessageDialog(null,	"Selecione uma Bab� antes");
				else{
					Sistema.setTela(new EditaBaba((Baba) list.getSelectedValue()));
				}
			}
		});
		btnEditaBab.setBounds(510, 415, 100, 30);
		add(btnEditaBab);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new OpcoesPrivadas());
			}
		});
		btnVoltar.setBounds(414, 544, 90, 30);
		add(btnVoltar);
		
		JButton btnNewButton = new JButton("Nova");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovaBaba());
			}
		});
		btnNewButton.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnNewButton.setForeground(new Color(51, 102, 153));
		btnNewButton.setBounds(510, 306, 100, 30);
		add(btnNewButton);
		
		JLabel lblLabel = new JLabel("OPCOES DE BABA");
		lblLabel.setFont(new Font("Bitstream Charter", Font.BOLD, 26));
		lblLabel.setForeground(new Color(255, 255, 255));
		lblLabel.setBounds(289, 134, 278, 40);
		add(lblLabel);
		
		JLabel label = new JLabel(new ImageIcon(OpcoesDeBaba.class.getResource("/nucleo/icones/hotel4 feito.png")));
		label.setBounds(325, 24, 151, 98);
		add(label);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() == null)
					JOptionPane.showMessageDialog(null,	"Selecione uma Bab� antes");
				else{
					Sistema.getHotel().removeBaba((Baba) list.getSelectedValue());
					Sistema.setTela(new OpcoesDeBaba());
				}
			}
		});
		btnRemover.setForeground(new Color(51, 102, 153));
		btnRemover.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnRemover.setBounds(510, 359, 100, 30);
		add(btnRemover);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.clear();
				String busca = textField.getText();
				if (busca == null || busca.equals("")){
					for (int i = 0; i < Sistema.getHotel().getBabas().size(); i++) {
						listModel.addElement(Sistema.getHotel().getBabas().get(i));
					}
				} else {
					for (int i = 0; i < Sistema.getHotel().getBabas().size(); i++) {
						if (((Baba) (Sistema.getHotel().getBabas().get(i))).getNome().contains(busca))
							listModel.addElement(Sistema.getHotel().getBabas().get(i));
					}
				}
			}
		});
		btnBuscar.setForeground(new Color(51, 102, 153));
		btnBuscar.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnBuscar.setBounds(558, 212, 90, 30);
		add(btnBuscar);
		

	}
}