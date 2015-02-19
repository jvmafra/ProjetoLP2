package gui.servicos;

import gui.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import classes.hotel.*;

import javax.swing.JLabel;

import nucleo.classes.hotel.Alugavel;
import nucleo.classes.hotel.Periodo;
import nucleo.classes.pessoa.Contrato;
import nucleo.classes.pessoa.Hospede;
import nucleo.classes.servicos.Baba;
import nucleo.classes.servicos.BabySitter;
public class ContrataBaba extends JPanel {
	private Contrato contrato;
	JSpinner data_inicial;
	JSpinner data_final;
	JList<Alugavel> list;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ContrataBaba(Contrato contrato) {
		this.contrato = contrato;
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		data_inicial = new JSpinner();
		data_inicial.setBounds(321, 128, 159, 29);
		data_inicial.setModel(new SpinnerDateModel());
		add(data_inicial);
		
		data_final = new JSpinner();
		data_final.setBounds(321, 168, 159, 29);
		data_final.setModel(new SpinnerDateModel());
		add(data_final);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(256, 270, 250, 196);
		add(scrollPane);
		final DefaultListModel<Alugavel> listModel = new DefaultListModel<Alugavel>();
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeServicos(getContrato()));
			}
		});
		btnVoltar.setBounds(221, 486, 88, 25);
		add(btnVoltar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date data = (Date) data_inicial.getValue();
				Date data2 = (Date) data_final.getValue();
				Calendar inicio = Sistema.DateToCalendar(data);
				Calendar fim = Sistema.DateToCalendar(data2);
				if (getContrato().getPeriodo().dataIsContida(inicio) && (getContrato().getPeriodo().dataIsContida(fim))){
					try {
						Periodo p = new Periodo(inicio, fim);
						Alugavel obj = list.getSelectedValue();
						Baba baba = (Baba) obj;
						BabySitter baby = new BabySitter(baba, p);
						getContrato().adicionaServico(baby);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "O hospede nao esta no hotel nesse periodo");
				}
				
				
			}
		});
		btnConcluir.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnConcluir.setBounds(462, 486, 93, 25);
		add(btnConcluir);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date data = (Date) data_inicial.getValue();
				Date data2 = (Date) data_final.getValue();
				Calendar inicio = Sistema.DateToCalendar(data);
				Calendar fim = Sistema.DateToCalendar(data2);
				try {
					Periodo p = new Periodo(inicio, fim);
					List<Alugavel> babas_disponiveis = Sistema.getHotel().verificaAlugaveisDisponiveis(p, Sistema.getHotel().getBabas());
					for (int i = 0; i < babas_disponiveis.size(); i++) {
						listModel.addElement(babas_disponiveis.get(i));		
					}
					
				} catch (Exception e2) {
					listModel.clear();
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		
		btnBuscar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnBuscar.setBounds(321, 214, 117, 25);
		add(btnBuscar);
		
		JLabel lblDataInicial = new JLabel("Data inicial:");
		lblDataInicial.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblDataInicial.setBounds(233, 135, 84, 15);
		add(lblDataInicial);
		
		JLabel lblDataFinal = new JLabel("Data final:");
		lblDataFinal.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblDataFinal.setBounds(243, 175, 74, 15);
		add(lblDataFinal);
		
		list = new JList<Alugavel>();
		list.setBounds(256, 270, 247, 193);
		add(list);
		list.setModel(listModel);
		

	}
	
	public Contrato getContrato(){
		return contrato;
	}
}