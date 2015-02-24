package gui.gerente;

import gui.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;

public class FaturamentoDoHotel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textMensal;
	private JTextField textTOTAL;
	private JButton btnVoltar;
	private JComboBox<String> list;
	private JButton btnPesqui;

	/**
	 * Create the panel.
	 */
	public FaturamentoDoHotel() {

		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0, 0, 800, 600);
		textMensal = new JTextField();
		textMensal.setBounds(398, 335, 179, 23);
		add(textMensal);
		textMensal.setColumns(10);
		
		
		JLabel lblFaturamentoMensal = new JLabel("Faturamento Mensal");
		lblFaturamentoMensal.setForeground(new Color(255, 255, 255));
		lblFaturamentoMensal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFaturamentoMensal.setBounds(199, 339, 143, 14);
		add(lblFaturamentoMensal);
		
		textTOTAL = new JTextField();
		textTOTAL.setBounds(398, 192, 179, 23);
		add(textTOTAL);
		textTOTAL.setColumns(10);
		textTOTAL.setText(String.valueOf(Sistema.getHotel().faturamentoTotal()));
		
		JLabel lblFaturamentoTotal = new JLabel("Faturamento Total");
		lblFaturamentoTotal.setForeground(new Color(255, 255, 255));
		lblFaturamentoTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFaturamentoTotal.setBounds(199, 196, 175, 14);
		add(lblFaturamentoTotal);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesEstatisticas());
			}
		});
		btnVoltar.setBounds(369, 454, 89, 23);
		add(btnVoltar);
		
		JLabel label = new JLabel(new ImageIcon(FaturamentoDoHotel.class.getResource("/nucleo/icones/hotel4.png")));
		label.setBounds(339, 31, 143, 118);
		add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(175, 272, 205, 29);
		add(scrollPane);
		list = new JComboBox<String>();
		list.setFont(new Font("Dialog", Font.PLAIN, 13));
		list.setBackground(new Color(255, 255, 255));
		list.setForeground(new Color(51, 102, 153));
		scrollPane.setViewportView(list);
		preencheLista(list);
		
		btnPesqui = new JButton("Pesquisar");
		btnPesqui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedItem() == null)
					JOptionPane.showMessageDialog(null, "Selecione um mês primeiro");
				else{
					textMensal.setText(String.valueOf(Sistema.getHotel().getFaturamentoMensal(list.getSelectedIndex())));
				}
			}
		});
		btnPesqui.setBounds(437, 276, 117, 25);
		add(btnPesqui);
		

	}
	
	private void preencheLista(JComboBox<String> listModel){
		listModel.addItem("Janeiro");
		listModel.addItem("Fevereiro");
		listModel.addItem("Março");
		listModel.addItem("Abril");
		listModel.addItem("Maio");
		listModel.addItem("Junho");
		listModel.addItem("Julho");
		listModel.addItem("Agosto");
		listModel.addItem("Setembro");
		listModel.addItem("Outubro");
		listModel.addItem("Novembro");
		listModel.addItem("Dezembro");
	}
}