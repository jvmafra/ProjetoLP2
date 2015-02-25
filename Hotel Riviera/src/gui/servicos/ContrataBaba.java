package gui.servicos;

import gui.Sistema;
import gui.contratos.VisualizaContrato;

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
		setBackground(new Color(51, 102, 153));
		this.contrato = contrato;
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		data_inicial = new JSpinner();
		data_inicial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		data_inicial.setBounds(368, 177, 159, 29);
		data_inicial.setModel(new SpinnerDateModel());
		add(data_inicial);
		
		data_final = new JSpinner();
		data_final.setFont(new Font("Tahoma", Font.PLAIN, 13));
		data_final.setBounds(368, 218, 159, 29);
		data_final.setModel(new SpinnerDateModel());
		add(data_final);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(277, 322, 250, 196);
		add(scrollPane);
		
		list = new JList<Alugavel>();
		list.setForeground(new Color(51, 102, 153));
		list.setFont(new Font("Dialog", Font.PLAIN, 13));
		scrollPane.setViewportView(list);
		list.setBackground(Color.WHITE);
		final DefaultListModel<Alugavel> listModel = new DefaultListModel<Alugavel>();
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setBounds(277, 530, 88, 25);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeServicos(getContrato()));
			}
		});
		add(btnVoltar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setForeground(new Color(51, 102, 153));
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
						Sistema.getHotel().incrementaBabySitter();
						JOptionPane.showMessageDialog(null, "Baba contratada!");
						Sistema.setTela(new VisualizaContrato(getContrato()));
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "O hospede nao esta no hotel nesse periodo");
				}
				
				
			}
		});
		btnConcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnConcluir);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(51, 102, 153));
		btnBuscar.setBounds(410, 258, 117, 25);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date data = (Date) data_inicial.getValue();
				Date data2 = (Date) data_final.getValue();
				Calendar inicio = Sistema.DateToCalendar(data);
				Calendar fim = Sistema.DateToCalendar(data2);
				try {
					Periodo p = new Periodo(inicio, fim);
					List<Alugavel> babas_disponiveis = Sistema.getHotel().verificaAlugaveisDisponiveis(p, Sistema.getHotel().getBabas());
					for (Alugavel baba: babas_disponiveis) {
						listModel.addElement(baba);		
					}
					
				} catch (Exception e2) {
					listModel.clear();
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		
		list.setModel(listModel);
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(btnBuscar);
		
		JLabel lblDataInicial = new JLabel("Data inicial:");
		lblDataInicial.setForeground(new Color(255, 255, 255));
		lblDataInicial.setBounds(274, 183, 84, 15);
		lblDataInicial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblDataInicial);
		
		JLabel lblDataFinal = new JLabel("Data final:");
		lblDataFinal.setForeground(new Color(255, 255, 255));
		lblDataFinal.setBounds(284, 224, 74, 15);
		lblDataFinal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblDataFinal);
		
		JLabel lblBabsDisponveis = new JLabel("Babas disponiveis");
		lblBabsDisponveis.setForeground(new Color(255, 255, 255));
		lblBabsDisponveis.setBounds(278, 296, 134, 15);
		lblBabsDisponveis.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblBabsDisponveis);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(311, 11, 194, 140);
		lblNewLabel.setIcon(new ImageIcon("/home/edvalmsg/Downloads/bebe.jpg"));
		add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ContrataBaba.class.getResource("/nucleo/icones/hotel4.png")));
		label.setBounds(321, 23, 184, 129);
		add(label);
		

	}
	
	public Contrato getContrato(){
		return contrato;
	}
}