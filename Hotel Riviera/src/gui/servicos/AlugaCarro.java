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
		setBackground(new Color(51, 102, 153));
		this.contrato = contrato;
		setBounds(0, 0, 800, 600);
		setLayout(null);
		data_inicial = new JSpinner();
		data_inicial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		data_inicial.setBounds(338, 177, 159, 29);
		data_inicial.setModel(new SpinnerDateModel());
		add(data_inicial);
		
		data_final = new JSpinner();
		data_final.setFont(new Font("Tahoma", Font.PLAIN, 13));
		data_final.setBounds(338, 223, 159, 29);
		data_final.setModel(new SpinnerDateModel());
		add(data_final);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(263, 290, 231, 224);
		add(scrollPane);
		
		list = new JList<Alugavel>();
		list.setForeground(new Color(51, 102, 153));
		list.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		listModel = new DefaultListModel<Alugavel>();
		scrollPane.setViewportView(list);
		
		seguro = new JCheckBox("Seguro");
		seguro.setForeground(new Color(255, 255, 255));
		seguro.setBackground(new Color(51, 102, 153));
		seguro.setBounds(525, 424, 97, 23);
		seguro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(seguro);
		
		tanque = new JCheckBox("Tanque cheio");
		tanque.setForeground(new Color(255, 255, 255));
		tanque.setBackground(new Color(51, 102, 153));
		tanque.setBounds(525, 460, 138, 23);
		tanque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(tanque);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setBounds(220, 525, 117, 25);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeServicos(getContrato()));
			}
		});
		add(btnVoltar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setForeground(new Color(51, 102, 153));
		btnConcluir.setBounds(435, 525, 117, 25);
		btnConcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
						Sistema.getHotel().incrementaAlugueisCarro();
						JOptionPane.showMessageDialog(null, "Carro alugado!");
						Sistema.setTela(new VisualizaContrato(getContrato()));
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
		lblDataInicial.setForeground(new Color(255, 255, 255));
		lblDataInicial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataInicial.setBounds(263, 183, 89, 15);
		add(lblDataInicial);
		
		JLabel lblDataFina = new JLabel("Data final");
		lblDataFina.setForeground(new Color(255, 255, 255));
		lblDataFina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataFina.setBounds(263, 229, 89, 15);
		add(lblDataFina);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(new Color(51, 102, 153));
		btnPesquisar.setBounds(507, 207, 107, 23);
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
		
		JLabel lblCarrosDisponveis = new JLabel("Carros disponiveis");
		lblCarrosDisponveis.setForeground(new Color(255, 255, 255));
		lblCarrosDisponveis.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCarrosDisponveis.setBounds(263, 274, 138, 15);
		add(lblCarrosDisponveis);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AlugaCarro.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(319, 11, 229, 116);
		add(lblNewLabel);
		

	}
	
	public Contrato getContrato(){
		return contrato;
	}
}