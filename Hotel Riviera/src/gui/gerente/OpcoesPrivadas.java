package gui.gerente;

import gui.LoginDeFuncionario;
import gui.Sistema;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OpcoesPrivadas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public OpcoesPrivadas() {
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0, 0, 800, 600);
		JButton btnFaturamentos = new JButton("ESTATISTICAS");
		btnFaturamentos.setForeground(new Color(51, 102, 153));
		btnFaturamentos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFaturamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesEstatisticas());
			}
		});
		btnFaturamentos.setBounds(306, 199, 197, 33);
		add(btnFaturamentos);
		
		JButton btnCadastraFuncionrio = new JButton("FUNCIONARIO");
		btnCadastraFuncionrio.setForeground(new Color(51, 102, 153));
		btnCadastraFuncionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesFuncionario());
			}
		});
		btnCadastraFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCadastraFuncionrio.setBounds(306, 252, 197, 33);
		add(btnCadastraFuncionrio);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new LoginDeFuncionario(true));
			}
		});
		btnVoltar.setBounds(358, 538, 90, 30);
		add(btnVoltar);
		
		JButton btnCadastroCarro = new JButton("CARRO");
		btnCadastroCarro.setForeground(new Color(51, 102, 153));
		btnCadastroCarro.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCadastroCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeCarro());
			}
		});
		btnCadastroCarro.setBounds(306, 362, 197, 33);
		add(btnCadastroCarro);
		
		JButton btnCadastraBab = new JButton("BABA");
		btnCadastraBab.setForeground(new Color(51, 102, 153));
		btnCadastraBab.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCadastraBab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeBaba());
			}
		});
		btnCadastraBab.setBounds(306, 418, 195, 33);
		add(btnCadastraBab);
		
		JButton btnCadastraQuarto = new JButton("CADASTRA QUARTO");
		btnCadastraQuarto.setForeground(new Color(51, 102, 153));
		btnCadastraQuarto.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCadastraQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new CadastroQuarto());
			}
		});
		btnCadastraQuarto.setBounds(306, 471, 195, 33);
		add(btnCadastraQuarto);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(OpcoesPrivadas.class.getResource("/nucleo/icones/hotel4 feito.png")));
		lblNewLabel.setBounds(331, 23, 184, 98);
		add(lblNewLabel);
		
		JLabel lblreaReservada = new JLabel("\u00C1REA RESERVADA");
		lblreaReservada.setFont(new Font("Bitstream Charter", Font.BOLD, 26));
		lblreaReservada.setForeground(new Color(255, 255, 255));
		lblreaReservada.setBounds(296, 133, 262, 55);
		add(lblreaReservada);
		
		JButton btnNewButton = new JButton("ESTRATEGIAS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new OpcoesDeEstrategia());
			}
		});
		btnNewButton.setForeground(new Color(51, 102, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(306, 308, 197, 33);
		add(btnNewButton);

	}
}