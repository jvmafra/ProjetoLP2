package gui.servicos;

import gui.Sistema;
import gui.contratos.VisualizaContrato;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;

import nucleo.classes.pessoa.Contrato;
import nucleo.classes.servicos.Massagem;
import nucleo.classes.servicos.TipoDeMassagens;

/**
 * Tela para servico de massagem
 */
public class NovaMassagem extends JPanel {


	private static final long serialVersionUID = 1L;
	Contrato contrato;
	JComboBox<TipoDeMassagens> tipos;
	JSpinner data_inicial;
	JSpinner duracao;
	
	public NovaMassagem(Contrato contrato) {
		this.contrato = contrato;
		
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(NovaMassagem.class.getResource("/nucleo/icones/hotel4 feito.png")));
		label.setBounds(320, 49, 138, 94);
		add(label);
		setBounds(0,0,800,600);
		
		data_inicial = new JSpinner();
		data_inicial.setFont(new Font("NanumGothic", Font.PLAIN, 13));
		data_inicial.setModel(new SpinnerDateModel(new Date(1424833200000L), null, null, Calendar.DAY_OF_YEAR));
		data_inicial.setBounds(328, 284, 130, 30);
		add(data_inicial);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblData.setBounds(286, 291, 70, 15);
		add(lblData);
		
		JLabel lblTipo = new JLabel("Tipo: ");
		lblTipo.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblTipo.setForeground(new Color(255, 255, 255));
		lblTipo.setBounds(286, 215, 70, 15);
		add(lblTipo);
		
		tipos = new JComboBox<TipoDeMassagens>();
		tipos.setFont(new Font("Dialog", Font.PLAIN, 13));
		tipos.setForeground(new Color(51, 102, 153));
		tipos.setBounds(328, 207, 176, 30);
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
				Calendar data_massagem = Sistema.DateToCalendar(data);
				int duracao_da_massagem = (Integer) duracao.getValue();
				
				if (getContrato().getPeriodo().dataIsContida(data_massagem)){
					try {
						TipoDeMassagens tipo = (TipoDeMassagens) tipos.getSelectedItem();
						Massagem massagem = new Massagem(tipo, data_massagem, duracao_da_massagem);
						getContrato().adicionaServico(massagem);
						Sistema.getHotel().incrementaMassagens();
						JOptionPane.showMessageDialog(null, "Massagem adicionada!");
						Sistema.setTela(new VisualizaContrato(getContrato()));
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "O hospede nao esta no hotel nessa data");
				}
				
				
			}
		
		});
		btnConcluirconcluir.setForeground(new Color(51, 102, 153));
		btnConcluirconcluir.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnConcluirconcluir.setBounds(480, 458, 117, 25);
		add(btnConcluirconcluir);
		
		JLabel lblDuracao = new JLabel("Duracao:");
		lblDuracao.setForeground(Color.WHITE);
		lblDuracao.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblDuracao.setBounds(258, 348, 70, 15);
		add(lblDuracao);
		
		duracao = new JSpinner();
		duracao.setFont(new Font("Dialog", Font.BOLD, 14));
		duracao.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		duracao.setBounds(328, 346, 48, 30);
		add(duracao);
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