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
import java.awt.Color;
import javax.swing.ImageIcon;
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
		setBackground(Color.WHITE);
		this.contrato = contrato;
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		data_inicial = new JSpinner();
		data_inicial.setBounds(321, 176, 159, 29);
		data_inicial.setModel(new SpinnerDateModel());
		add(data_inicial);
		
		data_final = new JSpinner();
		data_final.setBounds(321, 217, 159, 29);
		data_final.setModel(new SpinnerDateModel());
		add(data_final);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(277, 322, 250, 196);
		add(scrollPane);
		
		list = new JList<Alugavel>();
		scrollPane.setViewportView(list);
		list.setBackground(Color.WHITE);
		final DefaultListModel<Alugavel> listModel = new DefaultListModel<Alugavel>();
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(287, 530, 88, 25);
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeServicos(getContrato()));
			}
		});
		add(btnVoltar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setBounds(434, 530, 93, 25);
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
		add(btnConcluir);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(321, 258, 117, 25);
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
		add(btnBuscar);
		
		JLabel lblDataInicial = new JLabel("Data inicial:");
		lblDataInicial.setBounds(233, 183, 84, 15);
		lblDataInicial.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		add(lblDataInicial);
		
		JLabel lblDataFinal = new JLabel("Data final:");
		lblDataFinal.setBounds(243, 224, 74, 15);
		lblDataFinal.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		add(lblDataFinal);
		
		JLabel lblBabsDisponveis = new JLabel("Babás disponíveis");
		lblBabsDisponveis.setBounds(277, 295, 134, 15);
		lblBabsDisponveis.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		add(lblBabsDisponveis);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(311, 12, 194, 140);
		lblNewLabel.setIcon(new ImageIcon("/home/edvalmsg/Downloads/bebe.jpg"));
		add(lblNewLabel);
		

	}
	
	public Contrato getContrato(){
		return contrato;
	}
}