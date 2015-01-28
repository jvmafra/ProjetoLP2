package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
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
import java.util.GregorianCalendar;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import classes.Periodo;

public class DadosDaReserva extends JFrame {

	private JPanel botao_avancar;
	private JTextField numCartao;
	private JSpinner dataInicial;
	private JSpinner dataFinal;
	private final Action action = new SwingAction();

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
		botao_avancar = new JPanel();
		botao_avancar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(botao_avancar);
		
		numCartao = new JTextField();
		numCartao.setColumns(10);
		
		JLabel lblNmeroDoCarto = new JLabel("N\u00FAmero do cart\u00E3o");
		lblNmeroDoCarto.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JLabel lblPerodo = new JLabel("Per\u00EDodo:");
		lblPerodo.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		dataInicial = new JSpinner();
		dataInicial.setModel(new SpinnerDateModel(new Date(1422237600000L), new Date(1422237600000L), null, Calendar.DAY_OF_YEAR));
		
		dataFinal = new JSpinner();
		dataFinal.setModel(new SpinnerDateModel(new Date(1422237600000L), new Date(1422237600000L), null, Calendar.DAY_OF_YEAR));
		
		JLabel lblIncio = new JLabel("In\u00EDcio");
		
		JLabel lblFim = new JLabel("Fim");
		
		JLabel lblEstratgiaDeCobrana = new JLabel("Estrat\u00E9gia de cobran\u00E7a");
		lblEstratgiaDeCobrana.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JRadioButton rdbtnAltaTemporada = new JRadioButton("Alta temporada");
		
		JRadioButton rdbtnBaixaTemporada = new JRadioButton("Baixa temporada");
		
		JRadioButton rdbtnNatalrveillon = new JRadioButton("Natal/R\u00E9veillon");
		
		JRadioButton rdbtnSoJoo = new JRadioButton("S\u00E3o Jo\u00E3o");
		
		JRadioButton rdbtnSimples = new JRadioButton("Simples");
		
		
		JButton btnAvanar = new JButton("Avan\u00E7ar");
		btnAvanar.setAction(action);
		GroupLayout gl_botao_avancar = new GroupLayout(botao_avancar);
		gl_botao_avancar.setHorizontalGroup(
			gl_botao_avancar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_botao_avancar.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
					.addGroup(gl_botao_avancar.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPerodo)
						.addGroup(gl_botao_avancar.createSequentialGroup()
							.addComponent(lblNmeroDoCarto)
							.addGap(18)
							.addComponent(numCartao, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
					.addGap(114))
				.addGroup(gl_botao_avancar.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_botao_avancar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_botao_avancar.createSequentialGroup()
							.addGroup(gl_botao_avancar.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnAltaTemporada)
								.addComponent(rdbtnBaixaTemporada))
							.addGap(32)
							.addGroup(gl_botao_avancar.createParallelGroup(Alignment.TRAILING)
								.addComponent(rdbtnNatalrveillon, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnSoJoo, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
							.addComponent(rdbtnSimples, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addGap(55))
						.addGroup(gl_botao_avancar.createSequentialGroup()
							.addGroup(gl_botao_avancar.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEstratgiaDeCobrana)
								.addComponent(lblIncio)
								.addComponent(lblFim))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_botao_avancar.createParallelGroup(Alignment.LEADING)
								.addComponent(dataInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(dataFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(158, Short.MAX_VALUE))))
				.addGroup(gl_botao_avancar.createSequentialGroup()
					.addContainerGap(366, Short.MAX_VALUE)
					.addComponent(btnAvanar)
					.addGap(29))
		);
		gl_botao_avancar.setVerticalGroup(
			gl_botao_avancar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_botao_avancar.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_botao_avancar.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNmeroDoCarto)
						.addComponent(numCartao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addComponent(lblPerodo)
					.addGap(10)
					.addGroup(gl_botao_avancar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIncio)
						.addComponent(dataInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_botao_avancar.createParallelGroup(Alignment.BASELINE)
						.addComponent(dataFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFim))
					.addGap(44)
					.addComponent(lblEstratgiaDeCobrana)
					.addGap(18)
					.addGroup(gl_botao_avancar.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnAltaTemporada)
						.addComponent(rdbtnSimples)
						.addComponent(rdbtnNatalrveillon))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_botao_avancar.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnBaixaTemporada)
						.addComponent(rdbtnSoJoo))
					.addPreferredGap(ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
					.addComponent(btnAvanar)
					.addContainerGap())
		);
		botao_avancar.setLayout(gl_botao_avancar);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Avançar");
			putValue(SHORT_DESCRIPTION, "Botão avançar");
		}
		public void actionPerformed(ActionEvent e) {
			Date data1 = (Date) dataInicial.getValue();
			Calendar data_inicial = DateToCalendar(data1);
			Date data2 = (Date) dataFinal.getValue();
			Calendar data_final = DateToCalendar(data2);
			try {
				Periodo p = new Periodo(data_inicial, data_final);
				JOptionPane.showMessageDialog(null, "Datas conferem!");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	}
	
	public static Calendar DateToCalendar(Date date) { 
		 Calendar cal = null;
		 cal= new GregorianCalendar();
		 cal.setTime(date);  
		 return cal;
	 }
}
