package gui.gerente;

import gui.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import nucleo.classes.hotel.Alugavel;
import nucleo.classes.servicos.Carro;

public class OpcoesDeCarro extends JPanel {
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
	public OpcoesDeCarro() {
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0,0,800,600);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(184, 263, 246, 244);
		add(scrollPane);
		scrollPane.setViewportView(list);
		list.setFont(new Font("Tahoma", Font.PLAIN, 13));
		list.setForeground(new Color(51, 102, 153));
		list.setModel(listModel);
		
		textField = new JTextField();
		textField.setForeground(new Color(51, 102, 153));
		textField.setFont(new Font("Dialog", Font.PLAIN, 13));
		textField.setBounds(326, 210, 157, 30);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Digite a placa do Carro:");
		lblPlaca.setForeground(new Color(255, 255, 255));
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPlaca.setBounds(177, 210, 170, 20);
		add(lblPlaca);

		for (int i = 0; i < Sistema.getHotel().getCarros().size(); i++) {
			listModel.addElement(Sistema.getHotel().getCarros().get(i));
		}
		setLayout(null);
		
		
		JButton btnEditaCarro = new JButton("Editar");
		btnEditaCarro.setForeground(new Color(51, 102, 153));
		btnEditaCarro.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnEditaCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() == null)
					JOptionPane.showMessageDialog(null,	"Selecione um carro antes");
				else{
					Sistema.setTela(new EditarCarro((Carro) list.getSelectedValue()));
				}
			}
				
		});
		btnEditaCarro.setBounds(514, 399, 90, 30);
		add(btnEditaCarro);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setForeground(new Color(51, 102, 153));
		btnNovo.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovoCarro());
			}
		});
		btnNovo.setBounds(514, 303, 90, 30);
		add(btnNovo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new OpcoesPrivadas());
			}
		});
		btnVoltar.setBounds(340, 529, 90, 30);
		add(btnVoltar);
		
		JLabel lblNewLabel2 = new JLabel("OPCOES DE CARRO");
		lblNewLabel2.setFont(new Font("Bitstream Charter", Font.BOLD, 26));
		lblNewLabel2.setForeground(new Color(255, 255, 255));
		lblNewLabel2.setBounds(310, 132, 278, 40);
		add(lblNewLabel2);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(OpcoesDeCarro.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(307, 29, 235, 105);
		add(lblNewLabel);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() == null)
					JOptionPane.showMessageDialog(null,	"Selecione um carro antes");
				else{
					Sistema.getHotel().getCarros().remove(list.getSelectedValue());
					Sistema.setTela(new OpcoesDeCarro());
				}
					
			}
		});
		btnRemover.setForeground(new Color(51, 102, 153));
		btnRemover.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnRemover.setBounds(514, 351, 90, 30);
		add(btnRemover);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listModel.clear();
				String busca = textField.getText();
				if (busca == null || busca.equals("")){
					for (int i = 0; i < Sistema.getHotel().getCarros().size(); i++) {
						listModel.addElement(Sistema.getHotel().getCarros().get(i));
					}
				} else {
					for (int i = 0; i < Sistema.getHotel().getCarros().size(); i++) {
						if (((Carro) (Sistema.getHotel().getCarros().get(i))).getPlaca().contains(busca))
							listModel.addElement(Sistema.getHotel().getCarros().get(i));
					}
				}
			}
		});
		btnBuscar.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnBuscar.setForeground(new Color(51, 102, 153));
		btnBuscar.setBounds(514, 210, 90, 30);
		add(btnBuscar);
		

	}
}