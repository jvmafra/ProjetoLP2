package gui.contratos;

import gui.PaginaInicialHotel;
import gui.Sistema;
import gui.hospede.OpcoesDoHospede;
import gui.hospede.SelecaoQuartos;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import classes.FormasCobranca.EstrategiaAltaTemporada;
import classes.FormasCobranca.EstrategiaBaixaTemporada;
import classes.FormasCobranca.EstrategiaCobranca;
import classes.FormasCobranca.EstrategiaNatalReveillon;
import classes.FormasCobranca.EstrategiaSaoJoao;
import classes.FormasCobranca.EstrategiaSimples;
import classes.HotelOpiniaoServicosPeriodo.Hotel;
import classes.Pessoa.Hospede;
import classes.Quartos.Quarto;

import javax.swing.UIManager;

public class NovoContrato extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nome;
	private JFormattedTextField cpf;
	private JTextField rg;
	private JTextField telefone;
	private JTextField email;
	private JTextField endereco;
	private final Action action = new SwingAction();
	private JFormattedTextField numCartao;

	private final Action action_1 = new SwingAction_1();

	Hotel hotel = new Hotel();

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
		margemGeral.setBounds(0, 0, 800, 600);
		add(margemGeral);
		margemGeral.setLayout(null);

		JPanel DadosHospedes = new JPanel();
		DadosHospedes.setBounds(13, 14, 771, 142);
		margemGeral.add(DadosHospedes);
		DadosHospedes.setBorder(new TitledBorder(null, "Dados do hospede.",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		DadosHospedes.setLayout(null);

		JLabel nome_1 = new JLabel("Nome");
		nome_1.setBounds(12, 20, 39, 12);
		DadosHospedes.add(nome_1);
		nome_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));

		nome = new JTextField();
		nome.setBounds(72, 18, 657, 20);
		DadosHospedes.add(nome);
		nome.setColumns(10);

		JLabel cpf_1 = new JLabel("CPF");
		cpf_1.setBounds(22, 51, 28, 18);
		DadosHospedes.add(cpf_1);
		cpf_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		try {
			format = new MaskFormatter("###.###.###-##");
			format.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cpf = new JFormattedTextField(format);
		cpf.setBounds(71, 51, 150, 20);
		DadosHospedes.add(cpf);
		cpf.setColumns(10);

		JLabel email_1 = new JLabel("E-mail");
		email_1.setBounds(292, 110, 44, 18);
		DadosHospedes.add(email_1);
		email_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));

		email = new JTextField();
		email.setBounds(360, 111, 369, 20);
		DadosHospedes.add(email);
		email.setColumns(10);
		try {
			format = new MaskFormatter("#######");
			format.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		rg = new JFormattedTextField(format);
		rg.setBounds(71, 82, 150, 20);
		DadosHospedes.add(rg);
		rg.setColumns(10);

		JLabel rg_1 = new JLabel("RG");
		rg_1.setBounds(29, 84, 22, 18);
		DadosHospedes.add(rg_1);
		rg_1.setFont(new Font("Dialog", Font.PLAIN, 14));

		telefone = new JTextField();
		telefone.setBounds(360, 52, 150, 20);
		DadosHospedes.add(telefone);
		telefone.setColumns(10);

		JLabel telefone_1 = new JLabel("Telefone");
		telefone_1.setBounds(274, 51, 62, 18);
		DadosHospedes.add(telefone_1);
		telefone_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));

		endereco = new JTextField();
		endereco.setBounds(360, 80, 369, 20);
		DadosHospedes.add(endereco);
		endereco.setColumns(10);

		JLabel endereco_1 = new JLabel("Endere\u00E7o");
		endereco_1.setBounds(274, 87, 62, 13);
		DadosHospedes.add(endereco_1);
		endereco_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));

		JLabel lblCarto = new JLabel("Cartao");
		lblCarto.setBounds(12, 110, 49, 18);
		DadosHospedes.add(lblCarto);
		lblCarto.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		try {
			format = new MaskFormatter("####.####.####.####");
			format.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		numCartao = new JFormattedTextField(format);
		numCartao.setBounds(72, 111, 152, 19);
		DadosHospedes.add(numCartao);
		numCartao.setColumns(10);

		JPanel EstrategiasPagamento = new JPanel();
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
		quartosDisponiveis.setBounds(12, 168, 299, 343);
		margemGeral.add(quartosDisponiveis);
		quartosDisponiveis.setBorder(new TitledBorder(null,
				"Quartos disponiveis.", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		quartosDisponiveis.setLayout(null);

		JSpinner Data_inicial = new JSpinner();
		Data_inicial.setBounds(99, 32, 188, 20);
		Data_inicial.setModel(new SpinnerDateModel(new Date(1423018800000L),
				new Date(1423018800000L), null, Calendar.DAY_OF_YEAR));
		quartosDisponiveis.add(Data_inicial);

		JSpinner Data_final = new JSpinner();
		Data_final.setBounds(99, 64, 188, 20);
		Data_final.setModel(new SpinnerDateModel(new Date(1423018800000L),
				new Date(1423018800000L), null, Calendar.DAY_OF_YEAR));
		quartosDisponiveis.add(Data_final);

		JLabel inicio = new JLabel("Inicio");
		inicio.setBounds(12, 34, 70, 15);
		quartosDisponiveis.add(inicio);

		JLabel lblFinal = new JLabel("Final");
		lblFinal.setBounds(12, 66, 70, 15);
		quartosDisponiveis.add(lblFinal);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(109, 96, 117, 25);
		quartosDisponiveis.add(btnPesquisar);

		// Intancio o jList que contem os quartos
		JList<Quarto> list = new JList<Quarto>();
		list.setBounds(30, 134, 243, 100);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Instancia o scrollPane que contem o jList
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(243, 197);
		scrollPane.setLocation(30, 134);
		scrollPane.setViewportView(list);
		quartosDisponiveis.add(scrollPane);

		// Adiciona os quartos disponíveis no jList
		DefaultListModel<Quarto> listModel = new DefaultListModel<Quarto>();
		for (int i = 0; i < hotel.getQuartos().size(); i++) {
			listModel.addElement(hotel.getQuartos().get(i));
		}
		list.setModel(listModel);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDoHospede());
			}
		});
		// btnVoltar.setAction(action_1);
		btnVoltar.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		btnVoltar.setBounds(375, 471, 94, 25);
		margemGeral.add(btnVoltar);

		JButton concluir = new JButton("Concluir");
		concluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

			}
		});
		concluir.setBounds(639, 469, 94, 28);
		margemGeral.add(concluir);
		concluir.setAction(action);
		concluir.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));

		JButton limpar = new JButton("Limpar");
		limpar.setBounds(501, 471, 100, 25);
		margemGeral.add(limpar);
		limpar.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nome.setText("");
				cpf.setText("");
				rg.setText("");
				telefone.setText("");
				email.setText("");
				endereco.setText("");
			}
		});

		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				concluir, limpar, telefone_1, telefone, nome_1, cpf_1, rg_1,
				email_1, rg, email, nome, cpf, endereco_1, numCartao, endereco,
				lblCarto }));

	}

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction() {
			putValue(NAME, "Concluir");
			putValue(SHORT_DESCRIPTION, "Cadastro de hospede");
		}

		public void actionPerformed(ActionEvent e) {
			try {
				Hospede hospede = new Hospede(nome.getText(), cpf.getText()
						.replace(".", "").replace("-", ""), rg.getText()
						.replace(".", ""), "18", email.getText(),
						telefone.getText(), endereco.getText(), numCartao
								.getText().replace(".", ""));
				Sistema.getHotel().adicionaHospede(hospede);
				JOptionPane.showMessageDialog(null, "Hospede criado!");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	}

	private class SwingAction_1 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_1() {
			putValue(NAME, "Voltar");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			PaginaInicialHotel frame = new PaginaInicialHotel();
			frame.setVisible(true);
			setVisible(false);
		}
	}
}