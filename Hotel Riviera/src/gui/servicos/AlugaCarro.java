package gui.servicos;

import gui.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JScrollPane;
import javax.swing.JList;

import classes.Carro.AluguelCarro;
import classes.Carro.Carro;
import classes.HotelOpiniaoServicosPeriodo.Alugavel;
import classes.HotelOpiniaoServicosPeriodo.Periodo;
import classes.Pessoa.Contrato;

import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;


public class AlugaCarro extends JPanel {
	private Contrato contrato;
	JSpinner data_inicial;
	JSpinner data_final;
	DefaultListModel<Alugavel> listModel;
	JList<Alugavel> list;
	JCheckBox seguro, tanque;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * 
	 * 
	 * a tela de aluguel tem que selecionar 
	 * um carro da lista de carros disponiveis 
	 * selecionar os periodos e os checks se vai 
	 * querer com seguro e tanque cheio
	 */
	public AlugaCarro(Contrato contrato) {
		setBounds(0, 0, 800, 600);
		setLayout(null);
		data_inicial = new JSpinner();
		data_inicial.setBounds(417, 63, 159, 29);
		data_inicial.setModel(new SpinnerDateModel());
		add(data_inicial);
		
		data_final = new JSpinner();
		data_final.setBounds(417, 125, 159, 29);
		data_final.setModel(new SpinnerDateModel());
		add(data_final);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 37, 207, 168);
		add(scrollPane);
		
		list = new JList<Alugavel>();
		
		listModel = new DefaultListModel<Alugavel>();
		scrollPane.setViewportView(list);
		
		seguro = new JCheckBox("Seguro");
		seguro.setBounds(417, 182, 97, 23);
		add(seguro);
		
		tanque = new JCheckBox("Tanque cheio");
		tanque.setBounds(417, 229, 138, 23);
		add(tanque);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(39, 257, 89, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeServicos(getContrato()));
			}
		});
		add(btnVoltar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date data = (Date) data_inicial.getValue();
				Date data2 = (Date) data_final.getValue();
				Calendar inicio = Sistema.DateToCalendar(data);
				Calendar fim = Sistema.DateToCalendar(data2);
				try {
					Periodo p = new Periodo(inicio, fim);
					Alugavel obj = list.getSelectedValue();
					Carro carro = (Carro) obj;
					AluguelCarro aluguel = new AluguelCarro(carro, tanque.isSelected(), seguro.isSelected(), p);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		btnConcluir.setBounds(572, 256, 117, 25);
		add(btnConcluir);
		
		JLabel lblDataInicial = new JLabel("Data inicial");
		lblDataInicial.setBounds(329, 70, 89, 15);
		add(lblDataInicial);
		
		JLabel lblDataFina = new JLabel("Data final");
		lblDataFina.setBounds(329, 132, 89, 15);
		add(lblDataFina);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date data = (Date) data_inicial.getValue();
				Date data2 = (Date) data_final.getValue();
				Calendar inicio = Sistema.DateToCalendar(data);
				Calendar fim = Sistema.DateToCalendar(data2);
				try {
					Periodo p = new Periodo(inicio, fim);
					List<Alugavel> carros_disponiveis = Sistema.getHotel().verificaAlugaveisDisponiveis(p, Sistema.getHotel().getCarros());
					for (int i = 0; i < carros_disponiveis.size(); i++) {
						listModel.addElement(carros_disponiveis.get(i));		
					}
					
				} catch (Exception e2) {
					listModel.clear();
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		list.setModel(listModel);
		btnPesquisar.setBounds(596, 99, 117, 25);
		add(btnPesquisar);
		

	}
	
	public Contrato getContrato(){
		return contrato;
	}
}
