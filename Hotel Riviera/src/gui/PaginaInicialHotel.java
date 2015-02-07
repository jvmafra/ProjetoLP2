package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTree;
import javax.swing.JSpinner;
import javax.swing.JTable;

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
		setBounds(0, 0, 181, 647);
				
		final JPanel panel = new JPanel();
		panel.setBounds(0, 0, 165, 640);		
		setLayout(null);
		panel.setLayout(null);
		add(panel);
		
		JButton btnServicos = new JButton("Servi\u00E7os");
		btnServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeServicos());
			}
		});
		btnServicos.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnServicos.setBounds(0, 112, 165, 102);
		panel.add(btnServicos);
		
		JButton btnHospede = new JButton("H\u00F3spede");
		btnHospede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDoHospede());
			}
		});
		btnHospede.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHospede.setBounds(0, 0, 165, 102);
		panel.add(btnHospede);
		
		JButton btnContratos = new JButton("Contratos");
		btnContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnContratos.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnContratos.setBounds(0, 225, 165, 102);
		panel.add(btnContratos);
		
		JButton btnOpinies = new JButton("Opini\u00F5es");
		btnOpinies.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOpinies.setBounds(0, 328, 165, 102);
		panel.add(btnOpinies);
		
		JButton btnReservaldo = new JButton("Reservado");
		btnReservaldo.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReservaldo.setBounds(0, 431, 165, 102);
		panel.add(btnReservaldo);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new LoginDeFuncionario());
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSair.setBounds(0, 538, 165, 102);
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