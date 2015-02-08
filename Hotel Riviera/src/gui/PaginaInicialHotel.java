package gui;

import gui.contratos.OpcoesDeContrato;
import gui.hospede.OpcoesDoHospede;
import gui.servicos.OpcoesDeServicos;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PaginaInicialHotel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction();
	private final Action action_2 = new SwingAction_1();
	private final Action action_3 = new SwingAction_2();
	private final Action action_4 = new SwingAction_3();
	private final Action action_5 = new SwingAction_4();
	private final Action action_6 = new SwingAction_5();
	private final Action action_7 = new SwingAction_6();

	/**
	 * Create the frame.
	 * @param NovoContrato 
	 */
	
	public PaginaInicialHotel() {
		repaint();
		setBounds(0, 0, 800, 600);
				
		final JPanel panel = new JPanel();
		panel.setBounds(0, 0,800,600);		
		setLayout(null);
		add(panel);
		
		JButton btnServicos = new JButton("Servi\u00E7os");
		btnServicos.setBounds(6, 59, 150, 50);
		btnServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeServicos());
			}
		});
		panel.setLayout(null);
		btnServicos.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btnServicos);
		
		JButton btnHospede = new JButton("H\u00F3spede");
		btnHospede.setBounds(6, 6, 150, 50);

		btnHospede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDoHospede());
			}
		});
		btnHospede.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btnHospede);
		
		JButton btnContratos = new JButton("Contratos");
		btnContratos.setBounds(6, 112, 150, 50);
		btnContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeContrato());
			}
		});
		btnContratos.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btnContratos);
		
		JButton btnOpinies = new JButton("Opini\u00F5es");
		btnOpinies.setBounds(6, 165, 150, 50);
		btnOpinies.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btnOpinies);
		
		JButton btnReservaldo = new JButton("Reservado");
		btnReservaldo.setBounds(6, 218, 150, 50);
		btnReservaldo.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btnReservaldo);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(6, 271, 150, 50);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new LoginDeFuncionario());
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btnSair);
	}

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_1() {
			putValue(NAME, "Contrato");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	private class SwingAction_2 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_2() {
			putValue(NAME, "Serviços");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_3 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_3() {
			putValue(NAME, "Contratos Abertos");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_4 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_4() {
			putValue(NAME, "Contratos fechados");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_5 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_5() {
			putValue(NAME, "Quartos Disponiveis");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_6 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_6() {
			putValue(NAME, "Serviços Disponiveis");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}	