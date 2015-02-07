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
	
		setBounds(100, 100, 835, 590);		
		JMenuBar menuBar = new JMenuBar();
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

		add(menuBar);
//		JFrame framePrincipal = new CadastroHospede();
//		framePrincipal.setBounds(12, 12, 811, 517);
//		setContentPane(framePrincipal);
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
			Sistema.setTela(new NovoContrato());
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
		public SwingAction_5() {
			putValue(NAME, "Quartos Disponiveis");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "Serviços Disponiveis");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}	