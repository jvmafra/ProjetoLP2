package gui.gerente;

import gui.Sistema;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 * Mostra graficamente os servicos preferidos dos hospedes
 */
public class ServicosPreferidos extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ServicosPreferidos() {
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0, 0, 800, 600);


		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesEstatisticas());
			}
		});
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnVoltar.setBounds(344, 518, 90, 30);
		add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBounds(54, 166, 700, 310);
		add(panel);

		PieDataset dataset = criaDados();

		JFreeChart chart = criaGrafico(dataset, "Servi�os");

		ChartPanel chartPanel = new ChartPanel(chart);

		chartPanel.setPreferredSize(new java.awt.Dimension(705, 310));

		panel.add(chartPanel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadastroQuarto.class.getResource("/nucleo/icones/hotel4 feito.png")));
		lblNewLabel.setBounds(328, 25, 169, 105);
		add(lblNewLabel);

	}

	/**
	 * Cria um conjunto de dados de amostra
	 */

	private PieDataset criaDados() {
		DefaultPieDataset result = new DefaultPieDataset();
		
		
		result.setValue("Refeições", Sistema.getHotel().getRefeicoes());
		result.setValue("Massagem", Sistema.getHotel().getMassagens());
		result.setValue("Aluguel de Carro", Sistema.getHotel().getAlugueisCarro());
		result.setValue("Baby Sitter", Sistema.getHotel().getBabySitter());
		return result;

	}

	/**
	 * Cria um gráfico
	 */
	private JFreeChart criaGrafico(PieDataset dataset, String title) {

		JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true,
				true, false);

		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		return chart;

	}
}
