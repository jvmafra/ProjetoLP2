package gui.gerente;

import gui.Sistema;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.Carro.Carro;
import classes.Quartos.Quarto;
import classes.Quartos.QuartoExecutivoDuplo;
import classes.Quartos.QuartoExecutivoSimples;
import classes.Quartos.QuartoExecutivoTriplo;
import classes.Quartos.QuartoLuxoDuplo;
import classes.Quartos.QuartoLuxoSimples;
import classes.Quartos.QuartoLuxoTriplo;
import classes.Quartos.QuartoPresidencial;

public class CadastroQuarto extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<Quarto> quartos;

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public CadastroQuarto() {
		setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		
		try {
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	

		
		JButton voltar = new JButton("Voltar");
		voltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesPrivadas());
			}
		});
		voltar.setBounds(292, 284, 73, 27);
		add(voltar);
		
		
		JButton concluir = new JButton("Concluir");
		concluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Object quarto = quartos.getSelectedItem();
					Quarto quarto_criado = (Quarto) quarto;
					Sistema.getHotel().adicionaQuarto(quarto_criado);
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
				}  catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		concluir.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		concluir.setBounds(440, 284, 91, 27);
		add(concluir);
		
		quartos = new JComboBox<Quarto>();
		quartos.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		quartos.setBounds(313, 171, 197, 24);
		add(quartos);
		
		try {
			quartos.addItem(new QuartoExecutivoSimples(calculaProximoNumero()));
			quartos.addItem(new QuartoExecutivoDuplo(calculaProximoNumero()));
			quartos.addItem(new QuartoExecutivoTriplo(calculaProximoNumero()));
			quartos.addItem(new QuartoLuxoSimples(calculaProximoNumero()));
			quartos.addItem(new QuartoLuxoDuplo(calculaProximoNumero()));
			quartos.addItem(new QuartoLuxoTriplo(calculaProximoNumero()));
			quartos.addItem(new QuartoPresidencial(calculaProximoNumero()));
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null,
					"Quarto nao criado.");
		}
		
		
		JLabel selecionaQuarto = new JLabel("Selecione o quarto");
		selecionaQuarto.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		selecionaQuarto.setBounds(313, 144, 158, 15);
		add(selecionaQuarto);
	}
	
	private int calculaProximoNumero(){
		return Sistema.getHotel().getQuartos().size() + 1;
	}
}



