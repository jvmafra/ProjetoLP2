package gui.contratos;

import excecoes.EntradaDeDadosException;
import gui.Sistema;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import classes.FormasCobranca.EstrategiaAltaTemporada;
import classes.FormasCobranca.EstrategiaBaixaTemporada;
import classes.FormasCobranca.EstrategiaCobranca;
import classes.FormasCobranca.EstrategiaNatalReveillon;
import classes.FormasCobranca.EstrategiaSaoJoao;
import classes.FormasCobranca.EstrategiaSimples;
import classes.HotelOpiniaoServicosPeriodo.Periodo;
import classes.Pessoa.Contrato;
import classes.Pessoa.Hospede;
import classes.Quartos.Quarto;
import java.awt.Color;

public class NovoContrato extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JSpinner data_inicial;
	JSpinner data_final;
	JList<Quarto> list;
	private final Action action = new SwingAction();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoContrato frame = new NovoContrato();
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
	public NovoContrato() {

		MaskFormatter format = null;
		setLayout(null);
		setBounds(0, 0, 800, 600);

		JPanel margemGeral = new JPanel();
		margemGeral.setBackground(Color.WHITE);
		margemGeral.setBounds(0, 0, 800, 600);
		add(margemGeral);
		margemGeral.setLayout(null);

		JPanel DadosHospedes = new JPanel();
		DadosHospedes.setBackground(Color.WHITE);
		DadosHospedes.setBounds(13, 14, 771, 142);
		margemGeral.add(DadosHospedes);
		DadosHospedes.setBorder(new TitledBorder(null, "Numeros de hospede.",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		DadosHospedes.setLayout(null);
		
		
		// Lista de Hospedes.
		DefaultListModel<Hospede> listMode2 = new DefaultListModel<Hospede>();
		for (int i = 0; i < Sistema.getHotel().getHospedes().size(); i++) {
			listMode2.addElement(Sistema.getHotel().getHospedes().get(i));
		}
		setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(88, 29, 368, 83);
		//verificar
		DadosHospedes.add(scrollPane_2);
		
		
		JList<Hospede> list_2 = new JList<Hospede>();
		list_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_2.setModel(listMode2);
		
				
		scrollPane_2.setViewportView(list_2);
		
		
		
		try {
			format = new MaskFormatter("###.###.###-##");
			format.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			format = new MaskFormatter("#######");
			format.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			format = new MaskFormatter("####.####.####.####");
			format.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JPanel EstrategiasPagamento = new JPanel();
		EstrategiasPagamento.setBackground(Color.WHITE);
		EstrategiasPagamento.setBounds(409, 228, 311, 160);
		margemGeral.add(EstrategiasPagamento);
		EstrategiasPagamento.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Estrategia de Cobranca",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		EstrategiasPagamento.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 23, 259, 126);
		EstrategiasPagamento.add(scrollPane_1);

		DefaultListModel<EstrategiaCobranca> lista = new DefaultListModel<EstrategiaCobranca>();
		EstrategiaCobranca e1 = new EstrategiaAltaTemporada();
		EstrategiaCobranca e2 = new EstrategiaSimples();
		EstrategiaCobranca e3 = new EstrategiaSaoJoao(true);
		EstrategiaCobranca e4 = new EstrategiaBaixaTemporada();
		EstrategiaCobranca e5 = new EstrategiaNatalReveillon();
		lista.addElement(e1);
		lista.addElement(e5);
		lista.addElement(e4);
		lista.addElement(e3);
		lista.addElement(e2);

		JList<EstrategiaCobranca> list_1 = new JList<EstrategiaCobranca>();
		EstrategiasPagamento.add(list_1);
		list_1.setBounds(29, 24, 257, 62);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		list_1.setModel(lista);

		JPanel quartosDisponiveis = new JPanel();
		quartosDisponiveis.setBackground(Color.WHITE);
		quartosDisponiveis.setBounds(13, 196, 299, 343);
		margemGeral.add(quartosDisponiveis);
		quartosDisponiveis.setBorder(new TitledBorder(null,
				"Quartos disponiveis.", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		quartosDisponiveis.setLayout(null);

		data_inicial = new JSpinner();
		data_inicial.setBounds(99, 32, 188, 20);
		data_inicial.setModel(new SpinnerDateModel(new Date(1423018800000L),
				new Date(1423018800000L), null, Calendar.DAY_OF_YEAR));
		quartosDisponiveis.add(data_inicial);

		data_final = new JSpinner();
		data_final.setBounds(99, 64, 188, 20);
		data_final.setModel(new SpinnerDateModel(new Date(1423018800000L),
				new Date(1423018800000L), null, Calendar.DAY_OF_YEAR));
		quartosDisponiveis.add(data_final);

		JLabel lblDataInicial = new JLabel("Inicio");
		lblDataInicial.setBounds(12, 34, 70, 15);
		quartosDisponiveis.add(lblDataInicial);

		JLabel lblDataFinal = new JLabel("Final");
		lblDataFinal.setBounds(12, 66, 70, 15);
		quartosDisponiveis.add(lblDataFinal);
		
		// Instancia o scrollPane que contem o jList
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(243, 197);
		scrollPane.setLocation(30, 134);
				
		// Intancio o jList que contem os quartos
		list = new JList<Quarto>();
		final DefaultListModel<Quarto> listModel = new DefaultListModel<Quarto>();
		quartosDisponiveis.add(scrollPane);
		list.setBounds(30, 134, 243, 100);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date data = (Date) data_inicial.getValue();
				Date data2 = (Date) data_final.getValue();
				Calendar inicio = Sistema.DateToCalendar(data);
				Calendar fim = Sistema.DateToCalendar(data2);
				try {
					Periodo p = new Periodo(inicio, fim);
					for (int i = 0; i < Sistema.getHotel().getQuartos().size(); i++) {
						listModel.addElement(Sistema.getHotel().getQuartos().get(i));		
					}
					
				} catch (Exception e2) {
					listModel.clear();
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		
		list.setModel(listModel);
		scrollPane.setViewportView(list);
		btnPesquisar.setBounds(109, 96, 117, 25);
		quartosDisponiveis.add(btnPesquisar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeContrato());
			}
		});
		// btnVoltar.setAction(action_1);
		btnVoltar.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		btnVoltar.setBounds(375, 471, 94, 25);
		margemGeral.add(btnVoltar);
		
		JButton btnNewButton = new JButton("Concluir");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(573, 473, 89, 23);
		margemGeral.add(btnNewButton);

		
		
	}	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Concluir");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Hospede criado!");

		}
	}
}