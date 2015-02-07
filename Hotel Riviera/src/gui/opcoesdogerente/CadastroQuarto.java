package gui.opcoesdogerente;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

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
	private JPanel contentPane;
	JComboBox<Quarto> quartos;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroQuarto frame = new CadastroQuarto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroQuarto() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		quartos = new JComboBox<Quarto>();
		quartos.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		quartos.setToolTipText("Quartos");
		quartos.setMaximumRowCount(7);
		try {
			quartos.addItem(new QuartoExecutivoSimples(1));
			quartos.addItem(new QuartoExecutivoDuplo(1));
			quartos.addItem(new QuartoExecutivoTriplo(1));
			quartos.addItem(new QuartoLuxoSimples(1));
			quartos.addItem(new QuartoLuxoDuplo(1));
			quartos.addItem(new QuartoLuxoTriplo(1));
			quartos.addItem(new QuartoPresidencial(1));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	
		
		JLabel lblSelecioneOQuarto = new JLabel("Selecione o quarto a ser adicionado:");
		lblSelecioneOQuarto.setFont(new Font("Tw Cen MT", Font.PLAIN, 13));
		
		JButton voltar = new JButton("Voltar");
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.setAction(action);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(107)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSelecioneOQuarto)
						.addComponent(quartos, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(117, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addComponent(voltar, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
					.addComponent(cadastrar)
					.addGap(44))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addComponent(lblSelecioneOQuarto)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(quartos, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(voltar)
						.addComponent(cadastrar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Cadastrar");
			putValue(SHORT_DESCRIPTION, "Cadastra o quarto");
		}
		public void actionPerformed(ActionEvent e) {
			// adiciona na lista de quartos do hotel
		}
	}
}
