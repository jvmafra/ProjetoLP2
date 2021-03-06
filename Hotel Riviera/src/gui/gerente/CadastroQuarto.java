package gui.gerente;

import gui.Sistema;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import nucleo.classes.quartos.Quarto;
import nucleo.classes.quartos.QuartoExecutivoDuplo;
import nucleo.classes.quartos.QuartoExecutivoSimples;
import nucleo.classes.quartos.QuartoExecutivoTriplo;
import nucleo.classes.quartos.QuartoLuxoDuplo;
import nucleo.classes.quartos.QuartoLuxoSimples;
import nucleo.classes.quartos.QuartoLuxoTriplo;
import nucleo.classes.quartos.QuartoPresidencial;

/**
 * Cadastra um novo quarto no hotel. O numero dele ja eh calculado automaticamente pelo numero do ultimo
 */
public class CadastroQuarto extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<Quarto> quartos;
	private JButton concluir;
	private JLabel lblCadastraNovoQuarto;

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public CadastroQuarto() {
		setBackground(new Color(51, 102, 153));
		setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		setBounds(0, 0, 800, 600);
		
		
		try {
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		JButton voltar = new JButton("Voltar");
		voltar.setForeground(new Color(51, 102, 153));
		voltar.setBounds(292, 356, 91, 30);
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesPrivadas());
			}
		});
		setLayout(null);
		add(voltar);

		concluir = new JButton("Concluir");
		concluir.setForeground(new Color(51, 102, 153));
		concluir.setBounds(453, 356, 91, 30);
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
		concluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(concluir);
		
		quartos = new JComboBox<Quarto>();
		quartos.setForeground(new Color(51, 102, 153));
		quartos.setBounds(292, 277, 239, 30);
		quartos.setBackground(Color.WHITE);
		quartos.setFont(new Font("NanumGothic", Font.PLAIN, 14));
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
		selecionaQuarto.setForeground(new Color(255, 255, 255));
		selecionaQuarto.setBounds(348, 251, 158, 15);
		selecionaQuarto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(selecionaQuarto);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadastroQuarto.class.getResource("/nucleo/icones/hotel4 feito.png")));
		lblNewLabel.setBounds(337, 26, 169, 105);
		add(lblNewLabel);
		
		lblCadastraNovoQuarto = new JLabel("CADASTRA NOVO QUARTO");
		lblCadastraNovoQuarto.setFont(new Font("Bitstream Charter", Font.BOLD, 26));
		lblCadastraNovoQuarto.setForeground(new Color(255, 255, 255));
		lblCadastraNovoQuarto.setBounds(248, 128, 365, 55);
		add(lblCadastraNovoQuarto);
	}
	
	private int calculaProximoNumero(){
		return Sistema.getHotel().getQuartos().size() + 1;
	}
	
}


