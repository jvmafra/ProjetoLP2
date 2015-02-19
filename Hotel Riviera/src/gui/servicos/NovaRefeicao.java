package gui.servicos;

import gui.Sistema;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import nucleo.classes.servicos.Refeicao;
import nucleo.classes.pessoa.Contrato;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class NovaRefeicao extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField valor;
	private JSpinner data_refeicao;
	private Contrato contrato;

	/**
	 * Create the panel.
	 */
	public NovaRefeicao(Contrato contrato) {
		setBackground(Color.WHITE);
		this.contrato = contrato;
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		JLabel lblData = new JLabel("Data: ");
		lblData.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblData.setBounds(288, 196, 70, 15);
		add(lblData);
		
		data_refeicao = new JSpinner();
		data_refeicao.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		data_refeicao.setModel(new SpinnerDateModel(new Date(1423360800000L), null, null, Calendar.DAY_OF_YEAR));
		data_refeicao.setBounds(339, 193, 143, 20);
		add(data_refeicao);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblValor.setBounds(288, 243, 70, 15);
		add(lblValor);
		
		valor = new JTextField();
		valor.setBounds(339, 241, 114, 19);
		add(valor);
		valor.setColumns(10);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date data = (Date) data_refeicao.getValue();
				Calendar data_original = Sistema.DateToCalendar(data);
				if (!(getContrato().getPeriodo().dataIsContida(data_original))){
					
					try {
						Refeicao refeicao = new Refeicao(Double.parseDouble(valor.getText()), data_original);
						getContrato().adicionaServico(refeicao);
						JOptionPane.showMessageDialog(null, "Servico adicionado");
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "O hospede nao esta no hotel nessa data");
				}
			}
		});
		btnConcluir.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnConcluir.setBounds(469, 327, 117, 25);
		add(btnConcluir);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_refeicao.removeAll();
				valor.setText("");
			}
		});
		btnLimpar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnLimpar.setBounds(336, 327, 117, 25);
		add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeServicos(getContrato()));
			}
		});
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.setBounds(196, 327, 117, 25);
		add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NovaRefeicao.class.getResource("/nucleo/icones/restaurant7.png")));
		lblNewLabel.setBounds(360, 54, 70, 90);
		add(lblNewLabel);

	}
	
	
	public Contrato getContrato(){
		return contrato;
	}
}