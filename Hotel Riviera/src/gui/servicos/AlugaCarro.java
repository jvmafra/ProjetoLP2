package gui.servicos;

import gui.Sistema;
import gui.contratos.VisualizaContrato;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JScrollPane;
import javax.swing.JList;

import nucleo.classes.servicos.*;
import nucleo.classes.hotel.*;
import nucleo.classes.pessoa.*;


import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;


public class AlugaCarro extends JPanel {
	private static final long serialVersionUID = 1L;
	private Contrato contrato;
	JSpinner data_inicial;
	JSpinner data_final;
	DefaultListModel<Alugavel> listModel;
	JList<Alugavel> list;
	JCheckBox seguro, tanque;
	

	/**
	 * 
	 */

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
		setBackground(Color.WHITE);
		this.contrato = contrato;
		setBounds(0, 0, 800, 600);
		setLayout(null);
		data_inicial = new JSpinner();
		data_inicial.setBounds(412, 182, 159, 29);
		data_inicial.setModel(new SpinnerDateModel());
		add(data_inicial);
		
		data_final = new JSpinner();
		data_final.setBounds(412, 229, 159, 29);
		data_final.setModel(new SpinnerDateModel());
		add(data_final);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 128, 235, 309);
		add(scrollPane);
		
		list = new JList<Alugavel>();
		
		listModel = new DefaultListModel<Alugavel>();
		scrollPane.setViewportView(list);
		
		seguro = new JCheckBox("Seguro");
		seguro.setBackground(Color.WHITE);
		seguro.setBounds(411, 266, 97, 23);
		seguro.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		add(seguro);
		
		tanque = new JCheckBox("Tanque cheio");
		tanque.setBackground(Color.WHITE);
		tanque.setBounds(411, 293, 138, 23);
		tanque.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		add(tanque);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(377, 341, 117, 25);
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new VisualizaContrato(getContrato()));
			}
		});
		add(btnVoltar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setBounds(545, 341, 117, 25);
		btnConcluir.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date data = (Date) data_inicial.getValue();
				Date data2 = (Date) data_final.getValue();
				Calendar inicio = Sistema.DateToCalendar(data);
				Calendar fim = Sistema.DateToCalendar(data2);
				if (getContrato().getPeriodo().dataIsContida(inicio) && (getContrato().getPeriodo().dataIsContida(fim))){
					try {	
						Periodo p = new Periodo(inicio, fim);
						Alugavel obj = list.getSelectedValue();
						Carro carro = (Carro) obj;
						AluguelCarro aluguel = new AluguelCarro(carro, tanque.isSelected(), seguro.isSelected(), p);
						getContrato().adicionaServico(aluguel);
						JOptionPane.showMessageDialog(null, "Carro alugado!");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "O hospede nao esta no hotel nesse periodo");
				}
				
			}
		});
		add(btnConcluir);
		
		JLabel lblDataInicial = new JLabel("Data inicial");
		lblDataInicial.setBounds(324, 189, 89, 15);
		add(lblDataInicial);
		
		JLabel lblDataFina = new JLabel("Data final");
		lblDataFina.setBounds(324, 236, 89, 15);
		add(lblDataFina);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(625, 204, 117, 25);
		btnPesquisar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.clear();
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
		add(btnPesquisar);
		
		JLabel lblCarrosDisponveis = new JLabel("Carros disponíveis");
		lblCarrosDisponveis.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblCarrosDisponveis.setBounds(36, 101, 138, 15);
		add(lblCarrosDisponveis);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/home/edvalmsg/Downloads/images.png"));
		lblNewLabel.setBounds(297, 12, 229, 116);
		add(lblNewLabel);
		

	}
	
	public Contrato getContrato(){
		return contrato;
	}
}