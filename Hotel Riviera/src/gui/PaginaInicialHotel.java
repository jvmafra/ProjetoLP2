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
		setBounds(100, 100, 174, 577);
		setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(148, 11, 468, 34);
		//setJMenuBar(menuBar);
		
		JMenu novo = new JMenu("Novo");
		menuBar.add(novo);
		
		JMenuItem menuItem = novo.add(action_2);
		
		JMenuItem menuItem_1 = novo.add(action_3);
		
		JMenu contratos = new JMenu("Contratos");
		menuBar.add(contratos);
		
		JMenuItem menuItem_2 = contratos.add(action_4);
		
		JMenuItem menuItem_3 = contratos.add(action_5);
		
		JMenu relatorios = new JMenu("Relat\u00F3rio");
		menuBar.add(relatorios);
		
		JMenuItem menuItem_4 = relatorios.add(action_6);
		
		JMenuItem menuItem_5 = relatorios.add(action_7);
		
		JMenuItem mntmOpinies = new JMenuItem("Opini\u00F5es");
		relatorios.add(mntmOpinies);
		
		JMenu faturamento = new JMenu("Faturamento");
		menuBar.add(faturamento);
		
		JMenu sobre = new JMenu("Sobre");
		menuBar.add(sobre);
		
		JMenu sair = new JMenu("Sair");
		menuBar.add(sair);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 160, 520);
		
		JMenu mnContratos = new JMenu("Contratos");
		mnContratos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Sistema.setTela(new NovoContrato());
				
			}
		});
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		mnContratos.setBackground(new Color(32, 178, 170));
		mnContratos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		panel.add(mnContratos);
		
		JMenu mnServios = new JMenu("Hospede");
		mnServios.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		panel.add(mnServios);
		
		JMenu mnServios_1 = new JMenu("Servi\u00E7os");
		mnServios_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		panel.add(mnServios_1);
		
		JMenu mnOpinies = new JMenu("Opini\u00F5es");
		mnOpinies.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		panel.add(mnOpinies);
		
		JMenu mnAcessoRestrito = new JMenu("Restrito");
		mnAcessoRestrito.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		panel.add(mnAcessoRestrito);
		
		add(panel);
		//add(menuBar);

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