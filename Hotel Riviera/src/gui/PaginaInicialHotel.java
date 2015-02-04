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
import javax.swing.JTextField;

import classes.Arquivos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaginaInicialHotel extends JFrame {
	private JTextField login;
	private JTextField senha;

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
		setBounds(100, 100, 799, 507);
		
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
		
		login = new JTextField();
		login.setColumns(10);
		
		senha = new JTextField();
		senha.setColumns(10);
		
		JButton confirmar = new JButton("Confirmar");
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Sistema.getHotel().cadastraFuncionario(login.getText(), senha.getText());
					Arquivos.salvaHotel(Sistema.getHotel());
					System.out.println(Sistema.getHotel().getFuncionarios().size());
				} catch (Exception e) {
					System.out.println("Nao foi possivel cadastrar");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(63)
							.addComponent(login, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(119)
							.addComponent(confirmar)))
					.addContainerGap(512, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(login, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(confirmar)
					.addContainerGap(298, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
