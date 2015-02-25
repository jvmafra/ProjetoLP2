package gui.contratos;

import gui.Sistema;
import gui.hospede.NovoHospede;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import nucleo.classes.formas_cobranca.Estrategia;
import nucleo.classes.hotel.Alugavel;
import nucleo.classes.hotel.Periodo;
import nucleo.classes.pessoa.Contrato;
import nucleo.classes.pessoa.Hospede;
import nucleo.classes.quartos.Quarto;

public class NovoContrato extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JSpinner data_inicial;
	JSpinner data_final;
	JList<Alugavel> list;
	JList<Hospede> list_2;
	DefaultListModel<Alugavel> listModel;
	JComboBox<Estrategia> estrategias;


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

		setLayout(null);
		setBounds(0, 0, 800, 600);

		JPanel margemGeral = new JPanel();
		margemGeral.setBackground(new Color(51, 102, 153));
		margemGeral.setBounds(0, 0, 800, 600);
		add(margemGeral);
		margemGeral.setLayout(null);

		JPanel DadosHospedes = new JPanel();
		DadosHospedes.setForeground(new Color(255, 255, 255));
		DadosHospedes.setBackground(new Color(51, 102, 153));
		DadosHospedes.setBounds(10, 11, 771, 142);
		margemGeral.add(DadosHospedes);
		DadosHospedes.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Hospedes do hotel", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		DadosHospedes.setLayout(null);
		
		
		// Lista de Hospedes.
		DefaultListModel<Hospede> listMode2 = new DefaultListModel<Hospede>();
		for (int i = 0; i < Sistema.getHotel().getHospedes().size(); i++) {
			listMode2.addElement(Sistema.getHotel().getHospedes().get(i));
		}
		setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(35, 29, 437, 101);
		//verificar
		DadosHospedes.add(scrollPane_2);
		
		
		list_2 = new JList<Hospede>();
		list_2.setFont(new Font("Dialog", Font.PLAIN, 13));
		list_2.setBackground(new Color(51, 102, 153));
		list_2.setForeground(new Color(255, 255, 255));
		list_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_2.setModel(listMode2);
		
				
		scrollPane_2.setViewportView(list_2);
		
		JButton btnNovoHospede = new JButton("NOVO HOSPEDE");
		btnNovoHospede.setForeground(new Color(51, 102, 153));
		btnNovoHospede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovoHospede(true));
			}
		});
		btnNovoHospede.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNovoHospede.setBounds(505, 62, 179, 25);
		DadosHospedes.add(btnNovoHospede);

		JPanel EstrategiasPagamento = new JPanel();
		EstrategiasPagamento.setBackground(new Color(51, 102, 153));
		EstrategiasPagamento.setBounds(422, 196, 304, 89);
		margemGeral.add(EstrategiasPagamento);
		EstrategiasPagamento.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Estrategia de Cobranca", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		EstrategiasPagamento.setLayout(null);
		
		estrategias = new JComboBox<Estrategia>();
		estrategias.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		estrategias.setForeground(new Color(51, 102, 153));
		estrategias.setBackground(Color.WHITE);
		estrategias.setBounds(25, 31, 257, 26);
		for (Estrategia estrategia: Sistema.getHotel().getEstrategias()){
			estrategias.addItem(estrategia);
		}
		EstrategiasPagamento.add(estrategias);
		


		JPanel quartosDisponiveis = new JPanel();
		quartosDisponiveis.setBackground(new Color(51, 102, 153));
		quartosDisponiveis.setBounds(13, 196, 299, 372);
		margemGeral.add(quartosDisponiveis);
		quartosDisponiveis.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Quartos disponiveis.", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		quartosDisponiveis.setLayout(null);

		data_inicial = new JSpinner();
		data_inicial.setFont(new Font("NanumGothic", Font.PLAIN, 13));
		data_inicial.setBounds(99, 32, 188, 20);
		data_inicial.setModel(new SpinnerDateModel());
		quartosDisponiveis.add(data_inicial);

		data_final = new JSpinner();
		data_final.setFont(new Font("NanumGothic", Font.PLAIN, 13));
		data_final.setBounds(99, 64, 188, 20);
		data_final.setModel(new SpinnerDateModel());
		quartosDisponiveis.add(data_final);

		JLabel lblDataInicial = new JLabel("Inicio");
		lblDataInicial.setForeground(new Color(255, 255, 255));
		lblDataInicial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataInicial.setBounds(39, 34, 70, 15);
		quartosDisponiveis.add(lblDataInicial);

		JLabel lblDataFinal = new JLabel("Final");
		lblDataFinal.setForeground(new Color(255, 255, 255));
		lblDataFinal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataFinal.setBounds(39, 66, 70, 15);
		quartosDisponiveis.add(lblDataFinal);
		
		// Instancia o scrollPane que contem o jList
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(243, 197);
		scrollPane.setLocation(30, 134);
				
		// Intancio o jList que contem os quartos
		list = new JList<Alugavel>();
		list.setFont(new Font("Dialog", Font.PLAIN, 12));
		list.setForeground(new Color(255, 255, 255));
		list.setBackground(new Color(51, 102, 153));
		listModel = new DefaultListModel<Alugavel>();
		quartosDisponiveis.add(scrollPane);
		list.setBounds(30, 134, 243, 100);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JButton btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.setForeground(new Color(51, 102, 153));
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date data = (Date) data_inicial.getValue();
				Date data2 = (Date) data_final.getValue();
				Calendar inicio = Sistema.DateToCalendar(data);
				Calendar fim = Sistema.DateToCalendar(data2);
				try {
					Periodo p = new Periodo(inicio, fim);
					List<Alugavel> quartos_disponiveis = Sistema.getHotel().verificaAlugaveisDisponiveis(p, Sistema.getHotel().getQuartos());
					for (int i = 0; i < quartos_disponiveis.size(); i++) {
						listModel.addElement(quartos_disponiveis.get(i));
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
				
			}
		});
		list.setModel(listModel);
		scrollPane.setViewportView(list);
		btnPesquisar.setBounds(109, 96, 129, 25);
		quartosDisponiveis.add(btnPesquisar);
		
		JCheckBox chckbxCamaExtra = new JCheckBox("Cama extra");
		chckbxCamaExtra.setFont(new Font("Dialog", Font.PLAIN, 13));
		chckbxCamaExtra.setForeground(new Color(255, 255, 255));
		chckbxCamaExtra.setBackground(new Color(51, 102, 153));
		chckbxCamaExtra.setBounds(144, 339, 143, 23);
		quartosDisponiveis.add(chckbxCamaExtra);
		Quarto q = (Quarto) list.getSelectedValue();
		if (q != null) {
			if (q.permiteCamaExtra())
				chckbxCamaExtra.setVisible(true);
			else
				chckbxCamaExtra.setVisible(false);
				
		}
		else
			chckbxCamaExtra.setVisible(false);
		

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeContrato());
			}
		});
		// btnVoltar.setAction(action_1);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(422, 503, 94, 25);
		margemGeral.add(btnVoltar);
		
		JButton btnNewButton = new JButton("Concluir");
		btnNewButton.setForeground(new Color(51, 102, 153));
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date data = (Date) data_inicial.getValue();
				Date data2 = (Date) data_final.getValue();
				Calendar inicio = Sistema.DateToCalendar(data);
				Calendar fim = Sistema.DateToCalendar(data2);
				try {
					Periodo p = new Periodo(inicio, fim);
					Alugavel obj = list.getSelectedValue();
					Quarto quarto = (Quarto) obj;
					Hospede h = list_2.getSelectedValue();
					Estrategia estrategia = (Estrategia) estrategias.getSelectedItem();
					Contrato contrato = new Contrato(quarto, h, estrategia, p);
					Sistema.getHotel().check_in(contrato);
					JOptionPane.showMessageDialog(null, "Contrato adicionado");
					Sistema.setTela(new OpcoesDeContrato());
				} catch (Exception e6) {
					JOptionPane.showMessageDialog(null, e6.getMessage());
				}
			}
		});
		btnNewButton.setBounds(617, 503, 109, 25);
		margemGeral.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NovoContrato.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(505, 317, 175, 142);
		margemGeral.add(lblNewLabel);

		
		
	}	
}