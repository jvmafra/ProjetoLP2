package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPanel;

public class PaginaInicialHotel extends JFrame {
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
	 * @param CadastroHospede 
	 */
	
	public PaginaInicialHotel() {
	
		setTitle("\u00C1rea do funcion\u00E1rio");
		setBounds(100, 100, 835, 590);		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
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

//		JFrame framePrincipal = new CadastroHospede();
//		framePrincipal.setBounds(12, 12, 811, 517);
//		setContentPane(framePrincipal);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Contrato");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			CadastroHospede cadastro = new CadastroHospede();
			cadastro.setVisible(true);
			setVisible(false);
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Serviços");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Contratos Abertos");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_4 extends AbstractAction {
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