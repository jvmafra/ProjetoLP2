package gui.servicos;

import gui.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JScrollPane;
import javax.swing.JList;

import classes.Carro.Carro;
import classes.HotelOpiniaoServicosPeriodo.Alugavel;
import classes.Pessoa.Contrato;

import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AlugaCarro extends JPanel {
	private Contrato contrato;

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
		setLayout(null);
		setBounds(0, 0, 800, 600);
		JSpinner spinner = new JSpinner();
		spinner.setBounds(417, 63, 159, 29);
		spinner.setModel(new SpinnerDateModel());
		add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(417, 125, 159, 29);
		spinner_1.setModel(new SpinnerDateModel());
		add(spinner_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 37, 207, 168);
		add(scrollPane);
		
		JList<Alugavel> list = new JList<Alugavel>();
		
		DefaultListModel<Alugavel> lista = new DefaultListModel<Alugavel>();
		for (int i = 0; i < Sistema.getHotel().getCarros().size(); i++) {
			lista.addElement(Sistema.getHotel().getCarros().get(i));
		}
		list.setModel(lista);
		scrollPane.setViewportView(list);
		
		JCheckBox chckbxSeguro = new JCheckBox("Seguro");
		chckbxSeguro.setBounds(417, 182, 97, 23);
		add(chckbxSeguro);
		
		JCheckBox chckbxTanqueCheio = new JCheckBox("Tanque cheio");
		chckbxTanqueCheio.setBounds(417, 229, 97, 23);
		add(chckbxTanqueCheio);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeServicos(getContrato()));
			}
		});
		btnVoltar.setBounds(39, 257, 89, 23);
		add(btnVoltar);
		

	}
	
	public Contrato getContrato(){
		return contrato;
	}
}
