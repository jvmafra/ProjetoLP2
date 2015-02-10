package gui.servicos;

import gui.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import classes.Baba.Baba;
import classes.HotelOpiniaoServicosPeriodo.Periodo;
import classes.Pessoa.Contrato;
import classes.Pessoa.Hospede;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import classes.HotelOpiniaoServicosPeriodo.*;

import javax.swing.JLabel;
public class ContrataBaba extends JPanel {
	private Contrato contrato;
	JSpinner data_inicial;
	JSpinner data_final;

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
		scrollPane.setBounds(283, 247, 250, 196);
		add(scrollPane);
		
		JList<Baba> list = new JList<Baba>();
		scrollPane.setViewportView(list);
		final DefaultListModel<Baba> listModel = new DefaultListModel<Baba>();
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeServicos(getContrato()));
			}
		});
		btnVoltar.setBounds(256, 486, 88, 25);
		add(btnVoltar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnConcluir.setBounds(475, 486, 93, 25);
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
					listModel.clear();
					for (int i = 0; i < Sistema.getHotel().getBabas().size(); i++) {
						if (Sistema.getHotel().getBabas().get(i).isDisponivel(p))
							listModel.addElement(Sistema.getHotel().getBabas().get(i));		
					}
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		list.setModel(listModel);
		
		btnBuscar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnBuscar.setBounds(344, 210, 117, 25);
		add(btnBuscar);
		
		JLabel lblDataInicial = new JLabel("Data inicial:");
		lblDataInicial.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblDataInicial.setBounds(233, 135, 84, 15);
		add(lblDataInicial);
		
		JLabel lblDataFinal = new JLabel("Data final:");
		lblDataFinal.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblDataFinal.setBounds(243, 175, 74, 15);
		add(lblDataFinal);
		

	}
	
	public Contrato getContrato(){
		return contrato;
	}
}
