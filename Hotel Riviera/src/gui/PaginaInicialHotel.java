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
		setBounds(100, 100, 568, 492);
		setLayout(new MigLayout("", "[166px]", "[82px][82px][82px][82px][82px][82px]"));
		
		JMenu mnServios = new JMenu("Hospede");
		add(mnServios, "cell 0 0,alignx left,growy");
		mnServios.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		
		JMenu mnServios_1 = new JMenu("Servi\u00E7os");
		add(mnServios_1, "cell 0 1,alignx left,growy");
		mnServios_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		
		JMenu mnContratos = new JMenu("Contratos");
		add(mnContratos, "cell 0 2,alignx left,growy");
		mnContratos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Sistema.setTela(new NovoContrato());
				
			}
		});
		mnContratos.setBackground(new Color(32, 178, 170));
		mnContratos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		
		JMenu mnOpinies = new JMenu("Opini\u00F5es");
		add(mnOpinies, "cell 0 3,alignx left,growy");
		mnOpinies.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		
		JMenu mnAcessoRestrito = new JMenu("Restrito");
		add(mnAcessoRestrito, "cell 0 4,alignx left,growy");
		mnAcessoRestrito.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		
		JMenu mnSair = new JMenu("Sair");
		mnSair.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		add(mnSair, "cell 0 5,alignx left,growy");

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