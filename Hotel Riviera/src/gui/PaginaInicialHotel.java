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

public class PaginaInicialHotel extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaInicialHotel frame = new PaginaInicialHotel();
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
	public PaginaInicialHotel() {
		setTitle("\u00C1rea do funcion\u00E1rio");
		setBounds(100, 100, 494, 383);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu novo = new JMenu("Novo");
		menuBar.add(novo);
		
		JRadioButtonMenuItem contrato = new JRadioButtonMenuItem("Contrato");
		novo.add(contrato);
		
		JRadioButtonMenuItem servico = new JRadioButtonMenuItem("Servi\u00E7o");
		novo.add(servico);
		
		JMenu contratos = new JMenu("Contratos");
		menuBar.add(contratos);
		
		JRadioButtonMenuItem contratos_aberto = new JRadioButtonMenuItem("Contratos em aberto");
		contratos.add(contratos_aberto);
		
		JRadioButtonMenuItem contratos_fechados = new JRadioButtonMenuItem("Contratos fechados");
		contratos.add(contratos_fechados);
		
		JMenu relatorios = new JMenu("Relat\u00F3rio");
		menuBar.add(relatorios);
		
		JRadioButtonMenuItem quartos = new JRadioButtonMenuItem("Quartos dispon\u00EDveis");
		relatorios.add(quartos);
		
		JRadioButtonMenuItem servicos_disponiveis = new JRadioButtonMenuItem("Servi\u00E7os dispon\u00EDveis");
		relatorios.add(servicos_disponiveis);
		
		JMenuItem mntmOpinies = new JMenuItem("Opini\u00F5es");
		relatorios.add(mntmOpinies);
		
		JMenu faturamento = new JMenu("Faturamento");
		menuBar.add(faturamento);
		
		JMenu sobre = new JMenu("Sobre");
		menuBar.add(sobre);
		
		JMenu sair = new JMenu("Sair");
		menuBar.add(sair);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
