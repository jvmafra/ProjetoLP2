package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JRadioButton;

public class DadosDaReserva extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DadosDaReserva frame = new DadosDaReserva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DadosDaReserva() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DadosDaReserva.class.getResource("/icones/hotel22.png")));
		setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		setTitle("Dados da reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNmeroDoCarto = new JLabel("N\u00FAmero do cart\u00E3o");
		lblNmeroDoCarto.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JLabel lblPerodo = new JLabel("Per\u00EDodo:");
		lblPerodo.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerDateModel(new Date(1422237600000L), new Date(1422237600000L), null, Calendar.DAY_OF_YEAR));
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerDateModel(new Date(1422237600000L), new Date(1422237600000L), null, Calendar.DAY_OF_YEAR));
		
		JLabel lblIncio = new JLabel("In\u00EDcio");
		
		JLabel lblFim = new JLabel("Fim");
		
		JLabel lblEstratgiaDeCobrana = new JLabel("Estrat\u00E9gia de cobran\u00E7a");
		lblEstratgiaDeCobrana.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JRadioButton rdbtnAltaTemporada = new JRadioButton("Alta temporada");
		
		JRadioButton rdbtnBaixaTemporada = new JRadioButton("Baixa temporada");
		
		JRadioButton rdbtnNatalrveillon = new JRadioButton("Natal/R\u00E9veillon");
		
		JRadioButton rdbtnSoJoo = new JRadioButton("S\u00E3o Jo\u00E3o");
		
		JRadioButton rdbtnSimples = new JRadioButton("Simples");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPerodo)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNmeroDoCarto)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
					.addGap(114))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnAltaTemporada)
								.addComponent(rdbtnBaixaTemporada))
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(rdbtnNatalrveillon, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnSoJoo, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
							.addComponent(rdbtnSimples, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addGap(55))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEstratgiaDeCobrana)
								.addComponent(lblIncio)
								.addComponent(lblFim))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(155, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNmeroDoCarto)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addComponent(lblPerodo)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIncio)
						.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFim))
					.addGap(44)
					.addComponent(lblEstratgiaDeCobrana)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnAltaTemporada)
						.addComponent(rdbtnSimples)
						.addComponent(rdbtnNatalrveillon))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnBaixaTemporada)
						.addComponent(rdbtnSoJoo))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
