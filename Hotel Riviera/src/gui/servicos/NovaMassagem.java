package gui.servicos;

import gui.Sistema;
import gui.contratos.VisualizaContrato;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.util.Date;
import java.util.Calendar;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;

import nucleo.classes.hotel.Periodo;
import nucleo.classes.pessoa.Contrato;
import nucleo.classes.servicos.Massagem;
import nucleo.classes.servicos.TipoDeMassagens;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NovaMassagem extends JPanel {


	private static final long serialVersionUID = 1L;
	Contrato contrato;
	JComboBox<TipoDeMassagens> tipos;
	JSpinner data_inicial;
	JSpinner data_final;
	
	public NovaMassagem(Contrato contrato) {
		this.contrato = contrato;
		
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(NovaMassagem.class.getResource("/nucleo/icones/hotel4.png")));
		label.setBounds(320, 49, 138, 94);
		add(label);
		setBounds(0,0,800,600);
		
		data_inicial = new JSpinner();
		data_inicial.setFont(new Font("NanumGothic", Font.PLAIN, 13));
		data_inicial.setModel(new SpinnerDateModel(new Date(1424833200000L), null, null, Calendar.DAY_OF_YEAR));
		data_inicial.setBounds(362, 221, 144, 27);
		add(data_inicial);
		
		JLabel lblInicio = new JLabel("Inicio:");
		lblInicio.setForeground(new Color(255, 255, 255));
		lblInicio.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblInicio.setBounds(309, 227, 70, 15);
		add(lblInicio);
		
		data_final = new JSpinner();
		data_final.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		data_final.setModel(new SpinnerDateModel(new Date(1424833200000L), null, null, Calendar.DAY_OF_YEAR));
		data_final.setBounds(362, 273, 144, 27);
		add(data_final);
		
		JLabel lblFim = new JLabel("Fim:");
		lblFim.setForeground(new Color(255, 255, 255));
		lblFim.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblFim.setBounds(309, 279, 70, 15);
		add(lblFim);
		
		JLabel lblTipo = new JLabel("Tipo: ");
		lblTipo.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblTipo.setForeground(new Color(255, 255, 255));
		lblTipo.setBounds(286, 359, 70, 15);
		add(lblTipo);
		
		tipos = new JComboBox<TipoDeMassagens>();
		tipos.setFont(new Font("Dialog", Font.PLAIN, 13));
		tipos.setForeground(new Color(51, 102, 153));
		tipos.setBounds(330, 354, 176, 24);
		add(tipos);
		adicionaOpcoesMassagem();
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new OpcoesDeServicos(getContrato()));
			}
		});
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnVoltar.setBounds(239, 458, 117, 25);
		add(btnVoltar);
		
		JButton btnConcluirconcluir = new JButton("Concluir");
		btnConcluirconcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date data = (Date) data_inicial.getValue();
				Date data2 = (Date) data_final.getValue();
				Calendar inicio = Sistema.DateToCalendar(data);
				Calendar fim = Sistema.DateToCalendar(data2);
				if (getContrato().getPeriodo().dataIsContida(inicio) && (getContrato().getPeriodo().dataIsContida(fim))){
					try {
						Periodo p = new Periodo(inicio, fim);
						TipoDeMassagens tipo = (TipoDeMassagens) tipos.getSelectedItem();
						Massagem massagem = new Massagem(tipo, p);
						getContrato().adicionaServico(massagem);
						Sistema.getHotel().incrementaMassagens();
						JOptionPane.showMessageDialog(null, "Massagem adicionada!");
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
		btnConcluirconcluir.setForeground(new Color(51, 102, 153));
		btnConcluirconcluir.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnConcluirconcluir.setBounds(480, 458, 117, 25);
		add(btnConcluirconcluir);
	}
	
	public Contrato getContrato(){
		return contrato;
	}
	
	public void adicionaOpcoesMassagem(){
		tipos.addItem(TipoDeMassagens.CLASSICA);
		tipos.addItem(TipoDeMassagens.PEDRAS_QUENTES);
		tipos.addItem(TipoDeMassagens.REIKI);
		tipos.addItem(TipoDeMassagens.SHIATSU);
	}
}