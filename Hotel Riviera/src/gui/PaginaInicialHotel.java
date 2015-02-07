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
		
		setBounds(0, 0, 1000, 600);
		setLayout(null);
				
		final JPanel panel = new JPanel();

		panel.setBounds(0, 0, 165, 577);
		add(panel);
		panel.setLayout(null);
			
		JMenu mnServios = new JMenu("Hospede");
		mnServios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setBounds(-100, 0, 165, 577);
				JButton btnNewButton = new JButton("Novo Hospede");
				btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
				btnNewButton.setBounds(101, 28, 402, 145);
				add(btnNewButton);
				
				JButton btnAtualizarInformaes = new JButton("Atualizar Informa\u00E7\u00F5es");
				btnAtualizarInformaes.setFont(new Font("Arial Black", Font.PLAIN, 14));
				btnAtualizarInformaes.setBounds(101, 373, 402, 145);
				add(btnAtualizarInformaes);
				
				JButton btnVisualizarInformaes = new JButton("Visualizar Informa\u00E7\u00F5es");
				btnVisualizarInformaes.setFont(new Font("Arial Black", Font.PLAIN, 14));
				btnVisualizarInformaes.setBounds(101, 198, 402, 145);
				add(btnVisualizarInformaes);
				repaint();
				

			}
		});
		
		mnServios.setBounds(0, 0, 150, 95);
		panel.add(mnServios);
		mnServios.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		
		JMenu mnServios_1 = new JMenu("Servi\u00E7os");
		mnServios_1.setBounds(0, 95, 150, 95);
		panel.add(mnServios_1);
		mnServios_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		
		JMenu mnContratos = new JMenu("Contratos");
		mnContratos.setBounds(0, 189, 150, 95);
		panel.add(mnContratos);
		mnContratos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Sistema.setTela(new NovoContrato());
				
			}
		});
		mnContratos.setBackground(new Color(32, 178, 170));
		mnContratos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		
		JMenu mnOpinies = new JMenu("Opini\u00F5es");
		mnOpinies.setBounds(0, 284, 150, 95);
		panel.add(mnOpinies);
		mnOpinies.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		
		JMenu mnAcessoRestrito = new JMenu("Restrito");
		mnAcessoRestrito.setBounds(0, 378, 150, 95);
		panel.add(mnAcessoRestrito);
		mnAcessoRestrito.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		
		JMenu mnSair = new JMenu("Sair");
		mnSair.setBounds(0, 477, 150, 100);
		panel.add(mnSair);
		mnSair.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
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
			repaint();
			Sistema.setTela(new NovoContrato());
			repaint();
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