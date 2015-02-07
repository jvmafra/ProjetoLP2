package gui;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import classes.Baba.Baba;
import excecoes.EntradaDeDadosException;


public class NovaBaba extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel CadastroBaba;
	private JTextField Nome;
	private JTextField Telefone;
	private final Action Limpando = new SwingAction();
	private final Action action = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovaBaba frame = new NovaBaba();
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
	public NovaBaba() {
		setBounds(100, 100, 450, 300);
		CadastroBaba = new JPanel();
		CadastroBaba.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblNome = new JLabel("Nome");
		
		Nome = new JTextField();
		Nome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		
		Telefone = new JTextField();
		Telefone.setColumns(10);
		
		JButton Limpar = new JButton("Limpar");
		Limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Limpar.setAction(Limpando);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setAction(action);
		
		JButton btnVoltar = new JButton("Voltar");
		GroupLayout gl_CadastroBaba = new GroupLayout(CadastroBaba);
		gl_CadastroBaba.setHorizontalGroup(
			gl_CadastroBaba.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CadastroBaba.createSequentialGroup()
					.addGroup(gl_CadastroBaba.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_CadastroBaba.createSequentialGroup()
							.addGap(98)
							.addGroup(gl_CadastroBaba.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTelefone)
								.addComponent(lblNome)))
						.addGroup(gl_CadastroBaba.createSequentialGroup()
							.addGap(18)
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_CadastroBaba.createParallelGroup(Alignment.LEADING)
						.addComponent(Nome, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_CadastroBaba.createParallelGroup(Alignment.LEADING)
							.addComponent(Telefone, 111, 111, 111)
							.addGroup(gl_CadastroBaba.createSequentialGroup()
								.addComponent(Limpar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addGap(42)
								.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))))
					.addGap(28))
		);
		gl_CadastroBaba.setVerticalGroup(
			gl_CadastroBaba.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CadastroBaba.createSequentialGroup()
					.addGap(80)
					.addGroup(gl_CadastroBaba.createParallelGroup(Alignment.BASELINE)
						.addComponent(Nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome))
					.addGap(18)
					.addGroup(gl_CadastroBaba.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefone)
						.addComponent(Telefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addGroup(gl_CadastroBaba.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltar)
						.addComponent(Limpar)
						.addComponent(btnCadastrar))
					.addGap(24))
		);
		CadastroBaba.setLayout(gl_CadastroBaba);
	}

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "Limpar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			Nome.setText("");
			Telefone.setText("");
			
		}
	}
	private class SwingAction_1 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_1() {
			putValue(NAME, "Cadastrar");
			putValue(SHORT_DESCRIPTION, "Cadastrar baba");
		}
		public void actionPerformed(ActionEvent e) {
			try{
				Baba baba = new Baba(Nome.getText(), Telefone.getText() );
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			
			}
			catch (EntradaDeDadosException e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
		}
		}
	}
