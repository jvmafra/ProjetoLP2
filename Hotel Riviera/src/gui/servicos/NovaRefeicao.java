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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import nucleo.classes.pessoa.Contrato;
import nucleo.classes.servicos.Refeicao;

public class NovaRefeicao extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField valor;
	private JSpinner data_refeicao;
	private Contrato contrato;

	/**
	 * Create the panel.
	 */
	public NovaRefeicao(Contrato contrato) {
		setBackground(new Color(51, 102, 153));
		this.contrato = contrato;
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		JLabel lblData = new JLabel("Data: ");
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(288, 323, 70, 15);
		add(lblData);
		
		data_refeicao = new JSpinner();
		data_refeicao.setForeground(new Color(51, 102, 153));
		data_refeicao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		data_refeicao.setModel(new SpinnerDateModel());
		data_refeicao.setBounds(339, 320, 143, 30);
		add(data_refeicao);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setForeground(new Color(255, 255, 255));
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValor.setBounds(288, 363, 70, 15);
		add(lblValor);
		
		valor = new JTextField();
		valor.setBounds(339, 362, 110, 30);
		add(valor);
		valor.setColumns(10);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setForeground(new Color(51, 102, 153));
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date data = (Date) data_refeicao.getValue();
				Calendar data_original = Sistema.DateToCalendar(data);
				if ((getContrato().getPeriodo().dataIsContida(data_original))){
					
					try {
						Refeicao refeicao = new Refeicao(Double.parseDouble(valor.getText()), data_original);
						getContrato().adicionaServico(refeicao);
						Sistema.getHotel().incrementaRefeicoes();
						JOptionPane.showMessageDialog(null, "Servico adicionado");
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
		btnConcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConcluir.setBounds(505, 440, 117, 25);
		add(btnConcluir);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setForeground(new Color(51, 102, 153));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data_refeicao.removeAll();
				valor.setText("");
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(349, 440, 117, 25);
		add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeServicos(getContrato()));
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(194, 440, 117, 25);
		add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NovaRefeicao.class.getResource("/nucleo/icones/restaurant7.png")));
		lblNewLabel.setBounds(339, 208, 70, 90);
		add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(NovaRefeicao.class.getResource("/nucleo/icones/hotel4 feito.png")));
		label.setBounds(314, 45, 175, 132);
		add(label);

	}
	
	
	public Contrato getContrato(){
		return contrato;
	}
}