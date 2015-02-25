package gui.gerente;

import gui.Sistema;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class FaturamentoDoHotel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textMensal;
	private JTextField textTOTAL;
	private JButton btnVoltar;
	private JComboBox<String> list;
	private JButton btnPesquisar;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public FaturamentoDoHotel() {

		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0, 0, 800, 600);
		textMensal = new JTextField();
		textMensal.setBounds(155, 166, 95, 23);
		add(textMensal);
		textMensal.setColumns(10);
		textMensal.setEditable(false);

		JLabel lblFaturamentoMensal = new JLabel("Faturamento Mensal");
		lblFaturamentoMensal.setForeground(new Color(255, 255, 255));
		lblFaturamentoMensal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFaturamentoMensal.setBounds(10, 168, 143, 14);
		add(lblFaturamentoMensal);

		textTOTAL = new JTextField();
		textTOTAL.setBounds(155, 130, 95, 23);
		add(textTOTAL);
		textTOTAL.setColumns(10);
		textTOTAL
				.setText(String.valueOf(Sistema.getHotel().faturamentoTotal()));
		textTOTAL.setEditable(false);

		JLabel lblFaturamentoTotal = new JLabel("Faturamento Total");
		lblFaturamentoTotal.setForeground(new Color(255, 255, 255));
		lblFaturamentoTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFaturamentoTotal.setBounds(21, 132, 175, 14);
		add(lblFaturamentoTotal);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesEstatisticas());
			}
		});
		btnVoltar.setBounds(372, 531, 89, 23);
		add(btnVoltar);

		JLabel label = new JLabel(new ImageIcon(
				FaturamentoDoHotel.class
						.getResource("/nucleo/icones/hotel4.png")));
		label.setBounds(339, 11, 143, 118);
		add(label);
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null,
							"Selecione um mês primeiro");
				} else {
					textMensal.setText(String.valueOf(Sistema.getHotel()
							.getFaturamentoMensal(list.getSelectedIndex())));
				}
			}
		});
		btnPesquisar.setBounds(501, 168, 117, 25);
		add(btnPesquisar);

		list = new JComboBox<String>();
		list.setBounds(451, 127, 203, 27);
		add(list);
		list.setFont(new Font("Dialog", Font.PLAIN, 13));
		list.setBackground(new Color(255, 255, 255));
		list.setForeground(new Color(51, 102, 153));
		preencheLista(list);

		panel = new JPanel();
		panel.setBounds(41, 210, 700, 310);
		add(panel);

		CategoryDataset dataset = criaInformacoes();

		JFreeChart chart = criaGrafico(dataset, "Faturamento Anual");

		ChartPanel chartPanel = new ChartPanel(chart);

		chartPanel.setPreferredSize(new java.awt.Dimension(705, 310));

		panel.add(chartPanel);

	}

	private JFreeChart criaGrafico(CategoryDataset dataset, String title) {

		JFreeChart c = ChartFactory.createBarChart3D(title, "", "", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		return c;

	}

	private CategoryDataset criaInformacoes() {
		DefaultCategoryDataset result = new DefaultCategoryDataset();
		for (int i = 0; i < 12; i++) {
			result.addValue(Sistema.getHotel().getFaturamentoMensal(i),
					list.getItemAt(i), "Faturamento");
		}
		return result;

	}

	private void preencheLista(JComboBox<String> listModel) {
		listModel.addItem("Janeiro");
		listModel.addItem("Fevereiro");
		listModel.addItem("Marco");
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